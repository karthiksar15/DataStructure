package practice;

import java.util.*;


public class CobbledStreets {
    public static int cobbledStreets(int n, ArrayList<ArrayList<Integer>> street, int p) {
        int max = 0, min = Integer.MAX_VALUE;
        if (n == 1) {
            return 0;
        }
        for (ArrayList<Integer> temp : street) {
            max = Math.max(max, temp.get(0));
            min = Math.min(min, temp.get(0));
        }

        int N = max > n ? max + 1 : n + 1;
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mst[] = new boolean[N];

        ArrayList<ArrayList<Node>> adj = getList(max, street);
        //  System.out.println("adj---"+adj);
        for (int i = 0; i < N; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(N, new Node());
        //  key[min]=adj.get(min).get(0);
        key[min] = 0;
        pq.add(new Node(min, 0));
//        pq.add();
//        mst[min]=true;
//        key[min] = 0;
//        pq.add(new Node(key[0], 0));
        int count = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mst[u] = true;
            for (Node it : adj.get(u)) {

                //   System.out.println("key[it.getV()]--->"+key[it.getV()]);
                if (mst[it.getV()] == false && it.getWeight() < key[it.getV()]) {
//                    System.out.println("it.getWeight()--->"+it.getWeight());
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (key[i] != Integer.MAX_VALUE)
                count = count + key[i];
        }
        return p * count;
    }

    public static ArrayList<ArrayList<Node>> getList(int n, ArrayList<ArrayList<Integer>> list) {
        //   System.out.println(list);
        ArrayList<ArrayList<Node>> street = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            street.add(new ArrayList<Node>());

        for (ArrayList<Integer> temp1 : list) {
            street.get(temp1.get(0)).add(new Node(temp1.get(1), temp1.get(2)));
            street.get(temp1.get(1)).add(new Node(temp1.get(0), temp1.get(2)));
        }
        return street;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, e, t, p;
        t = sc.nextInt();
        while (t > 0) {
            t--;
            p = sc.nextInt();
            n = sc.nextInt();
            e = sc.nextInt();
            ArrayList<ArrayList<Integer>> street = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < e; i++) {
                street.add(new ArrayList<Integer>());
                street.get(i).add(sc.nextInt());
                street.get(i).add(sc.nextInt());
                street.get(i).add(sc.nextInt());
            }
            int ans = cobbledStreets(n, street, p);
            System.out.println(ans);
        }
        sc.close();
    }
}

/*
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. Take an example or two to confirm your understanding of the input/output & extend it to test cases
Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving.
     a. Obvious logic, tests ability to convert logic to code
     b. Figuring out logic
     c. Knowledge of specific domain or concepts
     d. Knowledge of specific algorithm
     e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one
3. Get to a point where you can explain your approach to a 10 year old
4. Take a stab at the high-level logic & write it down.
5. Try to offload processing to functions & keeping your main code small.
Milestone 3: Code by expanding your pseudocode
1. Make sure you name the variables, functions clearly.
2. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
3. Use libraries as much as possible
Milestone 4: Prove to the interviewer that your code works with unit tests
1. Make sure you check boundary conditions
2. Time & storage complexity
3. Suggest optimizations if applicable
*/
