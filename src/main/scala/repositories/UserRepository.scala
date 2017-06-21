package repositories

import db.{Db, UsersTable}
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

/**
  * Created by Pedro Lopes on 21/06/2017.
  */
class UserRepository(val config: DatabaseConfig[JdbcProfile]) extends Db with UsersTable {

  

}