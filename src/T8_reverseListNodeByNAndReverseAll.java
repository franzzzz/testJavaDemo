public class T8_reverseListNodeByNAndReverseAll {
    public static class ListNode {
        int val;
        ListNode next;
        public void ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] argv) {
        Q8_reverseListNodeByNAndReverseAll r = new Q8_reverseListNodeByNAndReverseAll();

        int k = 2;

        ListNode l5 = new ListNode();
        l5.ListNode(5, null);
        ListNode l4 = new ListNode();
        l4.ListNode(4, l5);
//        l4.ListNode(4, null);
        ListNode l3 = new ListNode();
        l3.ListNode(3, l4);
        ListNode l2 = new ListNode();
        l2.ListNode(2, l3);
        ListNode l1 = new ListNode();
        l1.ListNode(1, l2);
        ListNode newHead = r.reverse(l1, k);
        while(newHead != null) {
            System.out.println(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println("null");
    }
}