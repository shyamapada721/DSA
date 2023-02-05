/*
In Radix sort, we sort the array according to the digits of the array element. 
First, we sort the array according to the unit place digit, then 10th place, then 100th place and so on.
we use counting sort as the intermedieate sorting algorithm.

The time comlexity of the algorithm is O(d(n+k)) where the d is the number of times we have to perform counting sort.
The space complexity is O(max)

This algorithm is suitable when the elements are too large.

The resource article is : https://www.programiz.com/dsa/radix-sort

*/


package sorting;

public class RadixSort {
	
	public void radixSort(int[] arr) {
		int max = getMax(arr);
		for(int place=1; max/place > 0; place *= 10) {
			countingSort(arr, place);
			
		}
	}

	private void countingSort(int[] arr, int place) {
		int max = getMax(arr);
		int[] output = new int[arr.length];
		int[] count = new int[10];
		
		for(int el : arr) {
			count[(el/place)%10]++;
		}
		
		for(int i=1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = arr.length -1; i >= 0; i--) {
			int el = arr[i];
			output[count[(el/place)%10]-1] = el;
			count[(el/place)%10]--;
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = output[i];
		}
		
	}

	private int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int n: arr) {
			if(n > max) {
				max = n;
			}
		}
		return max;
	}

}
