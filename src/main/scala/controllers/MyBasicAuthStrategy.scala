package controllers

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import models.User
import org.scalatra.ScalatraBase
import org.scalatra.auth.strategy.{BasicAuthStrategy, BasicAuthSupport}
import org.scalatra.auth.{ScentryConfig, ScentrySupport}

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
class MyBasicAuthStrategy(protected override val app: ScalatraBase, realm: String)
  extends BasicAuthStrategy[User](app,realm) {

  override protected def validate(userName: String, password: String)(implicit request: HttpServletRequest, response: HttpServletResponse): Option[User] = {
    if (userName == "pedrolopes@gmail.com" && password == "password") Some(User(1,"pedrolopes@gmail.com","password"))
    else None
  }

  protected def getUserId(user: User)(implicit request: HttpServletRequest, response: HttpServletResponse):
    String = user.UserId.toString
}

trait AuthenticationSupport extends ScentrySupport[User] with BasicAuthSupport[User] {
  self: ScalatraBase =>

  var realm = "Basic Auth Example"

  protected def fromSession = { case email: String => User(1,email,"")}

  protected def toSession = { case user: User => user.Email }

  protected val scentryConfig = new ScentryConfig {}.asInstanceOf[ScentryConfiguration]

  override protected def configureScentry() = {
    scentry.unauthenticated {
      scentry.strategies("Basic").unauthenticated()
    }
  }

  override protected def registerAuthStrategies() = {
    scentry.register("Basic", app => new MyBasicAuthStrategy(app, realm))
  }
}