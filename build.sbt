name := "OurExpenses"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.5.1",
  "org.scalatra" %% "scalatra-auth" % "2.5.1",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container,compile",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016")

Seq(webSettings :_*)