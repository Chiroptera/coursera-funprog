class Rational(x: Int, y: Int) {
  require (y != 0, "denominator must be nonzero")
  private val g = gcd(x, y)
  val numer = x
  val denom = y

  def unary_- = new Rational(-numer, denom)

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def - (that: Rational) = this + -that

  def mul(that: Rational) =
    new Rational(
      numer * that.numer,
      denom * that.denom)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString = numer/g + "/" + denom/g
}

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)

y + y

x - y

x < y

x max y