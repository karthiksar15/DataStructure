package matrix;

import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStocks {
    // Implement your solution Here
    static int last_index=0;
    public int maxProfit(int[] prices) {
        int curr=0,profit=0,flag=0,bought=0;
        for(int i=1;i<prices.length;i++)
        {
            if(bought==0)
            {
                if(isLessPrice(i,curr,flag,prices))
                {
                    continue;
                }else
                {
                    if(prices[i-1]<prices[i])
                    {
                        curr=prices[i-1];
                        flag=1;
                        bought=1;
                    }else
                    {
                        curr=prices[i];
                        bought=1;
                    }
                }
            }else
            {
                if(isMoreProfit(i,curr,flag,prices))
                {
                    continue;
                }
                else
                {
                    if(last_index==1)
                    {
                        if(prices[i]>curr)
                        {
                            int temp=prices[i]-curr;
                            profit=profit+temp;
                            bought=0;
                        }
                    }else
                    {
                        if(flag==1)
                        {
                            int temp=prices[i-1]-curr;
                            profit=profit+temp;
                            bought=0;
                            flag=0;
                        }
                        else if(prices[i]>curr)
                        {
                            int temp=prices[i]-curr;
                            profit=profit+temp;
                            bought=0;
                        }
                    }
                }

            }

        }
        return profit;
    }
    public boolean isMoreProfit(int index,int cur_price,int flag,int[] prices)
    {

        if(flag==1)
        {
            if((index+1)==prices.length)
            {
                last_index=1;
                return false;
            }
            else if(prices[index]>prices[index-1])
            {
                return true;
            }
        }else
        {
            if(index+1<prices.length && prices[index+1]>prices[index])
            {
                return true;
            }
        }

        return false;
    }
    public boolean isLessPrice(int index,int cur_price,int flag,int[] prices)
    {

        if(index+1<prices.length && prices[index+1]<prices[index])
        {
            return true;
        }


        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prices = new int[scanner.nextInt()];
        for (int i = 0; i < prices.length; i++)
            prices[i] = scanner.nextInt();
        scanner.close();

        int result = new BestTimeToBuyAndSellStocks().maxProfit(prices);
        System.out.print(Integer.toString(result));
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
