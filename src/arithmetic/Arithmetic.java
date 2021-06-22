package arithmetic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import entry.Customer;
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

    
  //快速排序

    public static List<Customer> quickSort1(List<Customer> customers) {//用户余额
    	 
		Customer pivot = customers.get(0); //可替换代码
		//int mid = arr.size()/2;
		//int pivot = arr.get(mid);
		List<Customer> smaller = new ArrayList<Customer>(); //放置小于基准值的数据
		List<Customer> bigger = new ArrayList<Customer>(); //放置大于基准值的数据
 
                //分解当前列表的数据
		for(int i=1; i<customers.size();i++){ //替换i=0
			//if(i == mid)
			    //continue;
			//else
			if(pivot.getBalance() >= customers.get(0).getBalance()) 
				smaller.add(customers.get(i));
			else 
				bigger.add(customers.get(i));
		}
        
                //递归调用
		if(smaller.size() > 1) 
			quickSort1(smaller);
		if(bigger.size() > 1) 
			quickSort1(bigger);
 
		customers.removeAll(customers);
		customers.addAll(smaller);
		customers.add(pivot);
		customers.addAll(bigger);
 
		return customers;
	}
    
    public static List<Customer> quickSort2(List<Customer> customers) {//会员等级
   	 
		Customer pivot = customers.get(0); //可替换代码
		//int mid = arr.size()/2;
		//int pivot = arr.get(mid);
		List<Customer> smaller = new ArrayList<Customer>(); //放置小于基准值的数据
		List<Customer> bigger = new ArrayList<Customer>(); //放置大于基准值的数据
 
                //分解当前列表的数据
		for(int i=1; i<customers.size();i++){ //替换i=0
			//if(i == mid)
			    //continue;
			//else
			if(pivot.getLevel() >= customers.get(0).getLevel()) 
				smaller.add(customers.get(i));
			else 
				bigger.add(customers.get(i));
		}
        
                //递归调用
		if(smaller.size() > 1) 
			quickSort2(smaller);
		if(bigger.size() > 1) 
			quickSort2(bigger);
 
		customers.removeAll(customers);
		customers.addAll(smaller);
		customers.add(pivot);
		customers.addAll(bigger);
 
		return customers;
	}

    public static List<Customer> quickSort3(List<Customer> customers) {//注册时间
      	 
		Customer pivot = customers.get(0); //可替换代码
		//int mid = arr.size()/2;
		//int pivot = arr.get(mid);
		List<Customer> smaller = new ArrayList<Customer>(); //放置小于基准值的数据
		List<Customer> bigger = new ArrayList<Customer>(); //放置大于基准值的数据
 
                //分解当前列表的数据
		for(int i=1; i<customers.size();i++){ //替换i=0
			//if(i == mid)
			    //continue;
			//else
			if(customers.get(i - 1).getCreationTime().isBefore(customers.get(i).getCreationTime())) 
				smaller.add(customers.get(i));
			else 
				bigger.add(customers.get(i));
		}
        
                //递归调用
		if(smaller.size() > 1) 
			quickSort3(smaller);
		if(bigger.size() > 1) 
			quickSort3(bigger);
 
		customers.removeAll(customers);
		customers.addAll(smaller);
		customers.add(pivot);
		customers.addAll(bigger);
 
		return customers;
	}

    
 }






