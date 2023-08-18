class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<Pair<Integer, Integer>> frontier = new ArrayDeque();
        for(int i = 0;i < n; i++)
            frontier.add(new Pair(i, 1 << i));
        boolean[][] visited = new boolean[n][1<<n];
        int res = 0;
        while(!frontier.isEmpty()){
            for(int i = frontier.size();i > 0; i--){
                int node = frontier.peek().getKey();
                int state = frontier.poll().getValue();
                if(state == (1 << n) -1)
                    return res;
                if(visited[node][state])
                    continue;
                visited[node][state] = true;
                for(int neighbor:graph[node]){
                    frontier.add(new Pair(neighbor, state | (1 << neighbor)));
                }
            }
            res++;
        }
        throw new IllegalArgumentException();
    }
}