
version := "0.1"

lazy val versions = new {
  val scala = "2.12.11"
  val scalatest = "3.0.5"
}

lazy val dependencies = new {
  val test = Vector("org.scalatest" %% "scalatest" % versions.scalatest % Test)
}

lazy val commonSettings = Vector(
  organization := "com.adyner.leetcode",
  scalaVersion := versions.scala,
  credentials += Credentials(Path.userHome / ".sbt" / ".credentials"),
  parallelExecution in Test := true,
  fork in Test := true,
  javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M")
)

lazy val leetcodePorject = (project in file("."))
  .settings(
    commonSettings,
    name := "leetcode-scala",
    libraryDependencies ++= dependencies.test,
    scalacOptions += "-Xmacro-settings:materialize-derivations"
  )