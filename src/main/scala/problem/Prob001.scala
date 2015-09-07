package problem

import app.EulerApp

/**
 * Created by wooyeolbaek on 10/10/14.
 */
object Prob001 extends EulerApp {

  def answer = findSumOfMultiplesOf3Or5BelowN2(1000)

  def findSumOfMultiplesOf3Or5BelowN(n:Int) : Integer = (n/3 -1 ) / 2 + (n/5 -1 )/ 4

  def findSumOfMultiplesOf3Or5BelowN2(n:Int) = (0 until n).filter( (a) => ( a % 3 == 0 )|| (  a % 5 == 0)).sum

  // 등비수열의 합 : a(r^n -1) / r -1

}
