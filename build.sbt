name := "Euler"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.nd4j" % "canova-nd4j-codec" % "0.0.0.14",
  "org.nd4j" % "canova-nd4j-image" % "0.0.0.14",
  "org.deeplearning4j" % "deeplearning4j-core" % "0.4-rc3.8",
  "org.deeplearning4j" % "deeplearning4j-nlp" % "0.4-rc3.8",
  "org.deeplearning4j" % "deeplearning4j-ui" % "0.4-rc3.8"
)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"