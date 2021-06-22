package arithmetic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entry.Product;
/**
 * @author 廖郑华
 * @create 2021-06-16-20:18
 * 算法类，例如排序算法
 */
public  class Arithmetic {


    //商品冒泡排序算法
    private static void PriceSort(List<Product> products){//价格
  
        for (int i = 0; i < products.size() - 1; i++) {  
            for (int j = 1; j < products.size() - i; j++) {  
            	Product temp;  
                if (products.get(j - 1).getPrice() - products.get(j).getPrice() > 0) { // 比较两个整数的大小  
  
                    temp = products.get(j - 1);  
                    products.set((j - 1), products.get(j));  
                    products.set(j, temp);  
                }  
            }  
        }  
        for (Product s : products) { 
            System.out.println(s.getPrice());  
        }  
    }  
    
    private static void QuantitySort(List<Product> products){//数量
    	  
        for (int i = 0; i < products.size() - 1; i++) {  
            for (int j = 1; j < products.size() - i; j++) {  
            	Product temp;  
                if (products.get(j - 1).getQuantity() - products.get(j).getQuantity() > 0) { // 比较两个整数的大小  
  
                    temp = products.get(j - 1);  
                    products.set((j - 1), products.get(j));  
                    products.set(j, temp);  
                }  
            }  
        }  
        for (Product s : products) { 
            System.out.println(s.getQuantity());  
        }  
    }

    
    
    private static void SalesVolumeSort(List<Product> products){//销量
  	  
        for (int i = 0; i < products.size() - 1; i++) {  
            for (int j = 1; j < products.size() - i; j++) {  
            	Product temp;  
                if (products.get(j - 1).getSalesVolume() - products.get(j).getSalesVolume() > 0) { // 比较两个整数的大小  
  
                    temp = products.get(j - 1);  
                    products.set((j - 1), products.get(j));  
                    products.set(j, temp);  
                }  
            }  
        }  
        for (Product s : products) { 
            System.out.println(s.getSalesVolume());  
        }  
    }
    
    private static void LocalDateTimeSort(List<Product> products){//生产日期
    	  
        for (int i = 0; i < products.size() - 1; i++) {  
            for (int j = 1; j < products.size() - i; j++) {  
            	Product temp;  
                if (products.get(j - 1).getProductionDate().isBefore(products.get(j).getProductionDate())) { // 比较两个整数的大小  
  
                    temp = products.get(j - 1);  
                    products.set((j - 1), products.get(j));  
                    products.set(j, temp);  
                }  
            }  
        }  
        for (Product s : products) { 
            System.out.println(s.getProductionDate());  
        }  
    }
   
    //商品二分查找算法



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



