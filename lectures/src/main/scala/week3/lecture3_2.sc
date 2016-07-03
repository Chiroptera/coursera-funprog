import week3._

object lecture3_2 {
  new Rational(1,2)

  def error(msg: String) = throw new Error(msg)

  val x = null
  val y: String = x
  val z: Int = null //does not work
}