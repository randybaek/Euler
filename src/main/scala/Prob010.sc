import java.util.concurrent.TimeUnit
import problem.Prob005._
//findPrimesUnder(2000000L).sum
val start = System.currentTimeMillis()
findPrimesUnder(2000000L).sum
val end = System.currentTimeMillis()
val time = end - start
TimeUnit.MILLISECONDS.toMinutes(end - start)

