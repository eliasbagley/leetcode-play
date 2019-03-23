
class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

  if (l1 == null) {
    return l2
  }
  if (l2 == null) {
    return l1
  }


  var currLeft = l1
  var currRight = l2

  var head: ListNode? = if (l1.`val` <= l2.`val`) {
    l1
  } else {
    l2
  }

  var next: ListNode? = null

  while (currLeft != null || currRight != null) {
    var nextNode: ListNode? = null

    if (currLeft == null && currRight != null) {
      nextNode = currRight
      currRight = currRight.next
    } else if (currLeft != null && currRight == null) {
      nextNode = currLeft
      currLeft = currLeft.next
    } else if (currLeft != null && currRight != null) {
      if (currLeft.`val` <= currRight.`val`) {
        nextNode = currLeft
        currLeft = currLeft.next
      }  else {
        nextNode = currRight
        currRight = currRight.next
      }
    }

    if (next == null) {
      // first item
      next = nextNode
    } else {
      // subsequent items
      next.next = nextNode
      next = nextNode
    }


  }


  return head

}
