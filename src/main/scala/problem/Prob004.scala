package problem
import app.EulerApp
import problem.Prob003._
/**
 * Created by Randy Baek on 9/8/15.
 */

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */


// my thought: per each palindrome candidates (only 999 of them) (in descending order), and return first one which product of two 3-digit.
object Prob004 extends EulerApp {

  def answer = {
    (999 to 100 by -1).map(toPalindrome).find(isProductOfTwo3DigitNumbers)
  }


  def toPalindrome(n: Int) : Int = {
    // abc -> abccba
    1000 * n + 100 * (n % 10 ) +  10 * ( (n % 100) / 10) +  (n / 100)

    // n.toString == n.toString.reverse
  }

  def isProductOfTwo3DigitNumbers(n: Int): Boolean = {
    // my thought, assumption: if biggest factor is more than 3 digits number, return false. otherwise yes -> wrong!
    //findLargestFactor(n, 2) < 1000

    // my second thought : start from 1 and n, and borrow factors from other side untill both are 3 digits -> to complicated

    // just traverse all 3 digits numbers to get palindrome number -> correct
    (100 to 999).find(e => n % e == 0 &&  100 < n / e  && 999 > n / e  ).isDefined
  }

  //def factorization(n :Int) : Array[(Int, Int)]
}
