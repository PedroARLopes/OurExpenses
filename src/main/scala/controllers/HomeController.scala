package controllers

import org.scalatra._

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
class HomeController extends ScalatraServlet with AuthenticationSupport {

  get("/*"){
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
