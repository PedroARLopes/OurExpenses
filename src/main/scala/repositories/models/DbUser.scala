package repositories.models

/**
  * Created by Pedro Lopes on 23/06/2017.
  */
import slick.jdbc.MySQLProfile.api._

class DbUser(tag: Tag) extends Table[(Int, String, String, String)](tag, "user") {

  def id = column[Int]("UserId", O.PrimaryKey, O.AutoInc)

  def name = column[String]("Name")

  def email = column[String]("Email")

  def password = column[String]("Password")

  def * = (id, name, email, password)

}
