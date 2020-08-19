package com.adyner.leetcode.addtwonumbers

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val result = new ListNode()
    var currNode = result
    var currLeftItem = l1
    var currRightItem = l2
    var hasOverflow = true
    while (currLeftItem != null || currRightItem != null) {
      if (!hasOverflow) {
        val nextSegment = new ListNode(0)
        currNode.next = nextSegment
        currNode = nextSegment
      }

      var interim: Int = currNode.x
      if (currLeftItem != null) {
        interim += currLeftItem.x
        currLeftItem = currLeftItem.next
      }
      if (currRightItem != null) {
        interim += currRightItem.x
        currRightItem = currRightItem.next
      }

      currNode.x = interim % 10
      hasOverflow = interim > 9
      if (hasOverflow) {
        val nextSegment = new ListNode(interim / 10)
        currNode.next = nextSegment
        currNode = nextSegment
      }
    }
    result
  }
}


