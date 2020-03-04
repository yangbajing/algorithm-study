import Commons._

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "2.13.1"

ThisBuild / shellPrompt := (s => Project.extract(s).currentProject.id + " > ")

ThisBuild / scalafmtOnCompile := true

lazy val root = Project(id = "algorithm-study-root", base = file("."))
  .aggregate(algorithm, algocasts, algs4Scala, algs4, studyCommon)
  .settings(headerLicense := None)

lazy val leetcode = _project("leetcode").dependsOn(studyCommon % "compile->compile;test->test")

lazy val algorithm = _project("algorithm").dependsOn(studyCommon % "compile->compile;test->test")

lazy val algocasts = _project("algocasts").dependsOn(studyCommon % "compile->compile;test->test")

lazy val algs4Scala = _project("algs4-scala").dependsOn(studyCommon % "compile->compile;test->test")

lazy val algs4 = _project("algs4").dependsOn(studyCommon % "compile->compile;test->test")

lazy val studyCommon = _project("study-common").settings(
  libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % scalaVersion.value,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "org.scalatest" %% "scalatest" % "3.1.0" % Test))

def _project(name: String, _base: String = null) =
  Project(id = name, base = file(if (_base eq null) name else _base)).settings(basicSettings: _*)
