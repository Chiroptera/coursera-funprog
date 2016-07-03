object session{
  1+1

  def fact(n: Int): Int =
    if (n == 0) 1 else n * fact(n - 1)

  def factorial(n: Int) = {

    def factorial_carry(x: Int, middle: Int): Int =
      if (x == 0) middle
      else factorial_carry(x - 1, middle * x)

    factorial_carry(n, 1)

  }
  factorial(0)
  factorial(5)
}