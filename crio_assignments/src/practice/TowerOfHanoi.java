package practice;

import java.util.*;

public class TowerOfHanoi {
    // Implement your solution here
    ArrayList<String> towerOfHanoi(int n) {
        String from="A",to="C",aux="B";
        ArrayList<String> result=new ArrayList<>();
        check(n, from,to,aux,result);
        return result;
    }

    public void check(int n, String from_rod, String to_rod, String aux_rod,ArrayList<String> result)
    {
        if(n==1)
        {
            result.add(n+" "+from_rod+" "+to_rod);
            return;
        }
        check(n-1, from_rod, aux_rod, to_rod,result);
        result.add(n+" "+from_rod+" "+to_rod);
        // System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        check(n-1, aux_rod, to_rod, from_rod,result);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> result = new TowerOfHanoi().towerOfHanoi(n);
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }
}
