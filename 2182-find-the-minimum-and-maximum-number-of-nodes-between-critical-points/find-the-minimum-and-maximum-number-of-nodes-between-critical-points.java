class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        int first = -1;
        int prevCritical = -1;

        int idx = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

    
            boolean isMin = curr.val < prev.val &&
                            curr.val < curr.next.val;

          
            boolean isMax = curr.val > prev.val &&
                            curr.val > curr.next.val;

            if (isMin || isMax) {

                if (first == -1) {
                 
                    first = idx;
                } else {
                    
                    minDistance = Math.min(
                        minDistance,
                        idx - prevCritical
                    );

                   
                    maxDistance = idx - first;
                }

                prevCritical = idx;
            }

            prev = curr;
            curr = curr.next;
            idx++;
        }

        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}