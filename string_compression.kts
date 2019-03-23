
fun compress(chars: CharArray): Int {

  if (chars.size == 0) {
    return 0
  }

  if (chars.size == 1) {
    return 1
  }

  var currentChar = chars[0]
  var currentCharCount = 0
  var i = 0
  for (j in 0..chars.size-1) {
    if (chars[j] == currentChar) {
      currentCharCount += 1
    } else {
      chars[i] = currentChar
      i += 1

      if (currentCharCount > 1) {
        var charAsString = "$currentCharCount"
        for (c in charAsString) {
          chars[i] = c
          i += 1
        }
      }

      currentChar = chars[j]
      currentCharCount = 1
    }
  }

  chars[i] = currentChar
  i += 1

      if (currentCharCount > 1) {
        var charAsString = "$currentCharCount"
        for (c in charAsString) {
          chars[i] = c
          i += 1
        }
      }

  return i
}

val arr = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
println(compress(arr))
println(arr.joinToString())
