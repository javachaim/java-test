package br.com.whs.javatest.sort;

import java.util.stream.IntStream;

public class BubbleSort {

	public static void sort( Integer[] arrInt ) {
		if( arrInt != null && arrInt.length > 0 ) {
			for( int i = arrInt.length-1; i >=1; i-- ) {
				for( int j = 0; j < i; j++ ) {
					if( arrInt[j] > arrInt[j+1] ) {
						int s = arrInt[j];
						arrInt[j] = arrInt[j+1];
						arrInt[j+1] = s;
					}
				}
			}
		}
	}
	
	public static void bubbleSort(Integer[] arr) {
	    int n = arr.length;
	    IntStream.range(0, n - 1)
	    .flatMap(i -> IntStream.range(i + 1, n - i))
	    .forEach(j -> {
	        if (arr[j - 1] > arr[j]) {
	            int temp = arr[j];
	            arr[j] = arr[j - 1];
	            arr[j - 1] = temp;
	            }
	     });
	}
	
	public static void optimizedBubbleSort(Integer[] arr) {
	    int i = 0, n = arr.length;
	    boolean swapNeeded = true;
	    while (i < n - 1 && swapNeeded) {
	        swapNeeded = false;
	        for (int j = 1; j < n - i; j++) {
	            if (arr[j - 1] > arr[j]) {
	                int temp = arr[j - 1];
	                arr[j - 1] = arr[j];
	                arr[j] = temp;
	                swapNeeded = true;
	            }
	        }
	        if(!swapNeeded) {
	            break;
	        }
	        i++;
	    }
	}
}
