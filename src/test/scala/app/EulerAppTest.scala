/**
 * Created by wooyeolbaek on 10/14/14.
 */
package app

import org.scalatest._
import problem.Prob003._

class EulerAppTest extends FlatSpec with Matchers {

   "7" should "be a prime number" in {
     isPrime(7) shouldBe true

     largestPrimeOf(40) should be (5)
   }

 }
