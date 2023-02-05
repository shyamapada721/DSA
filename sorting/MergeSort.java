/*
The main steps to implement merge sort is:
	1. Divide the elements 
	2. Merge the divided elements
	
In the merge sort, we divided the elements into two parts recursively until it become with size 1. 
Then, we merge the elements as they are two sorted array and after every merge we get one sorted array.

*/







package sorting;

public class MergeSort {
	public void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int left, int right) {
		if(left == right)	return;
		int mid = left + (right - left)/2;
		sort(arr, left, mid);
		sort(arr, mid+1, right);
		merge(arr,left,mid,right);
		
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int[] mergeArr = new int[right-left+1]; 
		int i = left, j = mid+1, ind=0;
		while(i<=mid && j<=right) {
			if(arr[i] > arr[j]) {
				mergeArr[ind++] = arr[j++];
				
			}else {
				mergeArr[ind++] = arr[i++];
			}
		}
		
		while(i <= mid) {
			mergeArr[ind++] = arr[i++];
		}
		while(j <= right) {
			mergeArr[ind++] = arr[j++];
		}
		ind = left;
		for(int el : mergeArr) {
			arr[ind++] = el;
		}
		
	}
	
}
