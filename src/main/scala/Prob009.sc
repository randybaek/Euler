// a^2 + b^2 = c^2
// a + b + c = 1000
// c = 1000 - a - b
// a^2 + b^2 = (1000 - a - b)^2

(1 to 1000).find(_ + 1 == 28)

for (a <- (1 to 1000); b <- (1 to 1000)){
  if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow((1000 - a- b), 2))
    println(a* b * (1000- a-b))
}

findPythagoreanTriplet(1000)

def findPythagoreanTriplet(sum: Int) = {
  val answers =
    for {
      a <- (1 to sum)
      b <-(1 to sum)
      if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow((sum - a - b), 2))
    }  yield a * b * (sum - a -b)
  answers.distinct
}