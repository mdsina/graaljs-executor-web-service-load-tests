enablePlugins(GatlingPlugin)

name := "GatlingGraalJS"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.0.3"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.0.3"

javaOptions in Gatling := overrideDefaultJavaOptions("-Xss50m", "-Xms2G", "-Xmx8G")