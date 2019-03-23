
fun isPalindrome(s: String): Boolean {
  val re = Regex("[^A-Za-z0-9]")

  val alphaString = re.replace(s, "").toLowerCase()
  val reversed = alphaString.reversed().toLowerCase()

  return alphaString == reversed
}


println(isPalindrome("A man, a plan, a canal: Panama") == true)
println(isPalindrome("race a car") == false)
