package week3

/**
  * Created by diogoaos on 21-06-2016.
  */

class Rational(x: Int, y: Int) {
  require (y != 0, "denominator must be nonzero")
  private val g = gcd(x, y)
  val numer = x
  val denom = y

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

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

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString = numer/g + "/" + denom/g
}

object Main extends App {
  // Print the trending tweets
  println("hello world")
}