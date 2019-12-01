lazy val root = (project in file("."))
  .settings(name := "Advent of Code")
  .settings(moduleName := "aoc")
  .settings(version := "0.1")
  .settings(scalaVersion := "2.13.1")
  .settings(libraryDependencies ++= dependencies)

lazy val dependencies = Seq("org.scalatest" %% "scalatest"   % "3.1.0"  % "test")

scalacOptions ++= Seq("-deprecation", "-feature")