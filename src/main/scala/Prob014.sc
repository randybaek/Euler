
//colatz(1001063,1001063,0)
//val answer = colatz(1001063, 0, 1001063,0)
//val answer = colatz2(1001063, 1001063, 0)
//val answer = colatz2(100000, 100000,0)
//def colatz(start: Int, prev: Int, current: Int, step: Int): Int = {
//  //println(current + " | " + step)
//    current match {
//      case minus if current < 0 => prev
//      case 1 => {
//        step
//      }
//      case even if current % 2 == 0 => colatz(start, current, current/2, step + 1)
//      case _ => colatz(start, current, (3 * current) + 1 , step + 1)
//    }
//}
//
//def colatz2(start: Int, current: Int, step: Int): Int = {
//  if (current == 1) step
//  else if (current % 2 ==0) colatz2(start, current/2, step+1)
//  else colatz2(start, 3 * current + 1, step + 1)
//}

val bigInt = 2140000000 * 2