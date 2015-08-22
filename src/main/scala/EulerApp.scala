/**
 * Created by wooyeolbaek on 10/10/14.
 */
abstract class EulerApp {

  // computes and returns the solution
  def answer : Any

  def main (args: Array[String]) {
    println(answer)
  }

  val primes: scala.collection.mutable.MutableList[Long] = scala.collection.mutable.MutableList()

  def addPrime(trial: Long): Unit = {
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

  // this can be only called after adding primes first
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

  def test : String  = "hi"



}
