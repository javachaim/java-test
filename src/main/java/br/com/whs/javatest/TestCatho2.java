package br.com.whs.javatest;

import java.util.ArrayList;
import java.util.List;

public class TestCatho2 {

	public static void main(String[] args) {
		System.out.println(process());
	}
	
	public static String process() {
		// TODO Auto-generated method stub
		// Falhou (12, "1A 1A,12A 12A", "12A")
		int N = 4;
		String S = "1B 2C,2D 4D";
		String T = "2B 2D 3D 4D 4A";

		//N = 12;
		//S = "1A 1A,12A 12A";
		//T = "12A";
		
		String[] tSplit = T.split(" ");
		String[] sSplitAux = S.split(",");
		
		int[][] matrix = new int[N][N];
		int countSunk = 0;
		int countShip = 0;
		for( int i = 0; i < sSplitAux.length; i++ ) {
			String[] sSplit = sSplitAux[i].split(" ");
			int[] idx1 = getIndex(sSplit[0]);
			int[] idx2 = getIndex(sSplit[1]);
			List<int[]> listCoord = new ArrayList<int[]>();
			for(int j = idx1[0]; j <= idx2[0]; j++ ) {
				for( int k = idx1[1]; k <= idx2[1]; k++ ) {
					try {
						matrix[j][k] = 1;
					}catch(ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
					listCoord.add(new int[]{j,k});
				}
			}
			int match = 0;
			for( int j = 0; j < listCoord.size(); j++ ) {
				for( int k = 0; k < tSplit.length; k++ ) {
					int[] idx = getIndex(tSplit[k]);
					if( listCoord.get(j)[0] == idx[0] && listCoord.get(j)[1] == idx[1] ) {
						match++;
					}
				}
			}
			if( match == listCoord.size() ) {
				countShip++;
			}else {
				countSunk+=match;
			}
		}
		return ""+countShip+","+countSunk;
	}

	public static int[] getIndex(String code) {
		int[] ret = new int[2];
		ret[0] = Integer.parseInt(code.substring(0, code.length()-1))-1;
		ret[1] = (int)code.charAt(code.length()-1)-65;
		return ret;
	}
}
