package com.jarvis.utils

import org.apache.spark.sql.SparkSession
import scala.math.BigDecimal

object HiveTables extends App {

  def main(args: Array[String]): Unit = {
    if (args.length < 2 || args.length > 2) {
      System.err.println("invalid number of arguments")
      System.exit(1)
    }

    val spark = SparkSession
      .builder()
      .appName("Scala")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()

    sql("DROP TABLE IF EXISTS src")

    sql("DROP TABLE IF EXISTS backup")

    // create the tables
    sql("""CREATE TABLE src (foo String NULL, bar long NOT NULL, baz BigDecimal NULL)
    PARITIONED BY (part String)""".stripMargin)

    sql("""CREATE TABLE backup (foo String NULL, bar long NOT NULL, baz BigDecimal NULL)
    PARITIONED BY (part String)""".stripMargin)

    sql("set hive.exec.dynamic.partition=true")
    sql("set hive.exec.dynamic.partition.mode=nonstrict")

    sql(s"""LOAD DATA LOCAL INPATH "${args(0)}" INTO TABLE src""")

    sql(s"""LOAD DATA LOCAL INPATH "${args(1)}" INTO TABLE backup""")

    val sqlDF = sql("SELECT * FROM src")
    val backupDF = sql("SELECT * FROM backup")

    // update backup table with new data and overwriting old data
    val updateDF = sql("SELECT sqlDF .* from sqlDF join backupDF on sqlDF.part = backupDF.part")
    val totalDF = sqlDF.except(updateDF).union(backupDF)
    totalDF.write.mode(SaveMode.Overwrite).saveAsTable("tempTable")

    // write to backup table
    sql("INSERT OVERWRITE backup PARTITION (part) SELECT * FROM tempTable")

    sparkContext.stop()
  }
}