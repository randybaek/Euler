package problem
import app.EulerApp

/**
 * Created by Randy Baek on 9/10/15.
 */

/**
 * sum square difference
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 3025 − 385 = 2640.
 * */
object Prob006 extends EulerApp {

  def answer = sumSquareDifference(100)


  def sumSquareDifference (n: Int): Long = {
    (Math.pow((1 to n).sum, 2) - (1 to n).map(Math.pow(_, 2)).sum).toLong
  }



}
