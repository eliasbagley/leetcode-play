class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun findSecondMinimumValue(root: TreeNode?): Int {
    val list = toList(root)

    val distinctList = list.distinctBy { it }
    if (distinctList.size < 2) {
        return -1
    }

    println("distinct list: ${distinctList.joinToString()}")

    return distinctList[1]

}

fun toList(root: TreeNode?): List<Int> {
    if (root == null) {
        return listOf()
    }
    val list = mutableListOf<Int>()
    val leftList = toList(root.left)
    val rightList = toList(root.right)
    list.addAll(leftList)
    list.add(root.`val`)
    list.addAll(rightList)
    return list
}

val root = TreeNode(5)
val left = TreeNode(5)
val right = TreeNode(8)

root.left = left
root.right = right

//println(toList(root).joinToString())
println(findSecondMinimumValue(root))
