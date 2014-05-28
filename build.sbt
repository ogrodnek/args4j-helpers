organization := "com.bizo"

organizationName := "com.bizo"

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

sonatypeSettings

pomExtra := {
 <url>https://github.com/ogrodnek/args4j-helpers</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/ogrodnek/args4j-helpers</url>
    <connection>https://github.com/ogrodnek/args4j-helpers.git</connection>
  </scm>
  <developers>
    <developer>
      <id>larry</id>
      <name>Larry Ogrodnek</name>
      <email>larry@bizo.com</email>
    </developer>
  </developers>
}