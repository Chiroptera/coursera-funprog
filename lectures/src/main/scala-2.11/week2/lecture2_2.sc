object lecture2_2{
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  product(x => x * x)(3,4)

  def fact(n: Int) = product(x => x)(1, n)

  fact(5)

  def range_f(f: Int => Int, g: (Int, Int) => Int, identity: Int)(a: Int, b: Int): Int = {
    if (a > b) identity
    else g(f(a), range_f(f, g, identity)(a+1, b))
  }

  def product_f(f: Int => Int)(a: Int, b: Int): Int = range_f(f, (x, y) => x * y, 1)(a,b)
  def sum_f(f: Int => Int)(a: Int, b: Int): Int = range_f(f, (x, y) => x + y, 0)(a,b)

  range_f(x => x * x, (x, y) => x * y, 1)(3,4)
  product_f(x => x * x)(3,4)
  range_f(x => x * x, (x, y) => x + y, 0)(3,4)
  sum_f(x => x * x)(3,4)

}