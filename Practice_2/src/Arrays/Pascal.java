package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascal {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> prev=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {

            if (results.size() == 0) {
                results.add(List.of(1));
            } else if (results.size() == 1) {
                results.add(List.of(1, 1));
            } else {
                List<Integer> temp=new ArrayList<>();
                temp.add(1);
                for (int j = 0; j < prev.size()-1; j++) {
                      int sum= prev.get(j)+prev.get(j+1);
                      temp.add(sum);
                }
                temp.add(1);
                results.add(temp);
            }
            prev=results.get(results.size()-1);

        }
        return results;
    }

    public static void main(String[] args) {
        Pascal p = new Pascal();
        System.out.println(p.generate(5));
    }
}
