/*
22. Generate Parenthesis
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
*/
import java.util.*

/* fun generateParenthesis(n: Int): List<String> { */
/*   if (n == 0) { */
/*     return listOf<String>("") */
/*   } */

/*   if (n == 1) { */
/*     return listOf("()") */
/*   } */

/*   if (n == 2) { */
/*     return listOf("(())", "()()") */
/*   } */

/*   val result = mutableListOf<String>() */

/*   val subset = generateParenthesis(n-1) */

/*   for (sub in subset) { */
/*     result.add("()$sub") */
/*     result.add("$sub()") */
/*     result.add("($sub)") */
/*   } */

/*   if (n % 2 == 0) { */
/*     val subset2 = generateParenthesis(n/2) */
/*     for (sub in subset2) { */
/*       result.add("$sub$sub") */
/*     } */
/*   } */


/*   // remove duplicates */
/*   return result.distinct() */
/* } */

fun generateParenthesis(n: Int): List<String> {
  if (n == 0) {
    return listOf<String>("")
  }

  if (n == 1) {
    return listOf("()")
  }

  if (n == 2) {
    return listOf("(())", "()()")
  }

  val result = mutableListOf<String>()

  if (n % 2 == 0) {
    val subset = generateParenthesis(n/2)

  }
    val subset3 = generateParenthesis(n/2-1)
    for (sub in subset3) {
      result.add("$sub()$sub")
      result.add("()$sub$sub")
      result.add("$sub$sub()")
      result.add("($sub$sub)")
    }
  }

  val subset2 = generateParenthesis(n - 1)
  for (sub in subset2) {
    result.add("()$sub")
    result.add("$sub()")
    result.add("($sub)")
  }


  // remove duplicates
  return result.distinct()
}


println(generateParenthesis(4).sorted())
println(listOf("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()").sorted())

println(generateParenthesis(5).sorted().size)
println(listOf("((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()").sorted().size)
