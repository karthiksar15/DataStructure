package practice;

import java.io.*;
import java.util.*;
//creates an undirected graph
class Graph
{
    //stores the number of vertices
    private int Vertices;
    //creates a linked list for the adjacency list of the graph
    private LinkedList<Integer> adjlist[]; //arraylist
    //creating a constructor of the Graph class
    Graph(int count_v)
    {
//assigning the number of vertices to the passed parameter
        Vertices = count_v;
        adjlist = new LinkedList[count_v];
//loop for creating the adjacency lists
        for (int i=0; i<count_v; ++i)
            adjlist[i] = new LinkedList(); //0 - 9
    }
    //method that adds a new edge to the graph
    void addNewEdge(int v, int w)
    {
        adjlist[v].add(w);  // Add w to v's list.
    }
    //logic of the DFS
//traversal starts from the root node
    void traversalDFS(int v, boolean vnodelist[])
    {
//if current node (root node) is visited, add it to the vnodelist
        vnodelist[v] = true;
        System.out.print(v+" ");
//detrmines the negihboring nodes of the current node
//iterates over the list
        Iterator<Integer> i = adjlist[v].listIterator();
        while (i.hasNext())
        {
//returns the next element in the iteration and store that element in the variable n
            int n = i.next();
            if (!vnodelist[n])
//calling the function that performs depth first traversal
                traversalDFS(n, vnodelist);
        }
    }
    void DFS(int v)
    {
//creates an array of boolean type for visited node
//initially all nodes are unvisited
        boolean visited[] = new boolean[Vertices];
//call recursive traversalDFS() function for DFS
        traversalDFS(v, visited);
    }
}
//implementing driver code
public class DepthFirstSearch
{
    public static void main(String args[])
    {
//creates a graph having 10 vertices
        Graph g = new Graph(60);
//add edges to the graph
        g.addNewEdge(10, 2);
        g.addNewEdge(2, 3);
        g.addNewEdge(3, 4);
        g.addNewEdge(4, 50);
        g.addNewEdge(50, 7);
        g.addNewEdge(10, 3);
        g.addNewEdge(10, 5);
        g.addNewEdge(50, 50);
        g.addNewEdge(2, 6);
        g.addNewEdge(3, 7);
//print sequencnce in which BFS traversal done
        System.out.println("Depth-first traversal of graph is: ");
//traversal starts from the node 3 (as root node)
        g.DFS(1);
    }
}
