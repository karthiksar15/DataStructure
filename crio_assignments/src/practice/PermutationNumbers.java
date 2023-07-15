package practice;

import java.io.*;
import java.util.*;

class PermutationNumbers {

    public List<List<Integer>> permutation(int[] nums) {

        Set<Integer> source = new LinkedHashSet<>();
        for (int next: nums) source.add(next);

        List<List<Integer>> result = new ArrayList<>();
        permute(source, new ArrayList<>(), result);
        return result;

    }

    public void permute(Set<Integer> source, List<Integer> answer,
                        List<List<Integer>> result){
        if (source.isEmpty()) {
            result.add(answer);
            return;
        }

        for (Integer next: source) {
            List<Integer> updatedAnswer = new ArrayList<>(answer);
            updatedAnswer.add(next);
            Set<Integer> updatedSource = new LinkedHashSet<>(source);
            updatedSource.remove(next);
            permute(updatedSource, updatedAnswer, result);
        }


    }

    public static void main(String args[]) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> result = new PermutationNumbers().permutation(nums);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < result.size(); ++i) {
            for (int j = 0; j < result.get(i).size(); ++j) {
                output.write(result.get(i).get(j)+" ");
            }
            output.write("\n");
        }
        output.flush();
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
