package problem

import app.EulerApp

import scala.collection.mutable

/**
  * Created by wbaek on 12/20/16.
  */

/**
  * The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
  * */


case class Number(start: Int, step: Int)

object Prob014 extends EulerApp {
  // try all numbers from 1 to one million and get the maximum step
  def answer = findMax_clean(1000000)


  //def answer = colatz(1001063, 1001063, 0)

  var max = 0
  var maxNum = 0

  def findMax(range: Int): Int = {
    (1 to range).foreach ( x => {
      val step = colatz(x, x, 0)
      if (step > max) {
        max = step
        maxNum = x
      }
    }
    )
    maxNum
  }

  def findMax_clean(range: Int): Int = (1 to range)
                    .map(x => Number(x, colatz(x,x,0)))
                    // reduceLeft result type should be consistent as original type
                    .reduceLeft((a, b) => if(a.step > b.step) a else b )
                    .start


  // using hashmap for memoization
  val map = new mutable.HashMap[Long, Int]()

  def colatz(start: Int, current: Long, step: Int): Int = {
    //println(current + " | " + step)
    if (map.contains(current)) step + map.get(current).get
    else {
      current match {
        case 1 => {
          map.put(start, step)
          step
        }
        case even if current % 2 == 0 => colatz(start, current/2, step + 1)
        case _ => colatz(start, 3 * current + 1 , step + 1)
      }
    }
  }
}
