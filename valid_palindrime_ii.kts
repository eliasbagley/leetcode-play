

fun isPalindrome(s: String): Boolean {
  val re = Regex("[^A-Za-z0-9]")

  val alphaString = re.replace(s, "").toLowerCase()
  val reversed = alphaString.reversed().toLowerCase()

  return alphaString == reversed
}

fun validPalindrome(s: String): Boolean {

  if (isPalindrome(s)) {
    return true
  }

  for (x in 0..s.length) {
    val newString = s.removeRange(x, x+1)
    val isPalindrome = isPalindrome(newString)
    if (isPalindrome) {
      return true
    }
  }

  return false
}


println(validPalindrome("aba") == true)
println(validPalindrome("abca") == true)
