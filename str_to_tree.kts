class TreeNode(val `val`: Int) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}

fun str2tree(s: String): TreeNode? {
		if (s.isEmpty()) {
      println("empty")
				return null
		}

		val regexJustRoot = "(\\d+)".toRegex().matchEntire(s)
		if (regexJustRoot != null) {
      println("matches single digit")
				val (rootValue) = regexJustRoot.destructured
				return TreeNode(rootValue.toInt())
		}

		val matchResultBoth = "([0-9]+)(\\([\\d\\(]+\\))(\\([\\d\\(]+\\))".toRegex().matchEntire(s)
		if (matchResultBoth != null) {
      println("Matches both")
				val (rootValue, leftTree, rightTree) = matchResultBoth.destructured
				val root = TreeNode(rootValue.toInt()).apply {
						left = str2tree(leftTree)
						right = str2tree(rightTree)
				}
		}

		val matchResultSingle = "([0-9]+)(\\([\\d\\(]+\\))".toRegex().matchEntire(s)
		if (matchResultSingle != null) {
      println("matches single")
				val (rootValue, leftTree) = matchResultSingle.destructured
				val root = TreeNode(rootValue.toInt()).apply {
						left = str2tree(leftTree)
				}
		}


    println("returning null")
		return null

}


str2tree("4(2)")
