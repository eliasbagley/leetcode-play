

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}


fun removeElements(head: ListNode?, `val`: Int): ListNode? {
  if (head == null) {
    return null
  }


  var prev: ListNode? = null
  var curr: ListNode? = head
  var returnedHead: ListNode? = null

  while (curr != null) {
    if (prev == null && curr.`val` == `val`) {
      // skip starting trail of bad values
      curr = curr.next
    } else if (prev == null && curr.`val` != `val`) {
      // first good value - mark it as the head
      returnedHead = curr

      prev = curr
      curr = curr.next
    } else if (prev != null && curr.`val` == `val`) {
      // unlink the bad value
      prev.next = curr.next

      curr = curr.next
    } else {
      // good value, just continue
      prev = curr
      curr = curr.next
    }
  }

  return returnedHead

}
