import sbt.Keys._

addCommandAlias("verify", ";clean;coverage;test")

lazy val `BTree4s` = (project in file("."))
  .settings(
    name := "BTree4s",
    parallelExecution in Test := false,
    onLoad in Global := (Command.process("scalafmt", _: State)) compose (onLoad in Global).value,
    // make run command include the provided dependencies
    run in Compile := Defaults
      .runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))
      .evaluated
  )
