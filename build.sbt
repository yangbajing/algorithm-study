import Commons._
import Dependencies._

lazy val root = Project(id = "algorithm-study-root", base = file("."))
  .aggregate(
    algorithm,
    studyCommon
  )
  .settings(Publishing.noPublish: _*)
  .settings(Environment.settings: _*)
  .settings(headerLicense := None)

lazy val algorithm = _project("algorithm")
  .dependsOn(
    studyCommon % "compile->compile;test->test"
  )

lazy val studyCommon = _project("study-common")
  .settings(Publishing.publishing: _*)
  .settings(
    libraryDependencies ++= Seq(
      _scalaLogging,
      _logbackClassic,
      _config,
      _scalaXml,
      "org.scala-lang" % "scala-library" % scalaVersion.value,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      _scalaJava8Compat,
      _scalatest % Test
    )
  )

def _project(name: String, _base: String = null) =
  Project(id = name, base = file(if (_base eq null) name else _base))
    .settings(basicSettings: _*)
