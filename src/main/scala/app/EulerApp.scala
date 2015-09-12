package app

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
    println("time taken =" + (end - start))
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

  //TODO improve this
  def tryPrime(trial: Long) = {
    if (isPrime(trial)) primes += trial
    else primes
  }

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
