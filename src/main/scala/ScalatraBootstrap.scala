/**
  * Created by Pedro Lopes on 20/06/2017.
  */
import javax.servlet.ServletContext

import controllers.HomeController
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {

    // Home controller
    context mount (new HomeController, "/")


  }
}