package repositories

/**
  * Created by Pedro Lopes on 23/06/2017.
  */
import models.{DbUser}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Future

class UsersRepository(var db: Database) {
  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

  var users = TableQuery[DbUser]

  def getUserById(id: Int): Future[Option[(Int, String, String, String)]] = {
    db.run(users.filter(_.id === id).result.headOption)
  }

  def getUserPasswordByEmail(email: String): Future[Option[(String)]] = {
    db.run(users.filter(_.email === email).map(_.password).result.headOption)
  }
}
