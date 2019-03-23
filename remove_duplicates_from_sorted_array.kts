
fun removeDuplicates(nums: IntArray): Int {

  var seent: MutableSet<Int> = mutableSetOf()

  var count = 0

  for (i in 0..nums.size - 1) {
    val value: Int = nums[i]

    if (seent.contains(value)) {
      // advance forward till we find a non duplicate
      for (j in i..nums.size -1) {
        val next = nums[j]

        if (!seent.contains(next)) {
          // swap em
          val temp = nums[i]
          nums[i] = nums[j]
          nums[j] = temp
          seent.add(next)

          count += 1
          break
        }
      }

    } else {
      seent.add(value)
      count += 1
    }


    /* println(nums.joinToString()) */
  }

  return count

}


println(removeDuplicates(intArrayOf(0, 1, 2, 3, 4, 5)) == 6)
println(removeDuplicates(intArrayOf(0, 1, 1, 3, 4, 5)) == 5)
println(removeDuplicates(intArrayOf(0, 0, 0, 0, 0, 0)) == 1)
println(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)) == 5)


/* val arr = intArrayOf(0, 1, 1, 3, 4, 5) */
/* println(removeDuplicates(arr)) */
/* println(arr.joinToString()) */
