package db

import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

/**
  * Created by Pedro Lopes on 21/06/2017.
  */
trait DbConfiguration {
  lazy val config = DatabaseConfig.forConfig[JdbcProfile]("db")
}