import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport.{ HeaderLicense, headerLicense }
import sbt.Keys._
import sbt._

object Commons {
  import sbtassembly.AssemblyKeys.{ assembly, assemblyMergeStrategy }
  import sbtassembly.{ MergeStrategy, PathList }

  def basicSettings =
    Seq(
      organization := "me.yangbajing",
      organizationName := "Yangbajing's Garden",
      organizationHomepage := Some(url("https://yangbajing.me")),
      homepage := Some(url("http://www.yangbajing.me/algorithm/study/")),
      startYear := Some(2018),
      licenses += ("MIT", new URL("https://opensource.org/licenses/MIT")),
      headerLicense := Some(HeaderLicense.MIT("2018", "Yang Jing")),
      scalacOptions ++= Seq(
          "-encoding",
          "UTF-8", // yes, this is 2 args
          "-feature",
          "-deprecation",
          "-unchecked",
           "-Xlint:_",
          "-Ywarn-dead-code"
          // "-Xfuture" // breaks => Unit implicits
        ),
      javacOptions in Compile ++= Seq("-Xlint:unchecked", "-Xlint:deprecation"),
      javaOptions in run ++= Seq("-Xms128m", "-Xmx1024m", "-Djava.library.path=./target/native"),
      shellPrompt := { s =>
        Project.extract(s).currentProject.id + " > "
      },
      assemblyMergeStrategy in assembly := {
        case PathList("javax", "servlet", xs @ _*)                => MergeStrategy.first
        case PathList("io", "netty", xs @ _*)                     => MergeStrategy.first
        case PathList("jnr", xs @ _*)                             => MergeStrategy.first
        case PathList("com", "datastax", xs @ _*)                 => MergeStrategy.first
        case PathList("com", "kenai", xs @ _*)                    => MergeStrategy.first
        case PathList("org", "objectweb", xs @ _*)                => MergeStrategy.first
        case PathList(ps @ _*) if ps.last endsWith ".html"        => MergeStrategy.first
        case "application.conf"                                   => MergeStrategy.concat
        case "META-INF/io.netty.versions.properties"              => MergeStrategy.first
        case PathList("org", "slf4j", xs @ _*)                    => MergeStrategy.first
        case "META-INF/native/libnetty-transport-native-epoll.so" => MergeStrategy.first
        case x =>
          val oldStrategy = (assemblyMergeStrategy in assembly).value
          oldStrategy(x)
      },
      //      resolvers ++= Seq(
      //      "elasticsearch-releases" at "https://artifacts.elastic.co/maven"
      //  )
      fork in run := true,
      fork in Test := true,
      parallelExecution in Test := false)
}
