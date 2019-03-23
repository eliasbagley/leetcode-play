
fun rotate(matrix: Array<IntArray>): Unit {

  val size = matrix.size
  val numLayers = (size / 2) + (size  % 2) // both 3x3 and 4x4 have 2 layers

  // do the rotation for each layer individually

  for (layer in 0..numLayers) {
    val layerSize = size - 2*layer // width of each layer

    val lastIndex = matrix.size - 1 - layer


    for (i in 0..layerSize - 1 - 1) {
      /* println("i: $i") */
      fun getTop() = matrix[layer][i+layer]
      fun setTop(value: Int) {
        matrix[layer][i+layer] = value
      }

      fun getRight() = matrix[i+layer][lastIndex]
      fun setRight(value: Int) {
        matrix[i+layer][lastIndex] = value
      }

      fun getBottom() = matrix[lastIndex][lastIndex-i]
      fun setBottom(value: Int) {
        matrix[lastIndex][lastIndex-i] = value
      }

      fun getLeft() = matrix[lastIndex-i][layer]
      fun setLeft(value: Int) {
        matrix[lastIndex-i][layer] = value
      }

      val top = getTop()
      val right = getRight()
      val bottom = getBottom()
      val left = getLeft()

      setTop(left)
      setRight(top)
      setBottom(right)
      setLeft(bottom)
    }
  }
}

fun Array<IntArray>.print() {
  for (i in 0..this.size - 1) {
    println(this[i].joinToString())
  }
}

fun Array<IntArray>.rotateImage() = rotate(this)

fun printImage(image: Array<IntArray>) {
  for (i in 0..image.size) {
    println(image[i].joinToString())
  }
}

val row1 = intArrayOf(1, 2, 3, 4, 5)
val row2 = intArrayOf(6, 7, 8, 9, 10)
val row3 = intArrayOf(11, 12, 13, 14, 15)
val row4 = intArrayOf(16, 17, 18, 19, 20)
val row5 = intArrayOf(21, 22, 23, 24, 25)

val image: Array<IntArray> = arrayOf(row1, row2, row3, row4, row5)

/* val row1 = intArrayOf(5, 1, 9, 11) */
/* val row2 = intArrayOf(2, 4, 8, 10) */
/* val row3 = intArrayOf(13, 3, 6, 7) */
/* val row4 = intArrayOf(15, 14, 12, 16) */

/* val image = arrayOf(row1, row2, row3, row4) */

image.print()

println()

image.rotateImage()

image.print()


