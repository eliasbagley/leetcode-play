
class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
  var count = count(head)
  var indexToRemove = count - n

  var prev: ListNode? = null
  var curr: ListNode? = head
  var i = 0
  while (curr != null) {
    if (i == indexToRemove) {
      if (prev != null) {
        prev.next = curr.next
      } else {
        // we're removing first item, just return heads next
        return head!!.next
      }
    }



    prev = curr
    curr = curr.next
    i += 1
  }


  return head
}

fun count(head: ListNode?): Int {
  if (head == null) {
    return 0
  }

  return 1 + count(head.next)
}
