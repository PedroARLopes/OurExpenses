package db

import models.User
import slick.lifted.TableQuery

/**
  * Created by Pedro Lopes on 21/06/2017.
  */
trait UsersTable { this: Db =>

  import config.driver.api._

  private class Users(tag: Tag) extends Table[User](tag, "USERS") {

    //collumns
    def userId = column[Int]("UserId", O.PrimaryKey, O.AutoInc)
    def name = column[String]("Name")
    def email = column[String]("Email")
    def password = column[String]("Password")

    //select
    def * = (userId, name, email, password) <> (User.tupled, User.unapply)
  }

  var users = TableQuery[UsersTable]

}