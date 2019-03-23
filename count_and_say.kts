
fun countAndSay(n: Int): String {
  if (n == 1) {
    return "1"
  }

  val prev = countAndSay(n-1)

  val strBuilder = StringBuilder()

  var pairs = mutableListOf<Pair<String, String>>()

  var currentChar: Char = prev[0]
  var currentCount = 0
  for (char in prev.toCharArray()) {
    if (char == currentChar) {
      currentCount += 1
    } else {
      pairs.add(Pair("$currentChar", "$currentCount"))

      currentChar = char
      currentCount = 1
    }
  }
  pairs.add(Pair("$currentChar", "$currentCount"))

  pairs.forEach {
    strBuilder.append("${it.second}${it.first}")
  }


  return strBuilder.toString()
}

println(countAndSay(1) == "1")
println(countAndSay(2) == "11")
println(countAndSay(3) == "21")
println(countAndSay(4) == "1211")
println(countAndSay(5) == "111221")
println(countAndSay(6) == "312211")
println(countAndSay(1))
println(countAndSay(2))
println(countAndSay(3))
println(countAndSay(4))
println(countAndSay(5))
println(countAndSay(6))
