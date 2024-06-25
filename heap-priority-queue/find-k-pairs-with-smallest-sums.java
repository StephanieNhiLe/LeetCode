class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{i, 0});
        }
        
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            List<Integer> listPair = new ArrayList<>();
            listPair.add(nums1[cur[0]]);
            listPair.add(nums2[cur[1]]);
            result.add(listPair);
            
            if (cur[1] + 1 < nums2.length) {
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        
        return result;
    }
}