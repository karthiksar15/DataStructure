package crio_assignments.src.assessments;

import java.util.*;

public class SameSetOfWords {
    public List<List<String>> sameSetOfWords(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer,List<String>> mp=new HashMap<>();
        for(String str:strs)
        {

            int sum=0;
            for(char arr:str.toCharArray())
            {
                sum+=arr;
            }
            if(mp.containsKey(sum))
            {
                mp.get(sum).add(str);
            }else
            {
                mp.put(sum,new ArrayList(List.of(str)));
            }
        }
        for(List<String> list:mp.values())
        {
            result.add(list);
        }
        return result;
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int check = 0;
        String strs[] = new String[n];
        for(int i = 0 ; i < n ;i++) {
            strs[i] = scanner.next();
        }
        List<List<String>> result = new SameSetOfWords().sameSetOfWords(strs);

        for (int i = 0; i < result.size(); ++i) {
            for (int  j = 0; j < result.get(i).size(); ++j) {
                System.out.printf("%s ", result.get(i).get(j));
            }
            System.out.printf("\n");
        }
    }
}
