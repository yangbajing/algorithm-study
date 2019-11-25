import Commons._
import Dependencies._

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := Dependencies.versionScala

ThisBuild / shellPrompt := (s => Project.extract(s).currentProject.id + " > ")

ThisBuild / scalafmtOnCompile := true

lazy val root = Project(id = "algorithm-study-root", base = file("."))
  .aggregate(algorithm, algocasts, slf4j, studyCommon)
  .settings(headerLicense := None)

lazy val algorithm = _project("algorithm").dependsOn(studyCommon % "compile->compile;test->test")

lazy val algocasts = _project("algocasts").dependsOn(studyCommon % "compile->compile;test->test")

lazy val slf4j = _project("algs4").dependsOn(studyCommon % "compile->compile;test->test")

lazy val studyCommon = _project("study-common").settings(
  libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % scalaVersion.value,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      _scalaJava8Compat,
      _scalatest % Test) ++ _logs)

def _project(name: String, _base: String = null) =
  Project(id = name, base = file(if (_base eq null) name else _base)).settings(basicSettings: _*)
