import java.util.*
import java.lang.*

fun plusOne(digits: IntArray): IntArray {

  var carry = 0
  for (i  in digits.size-1 downTo 0) {
    val digit = digits[i]
    var sum: Int = digit + carry

    if (i == digits.size-1) {
      sum += 1
    }


    if (sum >= 10) {
      sum -= 10
      carry = 1
    } else {
      carry = 0
    }

    digits[i] = sum
  }

  return if (carry == 1) {
    // need to add another digit to the end of the array
    val largerArray = IntArray(digits.size + 1)

    largerArray[0] = carry

    var i = 1
    for (digit in digits) {
      largerArray[i] = digit
      i += 1
    }


    largerArray
  } else {
    digits
  }
}


println(plusOne(intArrayOf(4, 3, 2)) == intArrayOf(4, 3, 3))
println(plusOne(intArrayOf(4, 3, 9)) == intArrayOf(4, 4, 0))
println(plusOne(intArrayOf(9, 9, 9)) == intArrayOf(1, 0, 0, 0))

println(plusOne(intArrayOf(4, 3, 2)).joinToString())
println(plusOne(intArrayOf(4, 3, 9)).joinToString())
println(plusOne(intArrayOf(9, 9, 9)).joinToString())
