package DataStructuresAndAlgo;

class SortColors{
        public void sortColors(int[] nums) {
 int low=0;
        int n=nums.length;
        int high=n-1;
        int mid=0;
        while(mid<=high){
             switch(nums[mid]){
             case 0:
             swap(nums, low, mid);
             low++;
             mid++;
             break;
             case 1:
             mid++;
             break;
             case 2:
             swap(nums, mid, high);
             //The reason we are not incrementing mid is we dont know what is the element we swapped with 2..It could be 1 0r 0..
             //So that element has to be processed again..
             high--;
             break;

        }
        }

       
    }

    void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}