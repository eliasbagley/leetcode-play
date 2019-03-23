fun maxSubArray(nums: IntArray): Int {

  val maxEndings = IntArray(nums.size)

  for (i in 0..nums.size - 1) {
    if (i == 0) {
      maxEndings[i] = nums[i]
    } else {
      val prevMax = maxEndings[i-1]
      val currValue = nums[i]
      maxEndings[i] = if (currValue > prevMax + currValue) {
        currValue
      } else {
        prevMax + currValue
      }
    }

  }



  return maxEndings.maxBy { it } ?: 0
}


println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))

