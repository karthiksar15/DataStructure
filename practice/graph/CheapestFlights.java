package practice.graph;

import java.util.*;

class Cheapestflight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> flight = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < e; i++) {
            flight.add(new ArrayList<Integer>());
            flight.get(i).add(sc.nextInt());
            flight.get(i).add(sc.nextInt());
            flight.get(i).add(sc.nextInt());
        }
        int source = sc.nextInt();
        int des = sc.nextInt();
        int k = sc.nextInt();
        int ans = cheapestFlights(n, flight, source, des, k);
        System.out.print(ans);
        sc.close();
    }

    public static int cheapestFlights(int n, ArrayList<ArrayList<Integer>> flight, int source, int des, int k) {
        int[][] adj_matrix = new int[n + 1][n + 1];
        for (int i = 0; i < flight.size(); i++) {
            adj_matrix[flight.get(i).get(0)][flight.get(i).get(1)] = flight.get(i).get(2);
        }
        int[] distances = new int[n + 1];
        int[] curr_stops = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(curr_stops, Integer.MAX_VALUE);
        distances[source] = 0;
        curr_stops[source] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{source, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int node = info[0], cost = info[1], stops = info[2];
            if (node == des)
                return cost;
            if (stops == k + 1)
                continue;
            for (int neigh = 0; neigh <= n; neigh++) {
                if (adj_matrix[node][neigh] > 0) {
                    int u = cost, v = distances[neigh], w = adj_matrix[node][neigh];
                    if (u + w < v) {
                        minHeap.offer(new int[]{neigh, u + w, stops + 1});
                        distances[neigh] = u + w;
                    } else if (stops + 1 < curr_stops[neigh]) {
                        minHeap.offer(new int[]{neigh, u + w, stops + 1});
                        curr_stops[neigh] = stops;
                    }

                }
            }
        }
        return distances[des] == Integer.MAX_VALUE ? -1 : distances[des];

    }
}
