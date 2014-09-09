name := """webkom-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  javaJpa
)

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final" // replace by your jpa implementation

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"
