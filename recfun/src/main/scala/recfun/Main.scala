package recfun
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    //@tailrec
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def updateAcc(acc: Int, c: Char): Int =
        if (c == '(') acc + 1
        else if (c == ')') acc - 1
        else acc

      //@tailrec
      def count(acc: Int, s: List[Char]): Boolean =
        if (acc < 0 || s.isEmpty) acc == 0
        else count(updateAcc(acc, s.head), s.tail)

      count(0, chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int =
      if (coins.isEmpty || money < 0) 0
      else if (money == 0) 1
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
