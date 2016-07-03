package week4

/**
  * Created by diogoaos on 03-07-2016.
  */
class Int {
  def + (that: Double): Double
  def + (that: Float): Float
  def + (that: Long): Long
  def + (that: Int): Int

  def << (cnt: Int): Int

  def & (that: Long): Long
  def & (that: Int): Int

  def == (that: Double): Boolean
  def == (that: Float): Boolean
  def == (that: Long): Boolean
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

class NonZero extends Nat{
  def isZero = if
}

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new NumberFormatException
  def successor = Succ(this)
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = throw new ArithmeticException()
}

class Succ(n: Nat) extends Nat {
  def predecessor = n
  def successor = n
  def + (that: Nat) =
}