package db

import models.Category

/**
  * Created by Pedro Lopes on 21/06/2017.
  */
trait CategoriesTable { this: Db =>

  import config.driver.api._

  private class Categories(tag: Tag) extends Table[Category](tag, "CATEGORIES") {

    //collumns
    def categoryId = column[Int]("UserId", O.PrimaryKey, O.AutoInc)
    def groupId = column[Int]("GroupId")
    def name = column[String]("Name")
    def catType = column[Enum[String]]("Type")
    def total = column[Double]("Total")

    //select
    def * = (categoryId, groupId, name, catType, total) <> (Category.tupled, Category.unapply)
  }

  var categories = TableQuery[CategoriesTable]

}