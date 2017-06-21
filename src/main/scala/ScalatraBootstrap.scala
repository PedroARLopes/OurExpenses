/**
  * Created by Pedro Lopes on 20/06/2017.
  */
import java.util.Properties
import javax.servlet.ServletContext

import com.mchange.v2.c3p0.ComboPooledDataSource
import controllers.{GroupController, HomeController}
import org.scalatra._
import org.slf4j.LoggerFactory
import slick.jdbc.H2Profile.api._

class ScalatraBootstrap extends LifeCycle {

  val logger = LoggerFactory.getLogger(getClass)

  var cpds = {
    val props = new Properties
    props.load(getClass.getResourceAsStream("/c3p0.properties"))
    val cpds = new ComboPooledDataSource
    cpds.setProperties(props)
    logger.info("Created c3p0 connection pool")
    cpds
  }

  override def init(context: ServletContext) {

    val db = Database.forDataSource(cpds,None)

    //val db = Database.forURL("jdbc:mysql://localhost/ourexpenses", user="root", password="password", driver = "com.mysql.jdbc.Driver")

    // Home controller
    context mount (new HomeController(db), "/")

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