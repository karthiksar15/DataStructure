package practice;

import java.util.*;

class NodeTest {
    public int val;
    public List<NodeTest> neighbors;

    public NodeTest() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public NodeTest(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public NodeTest(int val, List<NodeTest> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeTest nodeTest = (NodeTest) o;
        return val == nodeTest.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}

public class ClonableGraph {
    public NodeTest cloneGraph(NodeTest node) {
        Map<NodeTest,NodeTest> set=new HashMap<>();
        Stack<NodeTest> st=new Stack<>();
        st.push(node);
        set.put(node,new NodeTest(node.val));
        while(!st.isEmpty())
        {
            NodeTest nodeTest=st.pop();
            for(NodeTest nodeTest1: nodeTest.neighbors)
            {
                if(!set.containsKey(nodeTest1))
                {
                    set.put(nodeTest1,new NodeTest(nodeTest1.val));
                    st.push(nodeTest1);
                }
                set.get(nodeTest).neighbors.add(set.get(nodeTest1));
            }

        }
        return set.get(node);
    }

    public static void main(String[] args) {
        ClonableGraph cg = new ClonableGraph();
        NodeTest firstNode = new NodeTest();
        Map<Integer, NodeTest> mp = new HashMap<>();
        int[][] edges = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        int index = 1;
        for (int[] edge : edges) {
            for (int e : edge) {
                if (mp.containsKey(index)) {
                    if (mp.containsKey(e)) {
                        NodeTest nodeTest1 = mp.get(index);
                        NodeTest nodeTest2 = mp.get(e);
                        nodeTest1.neighbors.add(nodeTest2);
                    } else {
                        NodeTest nodeTest1 = mp.get(index);
                        NodeTest nodeTest2 = new NodeTest(e);
                        nodeTest1.neighbors.add(nodeTest2);
                        mp.put(e, nodeTest2);
                    }
                } else {
                    if (mp.containsKey(e)) {
                        NodeTest nodeTest1 = new NodeTest(index);
                        NodeTest nodeTest2 = mp.get(e);
                        nodeTest1.neighbors.add(nodeTest2);
                        mp.put(index, nodeTest1);
                    } else {
                        NodeTest nodeTest1 = new NodeTest(index);
                        NodeTest nodeTest2 = new NodeTest(e);
                        nodeTest1.neighbors.add(nodeTest2);
                        firstNode = nodeTest1;
                        mp.put(index, nodeTest1);
                    }


                }
            }
            index++;
        }

        int count = 4;
        NodeTest nodeTestPrint = cg.cloneGraph(firstNode);
        while (count > 0) {
            NodeTest nodeTest = nodeTestPrint;
            System.out.println("parent--" + nodeTest.val);
            List<NodeTest> nodeTestList = nodeTest.neighbors;
            for (NodeTest nodeTest1 : nodeTestList) {
                System.out.println(nodeTest1.val);
                nodeTestPrint = nodeTest1;
            }
            count--;
        }

    }


}

