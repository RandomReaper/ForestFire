ThisBuild / scalaVersion := "2.13.3"

lazy val root = project.in(file(".")).
  aggregate(forestfire.js, forestfire.jvm).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val forestfire = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "ForestFire",
    version := "0.1-SNAPSHOT",
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
    scalaJSUseMainModuleInitializer := true,
  )
