package practice;

import java.util.*;

public class FindIteranary {

    public List<String> findIteranary(List<List<String>> inputs)
    {
//        List<String> adj=new ArrayList<>();
//        List<List<String>> adjList=new ArrayList<>();
        Map<String,List<String>> graph=new HashMap<>();

        for (List<String> edge:inputs)
        {
            String from=edge.get(0);
            String to=edge.get(1);
             graph.putIfAbsent(from,new ArrayList<>());
             graph.get(from).add(to);
        }
        for (List<String> lst:graph.values())
        {
            Collections.sort(lst);
        }
        Stack<String> st=new Stack<>();
        st.push("JFK");
        List<String> resultLst=new ArrayList<>();
        while (!st.isEmpty())
        {
           String current=st.peek();
           if(!graph.containsKey(current) || graph.get(current).isEmpty())
           {
               resultLst.add(st.pop());

           }else
           {
               st.push(graph.get(current).remove(0));
           }
        }
        Collections.reverse(resultLst);
      System.out.println(resultLst);
       return resultLst;
    }
    public static void main(String[] args) {
        FindIteranary fi=new FindIteranary();
//        [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        List<String> temp= new ArrayList<>(List.of("JFK","SFO"));
        List<String> temp1= new ArrayList<>(List.of("JFK","ATL"));
        List<String> temp2= new ArrayList<>(List.of("SFO","ATL"));
        List<String> temp3= new ArrayList<>(List.of("ATL","JFK"));
        List<String> temp4= new ArrayList<>(List.of("ATL","SFO"));
        List<List<String>> input=new ArrayList<>();
        input.add(temp);
        input.add(temp1);
        input.add(temp2);
        input.add(temp3);
        input.add(temp4);
        fi.findIteranary(input);
    }
}
