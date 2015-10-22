def factorial(a: Long) : Long = {
  if (a == 1 ) 1
  else a * factorial(a -1)
}

factorial(20)