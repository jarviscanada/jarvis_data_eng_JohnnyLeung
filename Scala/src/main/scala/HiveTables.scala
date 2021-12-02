package com.jarvis.utils

import org.apache.spark.sql.{Row, SaveMode, SparkSession}
import scala.math.BigDecimal

object HiveTables extends App {

  def main(args: Array[String]): Unit = {
    if (args.length < 2 || args.length > 2) {
      System.err.println("invalid number of arguments")
      System.exit(1)
    }
    
    val spark = SparkSession
      .builder()
      .appName("HiveTables")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()
  	  
    import spark.implicits._
    import spark.sql

    sql(s"DROP TABLE IF EXISTS $src")
    
    sql(s"DROP TABLE IF EXISTS $backup")

    // create the tables
    sql(s"""CREATE TABLE $src (foo String, bar long NOT NULL, baz BigDecimal)
    PARITIONED BY (part String)""".stripMargin)
      
    sql(s"""CREATE TABLE $backup (foo String, bar long NOT NULL, baz BigDecimal)
    PARITIONED BY (part String)""".stripMargin)
    
    sql("set hive.exec.dynamic.partition=true")
    sql("set hive.exec.dynamic.partition.mode=nonstrict")

    sql(s"""LOAD DATA LOCAL INPATH "${args(0)}" INTO TABLE $src""")
  
    sql(s"""LOAD DATA LOCAL INPATH "${args(1)}" INTO TABLE $backup""")
  
    val srcDF = sql("SELECT * FROM $src")
    val backupDF = sql("SELECT * FROM $backup")
  
    // update backup table with new data and overwriting old data
    val updateDF = sql("SELECT $srcDF .* from $srcDF join $backupDF on $srcDF.part = $backupDF.part")
    val totalDF = $srcDF.except($updateDF).union($backupDF)
    totalDF.write.mode(SaveMode.Overwrite).saveAsTable("tempTable")
  	
    // write to backup table
    sql(s"INSERT OVERWRITE $backup PARTITION (part) SELECT * FROM $tempTable")

    sparkContext.stop()
  }
}
