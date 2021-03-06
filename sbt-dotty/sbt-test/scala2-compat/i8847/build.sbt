val scala3Version = sys.props("plugin.scalaVersion")
val scala2Version = "2.13.4"

lazy val `i8847-lib` = (project in file ("lib"))
  .settings(scalaVersion := scala2Version)

lazy val `i8847-test` = (project in file ("main"))
  .dependsOn(`i8847-lib`)
  .settings(
    scalaVersion := scala3Version,
    // https://github.com/sbt/sbt/issues/5369
    projectDependencies := {
      projectDependencies.value.map(_.withDottyCompat(scalaVersion.value))
    }
  )
