fun lengthOfLastWord(s: String): Int {
    return s.split(" ").last().length

}

println(lengthOfLastWord("Hello World") == 5)
