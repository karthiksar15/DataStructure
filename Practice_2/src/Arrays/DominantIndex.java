package Arrays;

public class DominantIndex {

    public int dominantIndex(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max_indx=-1;
        boolean max_flag=true;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                max_indx=i;
            }
        }
        int chk=max/2;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>chk && nums[i]!=max)
                max_flag=false;

        }
        if(max_flag)
            return max_indx;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        DominantIndex di=new DominantIndex();
        System.out.println(di.dominantIndex(nums));

    }
}
