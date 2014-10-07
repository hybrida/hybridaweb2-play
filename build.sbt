name := """webkom-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  javaJpa,
  "org.mindrot" % "jbcrypt" % "0.3m",
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.apache.directory.studio" % "org.apache.commons.io" % "2.4"
)
