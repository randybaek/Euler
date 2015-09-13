package app
import org.scalatest._
import problem.Prob003._


/**
 * Created by Randy Baek on 9/12/15.
 */
class PrimeEfficiencyTest extends FlatSpec with Matchers {
  "sum of all primes under 10" should "17" in {
    findPrimesUnder(10).sum should be (17)
  }

}
