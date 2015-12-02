package problem

import app.EulerApp
import problem.Prob005._
import scala.collection.mutable.ArrayBuffer

/**
  * Created by Randy Baek on 11/24/15.
  *
  * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

    Let us list the factors of the first seven triangle numbers:

     1: 1
     3: 1,3
     6: 1,2,3,6
    10: 1,2,5,10
    15: 1,3,5,15
    21: 1,3,7,21
    28: 1,2,4,7,14,28
    We can see that 28 is the first triangle number to have over five divisors.

    What is the value of the first triangle number to have over five hundred divisors?

  */
object Prob012 extends EulerApp {

  // generate triangleNumbers and find element which has is more than 500 factors
  def answer = Stream.from(1).scanLeft(0)(_ + _).drop(1).find( getFactorNumSimple(_) > 500 ).get


  // number of divisors is multiple of (exponent +1 ) of all prime factors
  def getFactorNum(n: Long): Int =  if (n == 1 ) 1 else
    primeFactorization(n).map(_._2 + 1).reduceLeft(_ * _)

  // naive way (faster).
  def getFactorNumSimple(n: Int): Int = {
    (1 to math.sqrt(n).toInt).filter( n % _ == 0).flatMap(x => List(x, n/x).distinct).size
  }

  def primeFactorization(n: Long): ArrayBuffer[(Long, Int)] = {
    // return list of tuples where (basePrime, exponenet)
    val factors = new ArrayBuffer[(Long, Int)]()
    primeFactorization_helper(n, 2, factors)
  }


  def primeFactorization_helper(n: Long, divisor: Long, factors: ArrayBuffer[(Long, Int)]): ArrayBuffer[(Long, Int)] = {
    if (n == 1) factors
    else {
      var num = n
      var exp = 0
      while (num % divisor == 0) {
        num = num / divisor
        exp += 1
      }
      if (exp > 0) {
        val elem = (divisor, exp)
        factors += elem
      }
      primeFactorization_helper(num, nextPrime(divisor), factors)
    }
  }


}