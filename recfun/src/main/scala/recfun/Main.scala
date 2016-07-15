package recfun

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
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || r == 0 || c == r) 1
      else
        pascal(c - 1,r - 1) + pascal(c, r - 1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      @tailrec
      def checkBalance(chars: List[Char], parens: Int): Boolean =
        if (chars.isEmpty && parens == 0) true
        else if (parens == 0 && chars.head == ')' || chars.isEmpty && parens > 0) \
      false
      else
      checkBalance(chars.tail, parens + checkParen(chars.head))

      def checkParen(char: Char): Int =
        if (char == '(') 1
        else if (char == ')') -1
        else 0

      checkBalance(chars, 0)
    }
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (!coins.isEmpty && money > 0)
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else
        0
    }