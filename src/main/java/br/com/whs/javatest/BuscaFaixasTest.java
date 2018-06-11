package br.com.whs.javatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BuscaFaixasTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

	public static void process() {
		List<int[]> list = loadRange();
/*
		for( int i = 0; i < list.size(); i++ ) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println(mapper.writeValueAsString(list.get(i)));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		int card = genCardPreffix();
		System.out.println("card gerado: "+card);
		validate(card, list);
		System.out.println("FIM");
	}
	
	private static void validate(int card, List<int[]> list) {
		double maxIdx = 0;
		String message = "";
		for( int i = 0; i < list.size(); i++ ) {
			double min = (double)list.get(i)[0];
			double max = (double)list.get(i)[1];
			if( card >= min && card <= max ) {
				double idx = min / max;
				if( maxIdx < idx ) {
					maxIdx = idx;
					message = "card: "+card+" min: "+min+" max: "+max+" idx: "+idx;
				}
				//System.out.println("card: "+card+" min: "+min+" max: "+max+" idx: "+idx);
			}
		}
		System.out.println(message);
	}
	
	private static List<int[]> loadRange(){
		List<int[]> ret = new ArrayList<>();
		int limit = 100000;
		for( int i = 0; i < limit; i++ ) {
			int rnd = genCardPreffix();
			for( int j = 1; j < 10000; j = j*10 ) {
				int min = rnd - j;
				int max = min + (j-1);
				ret.add(new int[] {min,max});
			}
		}
		return ret;
	}
	
	private static int genCardPreffix() {
		Random rand = new Random();
		int rnd = rand.nextInt(999999);
		do {
			rnd = rand.nextInt(999999);
		} while ( !(rnd >300000  && rnd <699999) );
		return rnd;
	}
}
