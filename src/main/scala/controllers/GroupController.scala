package controllers

import org.scalatra.ScalatraServlet


/**
  * Created by Pedro Lopes on 20/06/2017.
  */
class GroupController extends ScalatraServlet with AuthenticationSupport{

  /*
  override protected implicit lazy val jsonFormats: Formats = DefaultFormats

  val groups = List(
    Group(1,"Scala Group"),
    Group(2,"My Expenses")
  )

  before(){
    basicAuth
    contentType = formats("json")
  }

  get("/"){
    groups
  }

  post("/"){
    val jsonString = parse(request.body)
    val group = jsonString.extract[Group]

    if(response.getStatus == 200){
      List(group)
    }
  }
  */

  get("/:groupId"){

  }

}
