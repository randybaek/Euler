package problem
import app.EulerApp
import org.canova.api.util.ClassPathResource
import scala.io.Source

/**
  * Created by Randy Baek on 1/28/16.
  *
  * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
  */
object Prob013 extends EulerApp {
  val file = new ClassPathResource("data/Prob013.txt").getFile

  def answer =
    //Source.fromFile(file).getLines().map(BigInt(_)).sum.toString.take(10)
    Source.fromFile(file).getLines().map(_.take(11).toLong).sum.toString.take(10)

}
