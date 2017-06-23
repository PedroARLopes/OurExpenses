/**
  * Created by Pedro Lopes on 20/06/2017.
  */
import javax.servlet.ServletContext

import com.mchange.v2.c3p0.ComboPooledDataSource
import controllers.{GroupController, HomeController}
import org.scalatra._
import org.slf4j.LoggerFactory
import repositories.UsersRepository
import slick.jdbc.MySQLProfile.api._


class ScalatraBootstrap extends LifeCycle {

  val logger = LoggerFactory.getLogger(getClass)

  var cpds =  new ComboPooledDataSource

  logger.info("Created c3p0 connection pool")

  override def init(context: ServletContext) {

    val db = Database.forDataSource(cpds, Option(10))

    // Home controller
    context mount (new HomeController(new UsersRepository(db)), "/")

    //Groups Controller
    context mount (new GroupController, "/groups")

  }

  private def closeDbConnection() {
    logger.info("Closing c3p0 connection pool")
    cpds.close()
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    closeDbConnection()
  }
}