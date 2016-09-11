name := """BlueBird"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "mysql" % "mysql-connector-java" % "6.0.3"
)

// WebjarsRepository
libraryDependencies ++= Seq(
  "org.webjars" % "bootstrap" % "3.3.7-1"
)