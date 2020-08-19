package com.adyner.leetcode.addtwonumbers

import org.scalatest.exceptions.TestFailedException
import org.scalatest.{Assertion, FreeSpec, Matchers, Succeeded}
import SolutionSpec._

class SolutionSpec extends FreeSpec with Matchers {
  "addTwoNumbers solution" - {
    "should work properly with equal len of inputs" in {
      val lInput = new ListNode(2,
        new ListNode(4,
          new ListNode(3)
        )
      )

      val rInput = new ListNode(5,
        new ListNode(6,
          new ListNode(4)
        )
      )

      val output = Solution.addTwoNumbers(lInput, rInput)

      val expected = new ListNode(7,
        new ListNode(0,
          new ListNode(8)
        )
      )

      output shouldContainSameValue expected
    }

    "should work properly with non-equal len of inputs" in {
      {
        val lInput = new ListNode(2,
          new ListNode(4,
            new ListNode(3)
          )
        )

        val rInput = new ListNode(5,
          new ListNode(6,
          )
        )

        val output = Solution.addTwoNumbers(lInput, rInput)

        val expected = new ListNode(7,
          new ListNode(0,
            new ListNode(4)
          )
        )

        output shouldContainSameValue expected
      }
    }

    "should work properly with two zero inputs" in {
      {
        val lInput = new ListNode(0)
        val rInput = new ListNode(0)

        val output = Solution.addTwoNumbers(lInput, rInput)
        val expected = new ListNode(0)

        output shouldContainSameValue expected
      }
    }
  }
}

object SolutionSpec {
  implicit class ListNodeExt(val input: ListNode) extends AnyVal {

    def shouldContainSameValue(obj: ListNode): Assertion = {
      if (deepCompration(input, obj)) {
        Succeeded
      } else {
        throw new TestFailedException("Values is not equal", 1)
      }
    }

    private def deepCompration(l: ListNode, r: ListNode): Boolean = {
      l.x == r.x && ((l.next != null && r.next != null && deepCompration(l.next, r.next)) || (l.next == null && r.next == null))
    }
  }
}