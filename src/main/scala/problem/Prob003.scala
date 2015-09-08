package problem

import app.EulerApp

/**
 * Created by Randy Baek on 10/13/14.
 */
object Prob003 extends EulerApp{
  // 600851475143L
  val input : Long = 600851475143L

  def answer = largestPrimeOf(input)

  // input itself is prime number if nothing happens
  var largestPrime: Long = input

  def largestPrimeOf(n: Long) : Long = {

    findLargestFactor(n,2)
  }


  /**
   * from small factor 2, increase the factors and return the last factor
   * */
  def findLargestFactor(input: Long, factor: Long): Long = {
    //println("current lpn " + largestPrime)
    //println("finding Largest factor " + n, a)
    // can't not factored anymore.
    if (factor > input) largestPrime
    else {
      val prime = nextPrime(factor)
      val exponent = findExponent(input, prime, 0)
      //println("trying prime number " + prime + " to divide " + n)
      if (exponent != 0) {
        //println(n + " is divisible with " + prime + " for " + exponent + " times")
        largestPrime = prime

        findLargestFactor((input / (Math.pow(prime, exponent))).toLong, prime)
      }
      else findLargestFactor(input, prime)
    }

  }


  // find x where factor^x = n  === logarithm function
  def findExponent(n: Long, factor: Long, exponent : Long): Long = {
    //println("finding exponent... " + n, div, exponent)
    if (n % factor == 0 ) findExponent(n/factor, factor, exponent +1)
    else exponent
  }



}
