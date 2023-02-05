/*
The insertion sort algorithm is similar to the arranging the cards in order. Here we think the first card
as sorted and from the next card we find the suitable position for it and then insert at that posttion. 
The article link for this is here: https://www.programiz.com/dsa/insertion-sort

*/






package sorting;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		int len = arr.length;
		for(int i=1; i<len; i++) {
			int key = arr[i];
			System.out.println(key);
			int j=i-1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			j++;
			arr[j] = key;
		}
	}
}
