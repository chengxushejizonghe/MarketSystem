package arithmetic;
import java.util.Arrays;
/**
 * @author 林敬舒
 * @create 2021-06-16-20:18
 * 算法类，例如排序算法
 */
public class Arithmetic {

    //商品冒泡排序算法
    private static int[] bubbleSort(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) {
            return nums;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0, subLen = len - 1 - i; j < subLen; j++) {
                if(nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    //商品二分查找算法
    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int middle = (low + high)/2;
            if(x == arr[middle]) {
                return middle;
            }else if(x <arr[middle]) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
    /**
    //递归实现二分查找
    public static int binarySearch(int[] dataset,int data,int beginIndex,int endIndex){
           int midIndex = (beginIndex+endIndex)/2;
           if(data <dataset[beginIndex]||data>dataset[endIndex]||beginIndex>endIndex){
               return -1;
           }
           if(data <dataset[midIndex]){
               return binarySearch(dataset,data,beginIndex,midIndex-1);
           }else if(data>dataset[midIndex]){
               return binarySearch(dataset,data,midIndex+1,endIndex);
           }else {
               return midIndex;
           }
       }
*/

    //用户希尔排序算法
    public class ShellSortDemo {
    	/* An utility function to print array of size n */
     
    	/* function to sort array using shellSort */
    	void sort(int A[]) {
    		int n = A.length;
     
    		// Start with a larger gap, then reduce the gap to 1
    		// we take gap sequence in order of |N/2|, |N/4|, |N/8|...1
    		for (int gap = n / 2; gap > 0; gap /= 2) {
    			// we perform gapped insertion sort for this gap size.
    			// The first gap elements a[0..gap-1] are already
    			// in gapped order keep adding one more element
    			// until the entire array is gap sorted
    			for (int i = gap; i < n; i += 1) {
    				// store a[i] in temp and make a hole at
    				// position i
    				int temp = A[i];
    				// shift earlier gap-sorted elements up until
    				// the correct location for a[i] is found
    				int j;
    				for (j = i; j >= gap && A[j - gap] > temp; j -= gap)
    					A[j] = A[j - gap];
     
    				// put temp (the original a[i]) in its correct
    				// location
    				A[j] = temp;
    			}
    		}
    	}
    }
    //用户查找算法
    public static int quickSelect(int[] arr, int selectIndex) {
        int s = 0;
        int i = s+1;
        while(i < arr.length) {
            if(arr[i] < arr[0]) {
                int t = arr[s+1];
                arr[s+1] = arr[i];
                arr[i] = t;
                s += 1;
                i = s+1;
                continue;
            }
            i++;
        }

        // i找到最后之后将下表为s的值和第一个值交换
        int temp = arr[0];
        arr[0] = arr[s];
        arr[s] = temp;

        if(selectIndex-1 == s) {
            return arr[s];
        }else {
            // 将数组不需要的切掉   用后一部分去回调
            int arrs[] = new int[arr.length - s];
            for(int j = s; j < arr.length; j++) {
                arrs[j-s] = arr[j];
            }
            quickSelect(arrs, selectIndex);
        }
        return 0;
    }
  
 }
