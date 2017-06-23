package controllers

import org.scalatra._
import repositories.UsersRepository

import scala.util.{Failure, Success}

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
class HomeController(val usersRepository: UsersRepository) extends ScalatraServlet
  with AuthenticationSupport with FutureSupport {

  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

  get("/users"){

    var output = usersRepository.getUserById(1)

    output.onComplete {
      case Success(value) => println(value.get)
      case Failure(e) => e.printStackTrace
    }
  }

  get("/auth"){
    basicAuth
    <html>
      <h1>Welcome to OurExpenses</h1>
      <body>
        <p>
          You are now authenticated!
        </p>
        </body>
    </html>
  }
}
