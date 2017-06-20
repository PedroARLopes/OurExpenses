package models

/**
  * Created by Pedro Lopes on 20/06/2017.
  */
object CollaboratorType extends Enumeration { val Owner, Collaborator = Value }

case class Collaborator(CollaboratorId:  Int, UserId: Int, GroupId: Int, enum: CollaboratorType.Value)