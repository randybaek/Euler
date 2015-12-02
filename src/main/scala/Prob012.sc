import app.EulerApp
import problem.Prob005._
import problem.Prob012._
import scala.collection.mutable.{ArrayBuffer, Set}
val list = (1 to 10).toList
list.scanLeft(0)(_ + _).drop(1)
Stream.from(1).takeWhile(_ < 10).toList


// generate triangleNumbers and map them to number of factors and return first element which is more than N
//Stream.from(1).scanLeft(0)(_ + _).drop(1).takeWhile( getFactorNum(_) < 500 )

getFactorNum(1000000)