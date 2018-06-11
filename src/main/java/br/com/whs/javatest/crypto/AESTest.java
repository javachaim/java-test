package br.com.whs.javatest.crypto;

public class AESTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		process();
	}

	public static void process() throws Exception {
		AESAlgorithm alg = new AESAlgorithm();
		String txt = "lfchaim";
		String enc = alg.encyrpt(txt);
		String dec = alg.decrypt(enc);
		System.out.println("enc: ["+enc+"] dec: ["+dec+"]");
	}
}
