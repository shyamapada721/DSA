/*
The counting sort algorithm is very simple. The steps are:
	1. Find the max element into the array
	2. Make an array of size max+1
	3. Store the count of every element present in the array
	4. Traverse the count array and arrange elements according to that
	
The Time complexity of this algorithm is O(n+k) and space complexity is O(max)

The algorithm is suitable for:
	1. When the stored elements are small
	2. When we need sorting in linear time complexity

*/




package sorting;

public class CountingSort {

	public void countingSort(int[] arr) {
		// Find the max of the array
		int maxElement = findMax(arr);
		// Create a count array of size maxElement+1
		int[] count = new int[maxElement + 1];

		// store the frequency of each number from the arr
		for (int n : arr) {
			count[n] = count[n] + 1;
		}


		int i = 0;
		for (int j = 0; j < count.length; j++) {
			while (count[j] > 0) {
				arr[i++] = j;
				count[j] -= 1;
			}
		}

	}

	private int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		
		for(int n : arr) {
			if(n > max) {
				max = n;
			}
		}
		return max;
	}

}
