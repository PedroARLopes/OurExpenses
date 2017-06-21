package models

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
object CategoryType extends Enumeration { val Expense, Income = Value }

case class Category(CategoryId: Int, GroupId: Int, Name: String, Type: CategoryType.Value, Total: Double = 0.0)
