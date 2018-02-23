import sbt._

object Dependencies {
  val versionScala = "2.12.4"
  val versionScalaLib = "2.12"

  val _scalaXml = ("org.scala-lang.modules" %% "scala-xml" % "1.0.6").exclude("org.scala-lang", "scala-library")

  val _scalaJava8Compat = ("org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0").exclude("org.scala-lang", "scala-library")

  val _scalatest = "org.scalatest" %% "scalatest" % "3.0.4"

  val versionAkka = "2.5.9"
  lazy val _akkaRemote = "com.typesafe.akka" %% "akka-remote" % versionAkka

  lazy val _akkas = Seq(
    "com.typesafe.akka" %% "akka-slf4j" % versionAkka,
    "com.typesafe.akka" %% "akka-stream" % versionAkka,
    "com.typesafe.akka" %% "akka-testkit" % versionAkka % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versionAkka % Test
  ).map(_.exclude("org.scala-lang.modules", s"scala-java8-compat").cross(CrossVersion.binary))

  lazy val _akkaMultiNodeTestkit = "com.typesafe.akka" %% "akka-multi-node-testkit" % versionAkka % Test

  lazy val _akkaClusterSharding = "com.typesafe.akka" %% "akka-cluster-sharding" % versionAkka

  lazy val _akkaClusters = Seq(
    "com.typesafe.akka" %% "akka-cluster" % versionAkka,
    "com.typesafe.akka" %% "akka-cluster-tools" % versionAkka,
    "com.typesafe.akka" %% "akka-cluster-metrics" % versionAkka,
    _akkaMultiNodeTestkit
  )

  lazy val _akkaManagement = "com.lightbend.akka.management" %% "akka-management" % "0.10.0"

  val versionAkkaHttp = "10.0.11"
  val _akkaHttpCore = "com.typesafe.akka" %% "akka-http-core" % versionAkkaHttp

  val _akkaHttps = Seq(
    "com.typesafe.akka" %% "akka-http" % versionAkkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % versionAkkaHttp % Test
  ).map(_
    .exclude("com.typesafe.akka", "akka-stream").withCrossVersion(CrossVersion.binary)
    .exclude("com.typesafe.akka", "akka-stream-testkit").withCrossVersion(CrossVersion.binary))

  private val versionAlpakka = "0.16"
  val _alpakkaSimpleCodecs = ("com.lightbend.akka" %% "akka-stream-alpakka-simple-codecs" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaXml = ("com.lightbend.akka" %% "akka-stream-alpakka-xml" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaCsv = ("com.lightbend.akka" %% "akka-stream-alpakka-csv" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaFile = ("com.lightbend.akka" %% "akka-stream-alpakka-file" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaFtp = ("com.lightbend.akka" %% "akka-stream-alpakka-ftp" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaUnixDomainSocket = ("com.lightbend.akka" %% "akka-stream-alpakka-unix-domain-socket" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaMongodb = ("com.lightbend.akka" %% "akka-stream-alpakka-mongodb" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkaCassandra = ("com.lightbend.akka" %% "akka-stream-alpakka-cassandra" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"), ExclusionRule("com.datastax.cassandra"), ExclusionRule("io.netty"), ExclusionRule("com.google.guava"))

  val _alpakkaElasticsearch = ("com.lightbend.akka" %% "akka-stream-alpakka-elasticsearch" % versionAlpakka)
    .excludeAll(ExclusionRule("com.typesafe.akka"))

  val _alpakkas = Seq(
    _alpakkaXml,
    _alpakkaCsv,
    _alpakkaSimpleCodecs,
    _alpakkaUnixDomainSocket,
    _alpakkaFile,
    _alpakkaFtp
  )

  val _akkaPersistenceCassandra = Seq(
    "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.80",
    "com.typesafe.akka" %% "akka-persistence-cassandra-launcher" % "0.80" % Test
  )

  val _akkaStreamKafka = ("com.typesafe.akka" %% "akka-stream-kafka" % "0.19")
    .exclude("com.typesafe.akka", "akka-slf4j").cross(CrossVersion.binary)

  val _config = "com.typesafe" % "config" % "1.3.2"

  val _hanlp = "com.hankcs" % "hanlp" % "portable-1.5.3"

  private val versionJackson = "2.9.2"
  val _jacksons = Seq(
    "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % versionJackson,
    "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % versionJackson,
    "com.fasterxml.jackson.module" % "jackson-module-parameter-names" % versionJackson,
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % versionJackson
  )

  val _aspectjweaver = "org.aspectj" % "aspectjweaver" % "1.8.13"

  val _sigarLoader = "io.kamon" % "sigar-loader" % "1.6.6-rev002"

  private val versionKamon = "1.0.1"
  val _kamonAkka = ("io.kamon" %% "kamon-akka-2.5" % versionKamon)
    .exclude("com.typesafe.akka", "akka-actor").cross(CrossVersion.binary)
    .exclude("org.scala-lang", "scala-library")

  val _kamonAkkaHttp = ("io.kamon" %% "kamon-akka-http-2.5" % versionKamon)
    .exclude("io.kamon", "kamon-akka-2.5").cross(CrossVersion.binary)
    .exclude("com.typesafe.akka", "akka-http").cross(CrossVersion.binary)
    .exclude("com.typesafe.akka", "akka-stream").cross(CrossVersion.binary)
    .exclude("org.scala-lang", "scala-library")

  // need aspectjweaver
  val _kamonAkkaRemote = ("io.kamon" %% "kamon-akka-remote-2.5" % "1.0.0")
    .excludeAll(ExclusionRule("com.typesafe.akka")).cross(CrossVersion.binary)
    .exclude("org.scala-lang", "scala-library")

  val _kamonSystemMetrics = ("io.kamon" %% "kamon-system-metrics" % "1.0.0")
    .exclude("io.kamon", "kamon-core").cross(CrossVersion.binary)
    .exclude("org.scala-lang", "scala-library")

  val _kamons = Seq(
    _kamonAkka,
    _kamonAkkaRemote,
    _kamonAkkaHttp,
    _kamonSystemMetrics,
    _aspectjweaver // kamon-akka-remote 需要
  )

  val shapeless = "com.chuusai" %% "shapeless" % "2.3.3"

  val _scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"

  val _guice = "com.google.inject" % "guice" % "4.1.0"

  private val versionCassandra = "3.3.2"
  val _cassandraDriver = Seq(
    "com.datastax.cassandra" % "cassandra-driver-core" % versionCassandra,
    "com.datastax.cassandra" % "cassandra-driver-extras" % versionCassandra
  ).map(_.excludeAll(ExclusionRule("io.netty")))

  val _logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3"

  private val versionQuartz = "2.2.3"
  val _quartz = "org.quartz-scheduler" % "quartz" % versionQuartz

  val _postgresql = "org.postgresql" % "postgresql" % "42.2.1"

  val _mysql = "mysql" % "mysql-connector-java" % "6.0.6"

  val _hikariCP = "com.zaxxer" % "HikariCP" % "2.7.6"

  val _commonsLang3 = "org.apache.commons" % "commons-lang3" % "3.7"

  val _commonsBeanutils = "commons-beanutils" % "commons-beanutils" % "1.9.3"

  val _protobuf = "com.google.protobuf" % "protobuf-java" % "3.5.1"

  private val swaggerVersion = "1.5.17"
  val _swaggerAnnotation = "io.swagger" % "swagger-annotations" % swaggerVersion
}

