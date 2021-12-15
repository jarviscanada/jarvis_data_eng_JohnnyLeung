package com.jarvis.utils

import org.apache.spark.sql.SparkSession
import scala.math.BigDecimal

import org.scalatest.flatspec.AnyFlatSpec

class FirstSpec extends AnyFlatSpec {
  val sparkContext = new SparkContext(
    new SparkConf()
      .setMaster("local")
      .setAppName(getClass.getSimpleName.stripSuffix("$")))

  val hiveContext = new LocalHiveContext(sparkContext)

  import hiveContext._

  test("create src and copy to backup") {
    // src
    sql("DROP TABLE IF EXISTS src")

    sql("""CREATE TABLE src (foo String NULL, bar long NOT NULL, baz BigDecimal NULL)
    PARITIONED BY (part String)""".stripMargin)

    sql("set hive.exec.dynamic.partition=true")
    sql("set hive.exec.dynamic.partition.mode=nonstrict")

    sql("INSERT INTO src VALUES('sample1 data', 1, 1.01, 'sample1')")
    sql("INSERT INTO src VALUES('sample2 data', 2, 2.01, 'sample2')")
    sql("INSERT INTO src VALUES('sample3 data', 3, 3.01, 'sample3')")

    sql("SELECT * FROM src").show()

    // backup
    sql("DROP TABLE IF EXISTS backup")

    sql("""CREATE TABLE backup (foo String NULL, bar long NOT NULL, baz BigDecimal NULL)
    PARITIONED BY (part String)""".stripMargin)

    sql("set hive.exec.dynamic.partition=true")
    sql("set hive.exec.dynamic.partition.mode=nonstrict")

    sql("INSERT INTO backup VALUES('sample4 data', 4, 4.01, 'sample4')")
    sql("INSERT INTO backup VALUES('sample5 data', 5, 5.01, 'sample5')")
    sql("INSERT INTO backup VALUES('sample6 data', 6, 6.01, 'sample6')")

    sql("INSERT INTO backup SELECT * from src").show()

    sql("INSERT OVERWRITE backup PARTITION (part) SELECT * FROM src")

    sql("SELECT * FROM backup").show()
  }
}