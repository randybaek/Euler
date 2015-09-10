package problem
import app.EulerApp

/**
 * Created by Randy Baek on 9/9/15.
 */

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Prob005 extends EulerApp {
  def answer = multipleOfAllPrimeUnder(21L)

  // multiples of all prime numbers between 1 - 20 -> wrong
  // multiples of all prime factors with maximum exponent
  def multipleOfAllPrimeUnder(n: Long) = {
    findPrimesUnder(20L).map(findMaximumExponent(_, 20L)).reduceLeft(_ * _)
  }

  def findMaximumExponent(f: Long , limit: Long) = {
    getMaximumExponent(f, f, 1L, limit)
  }

  def getMaximumExponent(current : Long, f: Long, e: Long, limit: Long) : Long = {
    if (current * f >= limit) current
    else getMaximumExponent(Math.pow(f, e).toLong, f, e + 1 , limit )
  }

}
