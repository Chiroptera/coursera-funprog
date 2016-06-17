object lecture2_1{
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a == b) acc + f(a)
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }
  sum(x => x * x, 3, 5)
}