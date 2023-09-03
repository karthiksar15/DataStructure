package practice.graph;

import java.util.*;

class NetworkDelayTime {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> b = new ArrayList<>();

            b.add(sc.nextInt());
            b.add(sc.nextInt());
            b.add(sc.nextInt());
            edges.add(b);
        }

        int k = sc.nextInt();

        int ans = NetworkDelayTime.networkDelayTime(n, edges, k);

        System.out.println(ans);
    }


    public static int networkDelayTime(int N, ArrayList<ArrayList<Integer>> edges, int K) {
        int n = N, k = K;
        int[][] times = new int[edges.size()][edges.get(0).size()];
        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.get(0).size(); j++) {
                times[i][j] = edges.get(i).get(j);
            }
        }
        List<List<int[]>> edges_new = new ArrayList<>();
        int start = k - 1;
        for (int i = 0; i < n; i++) edges_new.add(new ArrayList<>());
        for (int[] time : times) edges_new.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] shortestTime = new int[n];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        shortestTime[start] = 0;
        queue.add(new int[]{start, shortestTime[start]});
        while (!queue.isEmpty()) {
            int cur = queue.poll()[0];
            for (int[] edge : edges_new.get(cur)) {
                if (shortestTime[edge[0]] > shortestTime[cur] + edge[1]) {
                    shortestTime[edge[0]] = shortestTime[cur] + edge[1];
                    queue.offer(new int[]{edge[0], edge[1]});
                }
            }
        }
        int answer = 0;
        for (int time : shortestTime) answer = Math.max(answer, time);
        return answer == Integer.MAX_VALUE ? -1 : answer;

    }
}