package com.jarvis.utils

import org.apache.spark.sql.{Row, SaveMode, SparkSession}
import scala.math.BigDecimal

class Test {
  test("basic") {
    val spark = SparkSession
      .builder()
      .appName("Test")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()
  	  
    import spark.implicits._
    import spark.sql
  
    // src table
    sql(s"DROP TABLE IF EXISTS src")
  
    sql(s"""CREATE TABLE src (foo String, bar long NOT NULL, baz BigDecimal)
    PARITIONED BY (part String)""".stripMargin)
  
    sql("set hive.exec.dynamic.partition=true")
    sql("set hive.exec.dynamic.partition.mode=nonstrict")
  
    sql(s"INSERT INTO src VALUES('sample1 text', 1, 1.01, 'sample1')")
    sql(s"INSERT INTO src VALUES('sample2 text', 2, 2.02, 'sample2')")
    sql(s"INSERT INTO src VALUES('sample3 text', 3, 3.03, 'sample3')")
  
    sql(s"SELECT * from src").show()
  
    // backup table
    sql(s"DROP TABLE IF EXISTS backup")
  
    sql(s"""CREATE TABLE backup (foo String, bar long NOT NULL, baz BigDecimal)
    PARITIONED BY (part String)""".stripMargin)
  
    sql("set hive.exec.dynamic.partition=true")
    sql("set hive.exec.dynamic.partition.mode=nonstrict")
    
    sql(s"INSERT INTO backup VALUES('sample4 text', 4, 4.04, 'sample1')")
    sql(s"INSERT INTO backup VALUES('sample5 text', 5, 5.05, 'sample2')")
    sql(s"INSERT INTO backup VALUES('sample6 text', 6, 6.06, 'sample3')")
  
    sql(s"INSERT OVERWRITE backup PARTITION (part) SELECT * FROM $src")
  
    sql(s"SELECT * FROM backup").show()
  }
}
