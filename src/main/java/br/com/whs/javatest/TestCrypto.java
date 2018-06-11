package br.com.whs.javatest;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class TestCrypto {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String key = "ThisIsASecretKey";
		String msg = "Luis Fernando Chaim";
		String cod = codifica(msg, key);
		System.out.println("cod: ["+cod+"]");
		String dec = decodificar(cod, key);
		System.out.println("dec: ["+dec+"]");
	}

	public static String codifica(String mensagem, String chave) throws Exception {

		byte[] bytemensagem = mensagem.getBytes();
		byte[] bytechave = chave.getBytes();

		Key secretKey = new SecretKeySpec(bytechave,"AES");

		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] cipher = c.doFinal(bytemensagem);

		String codigo = Base64.getEncoder().encodeToString(cipher);
		return codigo;

	}

	public static String decodificar(String decmensagem, String chave)throws Exception{

		byte[] bytechave = chave.getBytes();

		Key secretKey = new SecretKeySpec(bytechave,"AES");

		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, secretKey);

		byte[] byteDecmensagem = Base64.getDecoder().decode(decmensagem);
		byte[] byteDecodifica = c.doFinal(byteDecmensagem);

		String mensagem = new String(byteDecodifica);
		return mensagem;

	}
}
