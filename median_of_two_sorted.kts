
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
  val totalSize = nums1.size + nums2.size

  val med1 = nums1[totalSize-1/2]
  val med2 = nums2[totalSize-1/2]

  val medOfMed = (med1 + med2) / 2


}
