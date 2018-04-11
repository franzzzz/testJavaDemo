import java.util.*;

public class Q6_hashMapTree {
    public HashMap<Integer, List<Integer>> initial() {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        map.put(1, list1);
        List list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        map.put(2, list2);
        List list3 = new ArrayList<>();
        list3.add(5);
        list3.add(7);
        map.put(3, list3);
        List list4 = new ArrayList<>();
        list4.add(7);
        map.put(4, list4);
        map.put(5, new ArrayList<Integer>());
        map.put(7, new ArrayList<Integer>());
        return map;
    }

    public List<Integer> hashMapTree(HashMap<Integer, List<Integer>> map) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> node : map.entrySet()) {
            isVisited.put(node.getKey(), true);
        }
        for (Map.Entry<Integer, List<Integer>> node : map.entrySet()) {
            List<Integer> neighborList = node.getValue();
            for (Integer neighborValue : neighborList) {
                if (isVisited.get(neighborValue)) {
                    isVisited.put(neighborValue, false);
                }
            }
        }
        Deque<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Boolean> node : isVisited.entrySet()) {
            if (node.getValue()) {
                queue.offerLast(node.getKey());
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.pollLast();
            result.add(cur);
            for (Integer neighbor : map.get(cur)) {
                if (!isVisited.get(neighbor)) {
                    queue.offerFirst(neighbor);
                    isVisited.put(neighbor, true);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
//        Deque<Integer> stack = new LinkedList<>();
//        for(Map.Entry<Integer, Boolean> node : isVisited.entrySet()) {
//            if (node.getValue()) {
//                stack.offerLast(node.getKey());
//            }
//        }
//        while(!stack.isEmpty()) {
//            Integer cur = stack.peekLast();
//            boolean allVisited = true;
//            for(Integer neighbor : map.get(cur)) {
//                if (!isVisited.get(neighbor)) {
//                    stack.offerLast(neighbor);
//                    isVisited.put(neighbor, true);
//                    allVisited = false;
//                }
//            }
//            if (allVisited) {
//                result.add(stack.peekLast());
//                stack.pollLast();
//            }
//        }
//        return result;
//    }
}
