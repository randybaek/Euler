import problem.Prob004._
import problem.Prob003._

//toPalindrome(223)
//findLargestFactor(999999,2)

(999 to 100 by -1).map(toPalindrome).find(isProductOfTwo3DigitNumbers)

