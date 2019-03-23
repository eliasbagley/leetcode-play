import java.util.*
import java.lang.*

val values: Map<Char, Int> = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun romanToInt(s: String): Int {


  val chars: List<Char> = s.toCharArray().toList()

  var sum: Int = 0

  val stack = Stack<Char>()


  // add them all to a queue
  chars.reversed().forEach { x ->
    stack.add(x)
  }

  while (!stack.empty()) {
    val first: Char = stack.pop()

    val hasNext = try {
      stack.peek()
      true
    } catch (e: EmptyStackException) {
      false
    }

    if (!hasNext) {
      // last item - just add it on
      sum += values[first]!!
    } else {
      val next = stack.peek()

      if (isSpecialCase(first, next)) {
        stack.pop()
        sum += toRomanHelper(first, next)
      } else {
        sum += values[first]!!
      }
    }

  }


  return sum
}

fun isSpecialCase(char1: Char, char2: Char): Boolean {
  if (char1 == 'I') {
    if (char2 == 'V') {
      return true
    } else if (char2 == 'X') {
      return true
    }
  } else if (char1 == 'X') {
    if (char2 == 'L') {
      return true
    } else if (char2 == 'C') {
      return true
    }
  } else if (char1 == 'C') {
    if (char2 == 'D') {
      return true
    } else if (char2 == 'M') {
      return true
    }
  }

  return false
}

fun toRomanHelper(char1: Char, char2: Char): Int {
  if (char1 == 'I') {
    if (char2 == 'V') {
      return 4
    } else if (char2 == 'X') {
      return 9
    }
  } else if (char1 == 'X') {
    if (char2 == 'L') {
      return 40
    } else if (char2 == 'C') {
      return 90
    }
  } else if (char1 == 'C') {
    if (char2 == 'D') {
      return 400
    } else if (char2 == 'M') {
      return 900
    }
  }

  return values[char1]!! + values[char2]!!

}


// test cases

println(romanToInt("III") == 3)
println(romanToInt("IV") == 4)
println(romanToInt("IX") == 9)
println(romanToInt("LVIII") == 58)
println(romanToInt("MCMXCIV") == 1994)
