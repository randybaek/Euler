package problem

import app.EulerApp

/**
 * Created by Randy Baek on 10/10/14.
 */
object Prob002 extends EulerApp {
  def answer = p2answer(1,2)

  //sum of even valued terms under four million in fibonacci sequence.
  def p2answer(a: Int, b: Int) : Int =
    (if ( b % 2 == 0 ) b else 0 ) + (if (a + b > 4000000) 0 else p2answer(b, a + b))

}
