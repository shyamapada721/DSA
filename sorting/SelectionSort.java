/*
By the selection sort we iterate through the array and find out the minimum element in the array.
Then store the element from left.

*/

package sorting;

public class SelectionSort {
	public void selectionSort(int[] arr) {
		int len = arr.length;
		for(int i=0; i<len; i++) {
			int minIndex = i;
			for(int j=i+1; j<len; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
