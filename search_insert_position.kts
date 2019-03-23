

fun searchInsert(nums: IntArray, target: Int): Int {
  return helper(nums, target, 0, nums.size-1)
}

fun helper(nums: IntArray, target: Int, left: Int, right: Int): Int {
  if (left == right) {
    val value = nums[left]
    if (target <= value) {
      return left
    } else {
      return left + 1
    }
  }

  val mid = (left + right) / 2

  val midValue = nums[mid]

  return if (midValue == target) {
    mid
  } else if (midValue < target) {
    // recurse right half
    helper(nums, target, mid + 1, right)
  } else {
    helper(nums, target, left, mid)
  }
}


println(searchInsert(intArrayOf(1), 1) == 0)
println(searchInsert(intArrayOf(1, 3, 5, 6), 5) == 2)
println(searchInsert(intArrayOf(1, 3, 5, 6), 2) == 1)
println(searchInsert(intArrayOf(1, 3, 5, 6), 7) == 4)
println(searchInsert(intArrayOf(1, 3, 5, 6), 0) == 0)
