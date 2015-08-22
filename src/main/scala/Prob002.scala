/**
 * Created by wooyeolbaek on 10/10/14.
 */
object Prob002 extends EulerApp {
  def answer = fibonacci(1,2)

  def fibonacci(a: Int, b: Int) : Int =
    (if ( b % 2 == 0 ) b else 0 ) + (if (a + b > 4000000) 0 else fibonacci(b, a + b))

}
