package repositories

/**
  * Created by Pedro Lopes on 23/06/2017.
  */
import repositories.models.DbUser
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

class UsersRepository(var db: Database) {
  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

  var users = TableQuery[DbUser]

  def getUserById(id: Int): Option[(Int, String, String, String)] = {
    Await.result(db.run(users.filter(_.id === id).result.headOption), 10 seconds)
  }

  def getUserEmailAndPassword(email: String, password: String): Option[(Int, String, String, String)] = {
    Await.result(db.run(users.filter(_.email === email)
      .filter(_.password === password)
      .result.headOption), 10 seconds)
  }
}
