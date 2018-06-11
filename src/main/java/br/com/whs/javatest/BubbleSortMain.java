package br.com.whs.javatest;

import java.util.Calendar;

import br.com.whs.javatest.sort.BubbleSort;

public class BubbleSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {3,1,6,2,9,7,13,4,0};
		Calendar c1 = Calendar.getInstance();
		BubbleSort.sort(arr);
		for( int i = 0; i < arr.length; i++ ) {
			System.out.println(arr[i]);
		}
		Calendar c2 = Calendar.getInstance();
		System.out.println("Time: "+(c2.getTimeInMillis()-c1.getTimeInMillis())+" ms");
	}

}
