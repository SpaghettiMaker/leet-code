public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveSolution(l1, l2, 0);
    }

    private ListNode recursiveSolution(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int l1Value = (l1 != null) ? l1.val : 0;
        int l2Value = (l2 != null) ? l2.val : 0;

        int sum = l1Value + l2Value + carry;
        int newCarry = sum / 10;
        int currentValue = sum % 10;

        return new ListNode(
                currentValue,
                recursiveSolution(
                        (l1 != null) ? l1.next : null,
                        (l2 != null) ? l2.next : null,
                        newCarry));
    }
}
