package problem
import app.EulerApp

/**
 * Created by Randy Baek on 9/12/15.
 */
object Prob010 extends EulerApp {

  // before optimization, it took 11 min
  def answer = findPrimesUnder(2000000L).sum

}
