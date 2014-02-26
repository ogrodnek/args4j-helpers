organization := "com.bizo"

name := "args4j-helpers"

version := "1.0.0"

scalaVersion := "2.10.3"

scalacOptions ++=Seq("-unchecked", "-deprecation", "-language:_")

libraryDependencies ++= Seq(
  "args4j" % "args4j" % "2.0.26",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10-M4" % "test"
)

EclipseKeys.withSource := true
