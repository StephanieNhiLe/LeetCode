class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i =0; i < numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
                if (!dfs(i, adjList, visited, recStack, stack)){
                    return new int[0]; 
                }
            }
        }

        int[] result = new int[numCourses];
        for (int i =0; i < numCourses; i++){
            result[i] = stack.pop();
        }
        return result;
    }

    public boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] recStack, Stack<Integer> stack){
        if (recStack[node]) return false; 
        if (visited[node]) return true;

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjList.get(node)){
            if (!dfs(neighbor, adjList, visited, recStack, stack)) return false;
        }

        recStack[node] = false;
        stack.push(node);
        return true;
    }
}