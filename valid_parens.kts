/*
20. Valid Parens (easy)

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/

import java.util.Stack

fun isValid(s: String): Boolean {
  val stack = Stack<Char>()

  for (char in s.toCharArray()) {
    if (isOpening(char)) {
      stack.push(char)
    } else if (isClosing(char)) {
      if (stack.isEmpty()) {
        return false
      }
      val poppedChar = stack.pop()
      if (!matches(poppedChar, char)) {
        return false
      }
    }
  }

  return stack.isEmpty()

}

fun isOpening(char: Char): Boolean {
  return char in arrayOf('(', '{', '[')
}

fun isClosing(char: Char): Boolean {
  return char in arrayOf(')', '}', ']')
}

fun matches(char1: Char, char2: Char): Boolean {
  if (char1 == '(' && char2 == ')') {
    return true
  }

  if (char1 == '{' && char2 == '}') {
    return true
  }

  if (char1 == '[' && char2 == ']') {
    return true
  }


  return false
}



println(isValid("()") == true)
println(isValid("()[]{}") == true)
println(isValid("(]") == false)
println(isValid("(])]") == false)
println(isValid("{[]}") == true)
