class ListNode(val `val`: Int) {
  var next: ListNode? = null
}

fun mergeLists(list1: ListNode?, list2: ListNode?): ListNode? {

  var curr1 = list1
  var curr2 = list2

  var dummy = ListNode(0)

  var ptr: ListNode = dummy

  while (curr1 != null || curr2 != null) {
    if (curr1 != null && curr2 != null) {
      if (curr1.`val` < curr2.`val`) {
        ptr.next = curr1
        curr1 = curr1.next
      } else {
        ptr.next = curr2
        curr2 = curr2.next
      }
    } else if (curr1 != null && curr2 == null) {
      ptr.next = curr1

      curr1 = curr1.next
    } else if (curr1 == null && curr2 != null) {
      ptr.next = curr2

      curr2 = curr2.next
    }

    ptr = ptr.next!!
  }

  return dummy.next

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
  if (lists.size == 0) {
    return null
  } else if (lists.size == 1) {
    return lists[0]
  }

  var mergedSoFar = lists[0]

  for (i in 1..lists.size-1) {
    mergedSoFar = mergeLists(mergedSoFar, lists[i])
  }

  return mergedSoFar

}


val anode1 = ListNode(1)
val anode2 = ListNode(4)
val anode3 = ListNode(5)

val bnode1 = ListNode(1)
val bnode2 = ListNode(3)
val bnode3 = ListNode(4)

val cnode1 = ListNode(2)
val cnode2 = ListNode(6)

val head1 = anode1
anode1.next = anode2
anode2.next = anode3

val head2 = bnode1
bnode1.next = bnode2
bnode2.next = bnode3

val head3 = cnode1
cnode1.next = cnode2


fun printList(head: ListNode?) {
  var curr = head
  while (curr != null) {
    print("${curr.`val`}, ")
    curr = curr.next
  }
  println()
}

printList(head1)
printList(head2)
printList(head3)

val merged = mergeKLists(arrayOf(head1, head2, head3))

printList(merged)

