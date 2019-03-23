#!/usr/bin/env kscript

val x = 50

fun isPalindrome(x: Int): Boolean {
  val forwardString = "$x"
  val reverseString = forwardString.reversed()

  return forwardString == reverseString
}

println(isPalindrome(50) == false)
println(isPalindrome(151) == true)
println(isPalindrome(1) == true)
println(isPalindrome(123321) == true)
