package br.com.whs.javatest;

public class TestCatho3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{3,5,6,3,3,5};
		int count = 0;
		for( int i = 0; i < A.length; i++ ) {
			for( int j = i+1; j < A.length; j++ ) {
				if( A[i] == A[j] ) {
					count++;
				}
			}
		}
		System.out.println("Count: "+count);
	}
	

}
