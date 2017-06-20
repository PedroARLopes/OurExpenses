package controllers

import models.Group
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
class GroupController extends ScalatraServlet with JacksonJsonSupport with AuthenticationSupport{

  override protected implicit lazy val jsonFormats: Formats = DefaultFormats

  before(){
    basicAuth
    contentType = formats("json")
  }

  get("/"){
    List(
      Group(1,"Scale Group"),
      Group(2,"My Expenses")
    )
  }

}
