
val romans = listOf(
    "M", // 1000
    "CM", // 900
    "D", // 500
    "CD", // 400
    "C", // 100
    "XC", // 90
    "L", // 50
    "XL", // 40
    "X", // 10
    "IX", // 9
    "V", // 5
    "IV", // 4
    "I" // 1
)

val values = listOf(
    1000,
    900,
    500,
    400,
    100,
    90,
    50,
    40,
    10,
    9,
    5,
    4,
    1
)

fun intToRoman(num: Int): String {

  val strBuilder = StringBuilder()

  // iterate values from big to small, and if it fits, add it to the string builder
  var remainder = num

  for (i in 0..values.size-1) {
    val value = values[i]
    val str = romans[i]

    //println("value: $value, str: $str")

    while (remainder - value >= 0) {
      strBuilder.append(str)
      remainder -= value
    }

  }

  return strBuilder.toString()
}

// tests

println(intToRoman(1000) == "M")
println(intToRoman(30) == "XXX")
println(intToRoman(3) == "III")
println(intToRoman(4) == "IV")
println(intToRoman(9) == "IX")
println(intToRoman(58) == "LVIII")
println(intToRoman(1994) == "MCMXCIV")
