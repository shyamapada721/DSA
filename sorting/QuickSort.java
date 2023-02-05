/*
Quick Sort is a very simple algorithm. Here, at every step we have to select an element which is called by pivot.
Then place the pivot at the right positin using the partition method and return the pivot element index.
		
		Then we have to use the same quicksort algorithm on the both side of the pivot index recursively.

*/

package sorting;

public class QuickSort {
	public void quickSort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}

	private void quicksort(int arr[] , int low, int high){
	    
	    if (low < high) {

	      int pivot = partition(arr, low, high) ;
	      quicksort(arr, low, pivot - 1)  ;
	      quicksort(arr, pivot + 1, high)  ;
	    
	    }

	  }
	
	int partition(int[] arr, int low , int high){
		
		int pivot = arr[high];
		int i=low;
		
		for(int j=low; j<high; j++) {
			if(arr[j] <= pivot) {
				//i = i+1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		
		//i = i+1;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		
		
		return i;
	  }
	

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for(int el : arr) {
			System.out.print(el+" ");
		}
		System.out.println();
	}
	
}
