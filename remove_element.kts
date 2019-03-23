
/* fun removeElement(nums: IntArray, `val`: Int): Int { */

/*   // put all val at the end by swapping */
/*   for (i  in 0..nums.size-1) { */
/*     if(nums[i] == `val`) { */
/*       for (j in i+1..nums.size-1) { */
/*         if (nums[j] != `val`) { */
/*           // swap */
/*           val temp = nums[j] */
/*           nums[j] = nums[i] */
/*           nums[i] = temp */
/*         } */
/*       } */
/*     } */
/*   } */

/*   // count how many non-val */
/*   for (i in 0..nums.size-1) { */
/*     if (nums[i] == `val`) { */
/*       return i */
/*     } */
/*   } */

/*   return nums.size */
/* } */

fun removeElement(nums: IntArray, `val`: Int): Int {
  var i = 0

  for (j in 0..nums.size-1) {
    if (nums[j] != `val`) {
      nums[i] = nums[j]
      i += 1
    }
  }

  return i
}

val arr = intArrayOf(0,1,2,2,3,0,4,2)

println(removeElement(arr, 2))
println(arr.joinToString())
