import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Q9_maxDiffInLength {
    public void maxD (int[] array, int d) {
        if (array == null || array.length == 0 || d <= 0) {
            return;
        }
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((x, y) -> x.get(0).compareTo(y.get(0)));
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((x, y) -> y.get(0).compareTo(x.get(0)));
        d = d >= array.length ? array.length : d;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (i >= d - 1) {
                if (i - minHeap.peek().get(1) >= d) {
                    minHeap.poll();
                }
                if (i - maxHeap.peek().get(1) >= d) {
                    maxHeap.poll();
                }
            }
            List<Integer> cur = new LinkedList<>();
            cur.add(array[i]);
            cur.add(i);
            minHeap.add(cur);
            maxHeap.add(cur);
            max = Integer.max(max,maxHeap.peek().get(0) - minHeap.peek().get(0));
        }
        System.out.println(max);

    }
}
