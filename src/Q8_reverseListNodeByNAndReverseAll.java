
public class Q8_reverseListNodeByNAndReverseAll {
    T8_reverseListNodeByNAndReverseAll.ListNode reverse(T8_reverseListNodeByNAndReverseAll.ListNode head, int k) {


        //for k elements
        //resort them by period k
        //if k = 2, 1,2,3,4,5
        //5,3,4,1,2
        int counter = 0;
        T8_reverseListNodeByNAndReverseAll.ListNode iter = head;
        while(counter <= k) {
            if (iter == null) {
                return head;
            }
            iter = iter.next;
            counter++;
        }
//        if (head == null || head.next == null || head.next.next == null) {
//            return  head;
//        }

//        T8_reverseListNodeByNAndReverseAll.ListNode nnext = head.next.next;
        T8_reverseListNodeByNAndReverseAll.ListNode nnext = iter;
//        head.next.next = null;
        iter = null;
        T8_reverseListNodeByNAndReverseAll.ListNode newHead = reverse(nnext, k);

//        if (nnext.next != null) {
//            nnext.next.next = head;
//        } else {
//            nnext.next = head;
//        }

        int i = 0;
        T8_reverseListNodeByNAndReverseAll.ListNode index = nnext;
        while(i < k) {
            if (index.next == null) {
                break;
            }
            index = index.next;
            i++;
        }
        index.next = head;

        return newHead;

//        //just reverse it
//        if (head == null) {
//            return newHead;
//        }
//        T8_reverseListNodeByNAndReverseAll.ListNode next = head.next;
//        head.next = newHead;
//        return reverse(next, head);

//        //recursion with one parameter
//        if (head == null || head.next == null) {
//            return head;
//        }
//        T8_reverseListNodeByNAndReverseAll.ListNode next = head.next;
//        head.next = null;
//        T8_reverseListNodeByNAndReverseAll.ListNode newHead = reverse(next);
//        next.next = head;
//        return  newHead;

    }
}
