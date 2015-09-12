package problem
import app.EulerApp
/**
 * Created by Randy Baek on 9/12/15.
 */
object Prob009 extends EulerApp {
  def answer = findPythagoreanTriplet(1000)

  // took 215 ms
  def findPythagoreanTriplet(sum: Int) = {
    val answers =
    for {
      a <- (1 to sum)
      b <-(1 to sum)
      if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow((sum - a - b), 2))
    }  yield a * b * (sum - a -b)
    answers.distinct
  }

  // took 12223 ms
  def findPythagoreanTriplet_clean(sum:Int) = {
    (for {
      a <- (1 to sum)
      b <- (1 to sum)
      c <- (1 to sum)
      if (a*a + b*b == c*c && a + b + c == sum)
    } yield a*b*c).head
  }


}
