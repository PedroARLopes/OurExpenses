package db

import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

/**
  * Created by Pedro Lopes on 21/06/2017.
  */
trait Db {
  val config: DatabaseConfig[JdbcProfile]
  val db: JdbcProfile#Backend#Database = config.db
}