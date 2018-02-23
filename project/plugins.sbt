// Comment to get more information during initialization
logLevel := Level.Warn

resolvers += Resolver.sbtPluginRepo("releases")

addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.4.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.2")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.3.2")

addSbtPlugin("com.lightbend.akka" % "sbt-paradox-akka" % "0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")
