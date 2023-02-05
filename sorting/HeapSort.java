/*
Heap sort algorithm used the concept of heap and the heapify. It uses the complete binary tree relations between
the parent and child nodes in the tree. Here, if the root node index is i then its child will be 2*i+1 and 2*i + 2.
and to get parent node use (i-1)/2.

The time complexity is O(n logn) and space complexity is O(1)

For better and deep understanding use: https://www.programiz.com/dsa/heap-sort

*/




package sorting;

public class HeapSort {

	public void heapSort(int[] arr) {
		int n = arr.length;
		
		//Build max heap
		for(int i=n/2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		//heap sort
		for(int i=n-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//heapify the root element
			heapify(arr, i, 0);
		} 
		
	}

	private void heapify(int[] arr, int n, int i) {
		//Find the largest among the root, left child and right child
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		//Swap and heapify if the root is not largest
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n, largest);
		}
		
	}
	
}
