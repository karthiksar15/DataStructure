package practice;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}

public class PrimsAlgo {
    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));
        PrimsAlgo pa = new PrimsAlgo();
        pa.pirmsAlgo(adj, n);

    }

    void pirmsAlgo(ArrayList<ArrayList<Node>> adj, int N) {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mst[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(N, new Node());
        key[0] = 0;
        pq.add(new Node(key[0], 0));
        int count = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mst[u] = true;
            for (Node it : adj.get(u)) {
                if (mst[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    count = count + it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }
        System.out.println(count);

    }

}
