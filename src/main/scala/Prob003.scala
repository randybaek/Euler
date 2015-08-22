/**
 * Created by wooyeolbaek on 10/13/14.
 */
object Prob003 extends EulerApp{
  // 600851475143L
  val input : Long = 600851475143L

  def answer = largestPrimeOf(input)

  // input itself is prime number if nothing happens
  var largestPrime: Long = input

  def largestPrimeOf(n: Long) : Long = {

    findLargestFactor(n, 2)
  }


  def findLargestFactor(n: Long, a: Long): Long = {
    //println("current lpn " + largestPrime)
    //println("finding Largest factor " + n, a)
    if (a > n) largestPrime
    else {
      val prime = nextPrime(a)
      val exponent = findExponent(n, prime, 0)
      //println("trying prime number " + prime + " to divide " + n)
      if (exponent != 0) {
        //println(n + " is divisible with " + prime + " for " + exponent + " times")
        largestPrime = prime

        findLargestFactor((n / (Math.pow(prime, exponent))).toLong, prime)
      }
      else findLargestFactor(n, prime)
    }

  }

  def findExponent(n: Long, div: Long, exponent : Long): Long = {
    //println("finding exponent... " + n, div, exponent)
    if (n % div == 0 ) findExponent(n/div, div, exponent +1)
    else exponent
  }




}
