class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCounts = new HashMap<>();
        int maxEdges = 0;
        
        for (List<Integer> row : wall) {
            int edge = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                edge += row.get(i);
                edgeCounts.put(edge, edgeCounts.getOrDefault(edge, 0) + 1);
                maxEdges = Math.max(maxEdges, edgeCounts.get(edge));
            }
        }
        
        return wall.size() - maxEdges;
    }
}