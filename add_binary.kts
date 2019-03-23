fun addBinary(a: String, b: String): String {

  val aReversed = a.reversed()
  val bReversed = b.reversed()

  val maxLen = if (a.length > b.length) { a.length } else { b.length }

  val result = mutableListOf<String>()
  var aReversedChars = aReversed.toCharArray()
  var bReversedChars = bReversed.toCharArray()
  var carry = 0
  for (i in 0..maxLen-1) {
    val aValue: Int = if (i < a.length) {
      aReversedChars[i] - '0'
    } else {
      0
    }

    val bValue: Int = if (i < b.length) {
      bReversedChars[i] - '0'
    } else {
      0
    }

    var sum = aValue + bValue + carry
    if (sum >= 2) {
      sum -= 2
      carry = 1
    } else {
      carry = 0
    }

    result.add("$sum")
  }

  if (carry == 1) {
    result.add("1")
  }

  println(result)

  return result.joinToString("").reversed()
}

println(addBinary("1010", "1011"))
