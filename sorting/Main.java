package sorting;

public class Main {

	public static void main(String[] args) {
		int[] arr = {8,7,6,0,4,98,12,34,10,12,49};
		
//		MergeSort ms = new MergeSort();
//		ms.mergeSort(arr);
//		print(arr);
		
//		QuickSort qs = new QuickSort();
//		qs.quickSort(arr);
//		print(arr);
		
//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(arr);
//		print(arr);
		
//		SelectionSort ss = new SelectionSort();
//		ss.selectionSort(arr);
//		print(arr);
		
		
//		InsertionSort is = new InsertionSort();
//		is.insertionSort(arr);
//		print(arr);
		
		
		
//		CountingSort cs = new CountingSort();
//		cs.countingSort(arr);
//		print(arr);
		
		
//		RadixSort rs = new RadixSort();
//		rs.radixSort(arr);
//		print(arr);
		
		HeapSort hs = new HeapSort();
		hs.heapSort(arr);
		print(arr);
		

	}

	public static void print(int[] arr) {
		// TODO Auto-generated method stub
		for(int el : arr) {
			System.out.print(el+" ");
		}
		System.out.println();
	}

}
