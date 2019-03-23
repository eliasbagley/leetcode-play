
fun toLowerCase(str: String): String {
  val chars = str.toCharArray()

  val lower = chars.map {
    val intValue = it.toInt()
    if (intValue < 97 && intValue >= 65) {
      it + 32
    } else {
      it
    }
  }
  return lower.joinToString(separator = "")
}

println(toLowerCase("HELLO"))
println(toLowerCase("Hello"))
println(toLowerCase("al&phaBET"))
