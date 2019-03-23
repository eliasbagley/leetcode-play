fun lengthLongestPath(input: String): Int {
    if (input.isEmpty()) { return 0 }

    val groups = mutableListOf<List<String>>()
    var group = mutableListOf<String>()
    val list = input.split("\n")

    if (list.size == 1) {
      return if (isFile(list[0])) {
        list[0].length
      } else {
        0
      }
    }

    for (l in list) {
      if (l.startsWith('\t') || l.startsWith("    ")) {
        group.add(l)
      } else {
        if (group.size > 0) {
          groups.add(group)
        }
        group = mutableListOf<String>()
        group.add(l)
      }
    }

    if (group.size > 0) {
      groups.add(group)
    }

    return groups.map {
      val joined = it.joinToString("\n")
      lengthLongestPathHelper(it.joinToString("\n"))
    }.reduce { max, e -> if (e > max) e else max }
}


fun lengthLongestPathHelper(input: String): Int {
    if (input.isEmpty()) { return 0 }

    val list = input.split("\n")

    if (list.size == 1) {
      return if (isFile(list[0])) {
        list[0].length
      } else {
        0
      }
    }

    val head = list[0]
    val remainingTails = list.subList(1, list.size).map {
      if (it.startsWith('\t')) {
        it.replaceFirst("\t", "")
      } else if (it.startsWith("    ")) {
        it.replaceFirst("    ", "")
      } else {
        it
      }
    }

    var tails = mutableListOf<List<String>>()
    var group = mutableListOf<String>()
    for (row in remainingTails) {
        if (row.startsWith('\t') || row.startsWith("    ")) {
            group.add(row)
        } else {
            if (group.size > 0) {
                tails.add(group)
            }
            group = mutableListOf<String>()
            group.add(row)
        }
    }
    if (group.size > 0) {
      tails.add(group)
    }


    return tails.map { group ->
        group.joinToString("\n")
    }.map {
        lengthLongestPath(it)
    }.map {
        // "head/tail"
        if (it > 0) {
          it + head.length + 1
        } else {
          0
        }
    }.reduce() {max, len -> if (len > max) len else max}
}

fun isFile(name: String) = name.contains(".")

println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))
println(lengthLongestPath("a"))
println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"))
println(lengthLongestPath(""))
println(lengthLongestPath("a\n\tb\n\t\tc"))
println(lengthLongestPath("dir\n    file.txt"))
println(lengthLongestPath("dir\n        file.txt"))
println(lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"))

