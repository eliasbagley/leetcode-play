import java.util.*

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}


// reverse a linked list by pushing the nodes onto a stack.
fun isPalindrome(head: ListNode?): Boolean {
  val stack = Stack<Int>()
  val forward = mutableListOf<Int>()
  val reversed = mutableListOf<Int>()

  var curr = head

  while (curr != null) {
    stack.push(curr.`val`)
    forward.add(curr.`val`)
    curr = curr.next
  }

  // reverse the list
  while (!stack.isEmpty()) {
    reversed.add(stack.pop())
  }


  return forward == reversed
}

// test 1

val head = ListNode(1)
head.next = ListNode(5)
head.next?.next = ListNode(1)

println(isPalindrome(head) == true)

// test 2

val head2 = ListNode(1)
head2.next = ListNode(5)

println(isPalindrome(head2) == false)

// test 3
val head3 = null
println(isPalindrome(head3) == true)

