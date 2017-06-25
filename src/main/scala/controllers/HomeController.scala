package controllers

import org.scalatra._
import repositories.UsersRepository

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
class HomeController(val usersRepository: UsersRepository) extends ScalatraServlet
  with AuthenticationSupport with FutureSupport {

  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

  get("/users"){

    usersRepository.getUserById(1) match {
      case Some(user) => Ok(user)
      case None => NotFound("User was not found!")
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
