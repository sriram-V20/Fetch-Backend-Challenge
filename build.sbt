
lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """Fetch-Backend-Challenge""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      guice,
      // Test Database
      "com.h2database" % "h2" % "1.4.200",
      // Testing libraries for dealing with CompletionStage...
      "org.assertj" % "assertj-core" % "3.24.2" % Test,
      "org.awaitility" % "awaitility" % "4.2.0" % Test,
      "org.json" % "json" % "20210307",
      "com.google.code.gson" % "gson" % "2.8.8",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror"
    ),
    // Make verbose tests
    (Test / testOptions) := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

  )
