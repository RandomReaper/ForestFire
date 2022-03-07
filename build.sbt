val sharedSettings = Seq(scalaVersion := "2.13.3")

lazy val ff =
// select supported platforms
  crossProject(JSPlatform, JVMPlatform)
    .withoutSuffixFor(JVMPlatform)
    .settings(sharedSettings)
    .jsSettings(scalaJSUseMainModuleInitializer := true,
      libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.1.0"
    ) // defined in sbt-scalajs-crossproject
    .jvmSettings(/* ... */)
