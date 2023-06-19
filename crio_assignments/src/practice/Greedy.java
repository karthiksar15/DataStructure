import java.util.*;

class Pair{
    Integer profit;
    Integer deadline;
    public Pair(Integer profit,Integer deadline)
    {
        this.profit=profit;
        this.deadline=deadline;
    }
}

class JobSequencing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int deadlines[]=new int[n];
        int profits[]=new int[n];

        for(int i=0;i<n;i++)
        {
            deadlines[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            profits[i]=sc.nextInt();
        }

        System.out.println(jobSequencing(n, deadlines, profits));
    }

    static int jobSequencing(int n, int deadlines[], int profits[]){
        Pair[] profitCn=new Pair[n];
        Integer[] results=new Integer[101];
        Set<Integer> resultSt=new HashSet<Integer>();
        Arrays.fill(results,-1);
        int i=0;
        int maxProfit=0;
        for(int num:profits)
        {
            profitCn[i]=new Pair(profits[i],deadlines[i]);
            i++;
        }

        Arrays.sort(profitCn,new Comparator<Pair>(){

            public int compare(Pair p1,Pair p2)
            {
                return p2.profit.compareTo(p1.profit);
            }
        });

        for(i=0;i<n;i++)
        {

            if(results[profitCn[i].deadline]==-1)
            {
                results[profitCn[i].deadline]=profitCn[i].profit;
                resultSt.add(profitCn[i].deadline);
            }else
            {
                for(int j=i+1;j<n;j++)
                {
                    if(results[profitCn[j].deadline]==-1 && profitCn[i].deadline > profitCn[j].deadline)
                    {
                        results[profitCn[j].deadline]=profitCn[i].profit;
                        resultSt.add(profitCn[j].deadline);
                        break;
                    }
                }
            }
        }
        for(Integer res:resultSt)
        {
            System.out.println("res---"+res);
            System.out.println("results[res]---"+results[res]);
            maxProfit=maxProfit+results[res];
        }



        return maxProfit;
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