/*
Bubble sort is basically compare and swap. After every iteration we will get 1 elements at its correct position.

*/



package sorting;

public class BubbleSort {

	public void bubbleSort(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len; i++) {
			int count = 0;
			for(int j=1; j<len-i; j++) {
				if(arr[j-1] > arr[j]) {
					count++;
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				} 
			}
			if(count == 0)
				break;
		}
	}
}
