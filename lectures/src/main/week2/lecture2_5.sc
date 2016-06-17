class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  def mul(that: Rational) =
    new Rational(
      numer * that.numer,
      denom * that.denom)

  override def toString = numer + "/" + denom
}

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)

x.add(y).mul(z)
x.sub(y).sub(z)
