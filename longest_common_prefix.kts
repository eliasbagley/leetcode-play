

// vertical scanning solution
fun longestCommonPrefix_vertical(strs: Array<String>): String {

  if (strs.size == 0) {
    return ""
  }

  var shortest: Int = 99999

  for (str in strs) {
    if (str.length < shortest) {
      shortest = str.length
    }
  }

  var strBuilder = StringBuilder()

  for (i in 0..shortest-1) {

    // strip out columns from left to right and make sure they're all the same
    val charAtI = strs.map { it.get(i) }
    val firstInArray = charAtI[0]

    val allSame = charAtI.all {it == firstInArray }

    if (allSame) {
      strBuilder.append(firstInArray)
    } else {
      break
    }



  }


  return strBuilder.toString()
}

fun lcr(left: String, right: String): String {
  val min = if (left.length < right.length) {
    left.length
  } else {
    right.length
  }

  val strBuilder = StringBuilder()

  for (i in 0..min-1) {
    if (left[i] == right[i]) {
      strBuilder.append(left[i])
    } else {
      break
    }

  }

  return strBuilder.toString()

}

fun longestCommonPrefixHelper(strs: Array<String>, left: Int, right: Int): String {
  if (left == right) {
    return strs[left]
  } else if (right - left == 1) {
    val l = strs[left]
    val r = strs[right]

    return lcr(l, r)
  } else {
    val mid = (left + right) / 2
    val l =  longestCommonPrefixHelper(strs, left, mid)
    val r =  longestCommonPrefixHelper(strs, mid + 1, right)

    return lcr(l, r)
  }

}

fun longestCommonPrefix(strs: Array<String>): String {

  if (strs.isEmpty()) {
    return ""
  }

  if (strs.size == 1) {
    return strs[0]
  }

  val left = 0
  val right = strs.size - 1
  val mid = (left + right) / 2


  val leftLcr = longestCommonPrefixHelper(strs, left, mid)
  val rightLcr = longestCommonPrefixHelper(strs, mid+1, right)

  return lcr(leftLcr, rightLcr)
}

println(longestCommonPrefix(arrayOf<String>()) == "")
println(longestCommonPrefix(arrayOf("")) == "")
println(longestCommonPrefix(arrayOf("cat", "catt", "catter")) == "cat")
println(longestCommonPrefix(arrayOf("dog", "racecar", "car")) == "")
println(longestCommonPrefix(arrayOf("flower", "flow", "flight")) == "fl")
