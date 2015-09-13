package app
import java.util.concurrent.TimeUnit
/**
 * Created by Randy Baek on 10/10/14.
 */
abstract class EulerApp {

  // computes and returns the solution
  def answer : Any

  def main (args: Array[String]) {

    val start = System.currentTimeMillis
    println(answer)
    val end = System.currentTimeMillis
    val processingTime = end - start
    val time_min = TimeUnit.MILLISECONDS.toMinutes(processingTime)
    val time_sec = TimeUnit.MILLISECONDS.toSeconds(processingTime) - TimeUnit.MINUTES.toSeconds(time_min)

    println(s"It took $time_min min $time_sec sec")
  }

  val primes: scala.collection.mutable.MutableList[Long] = scala.collection.mutable.MutableList()
  primes += 2L

  private def addPrime(trial: Long): Unit = {
    //println("trying prime add with ", trial)

    if (isPrime(trial) ) {
      primes += trial
      //println("found new prime number! "+ trial)
    }
    else
      addPrime(trial+1)
  }


  def nextPrime(n: Long): Long = {
    addPrime(n)
    //println("this is primes we found so far.. " + primes)
    primes.last
  }

  // this can be only called with simultaneous primes update
  // TODO Improve this
  def isPrime(n: Long): Boolean = {
    // 1. n is not divided by any value of 2 ... n/2
    //println(n + " is .. ")
    if (primes.exists(n % _ == 0))
      false
    else {
      //println(n + " is Prime!")
      true
    }
  }


  def tryPrime(trial: Long) = {
    if (isPrime(trial)) primes += trial
    else primes
  }

  // TODO Improve this
  def findPrimesUnder(n: Long) = {
    (2L to n).map(tryPrime)
    primes
  }

  def findNthPrime(n: Int) : Int = {
    val lastNumberBeforeNthPrime = Stream.from(2) takeWhile (tryPrime(_).length < n) last

    lastNumberBeforeNthPrime + 1
  }


  def test : String  = "hi"



}
