fun backspaceCompare(S: String, T: String): Boolean {
    val canonicalS = mutableListOf<Char>()
    val canonicalT = mutableListOf<Char>()

    for (s in S.toCharArray()) {
        if (s == '#') {
            canonicalS.removeAt(canonicalS.size-1)
        } else {
            canonicalS.add(s)
        }
    }

    for (t in T.toCharArray()) {
        if (t == '#') {
            canonicalT.removeAt(canonicalT.size-1)
        } else {
            canonicalT.add(t)
        }
    }

    println(canonicalS.joinToString(""))
    println(canonicalT.joinToString(""))
    return canonicalS.joinToString("") == canonicalT.joinToString("")
}


backspaceCompare("ab#c", "ad#c")


