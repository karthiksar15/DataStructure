package twoPointers;

public class RemoveDuplicate {

    public int removeDuplicates(int[] input)
    {
      int unq_ptr=1;
        for (int i = 1; i < input.length ; i++) {
            if(input[unq_ptr-1]!=input[i]) {
                input[unq_ptr]=input[i];
                unq_ptr++;
            }

        }
        return unq_ptr-1;
    }
    public static void main(String[] args) {
        int[] input={2,4,4,4,6,8,8};
        RemoveDuplicate rd=new RemoveDuplicate();
        System.out.println(rd.removeDuplicates(input));


    }
}
