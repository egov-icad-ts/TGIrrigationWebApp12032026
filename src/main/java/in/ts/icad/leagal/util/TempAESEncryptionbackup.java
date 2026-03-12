package in.ts.icad.leagal.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;





//import org.apache.commons.codec.binary.Base64;



public class TempAESEncryptionbackup  {
	

	private static final String ALGORITHM = "AES";
	 private static final byte[] keyValue =
	            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
	 /**
	     * Encrypt a string with AES algorithm.
	     *
	     * @param data is a string
	     * @return the encrypted string
	     */
	   public static String encrypt(String value) throws Exception
	   {
	       
		   Key key = generateKey();
	       Cipher cipher = Cipher.getInstance(TempAESEncryptionbackup.ALGORITHM);
	       cipher.init(Cipher.ENCRYPT_MODE, key);
	       byte [] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
	     
	       String encryptedValue64 = Base64.encodeBase64String(encryptedByteValue);
	       return encryptedValue64;
	             
	   }
	   /**
	     * Decrypt a string with AES algorithm.
	     *
	     * @param encryptedData is a string
	     * @return the decrypted string
	     */
	   
	   public static String decrypt(String value) throws Exception
	   {
		   Key key = generateKey();
	       Cipher cipher = Cipher.getInstance(TempAESEncryptionbackup.ALGORITHM);
	       cipher.init(Cipher.DECRYPT_MODE, key);
	       byte [] decryptedValue64 = Base64.decodeBase64(value);
	       byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
	       String decryptedValue = new String(decryptedByteValue,"utf-8");
	       return decryptedValue;
	               
	   }
	   /**
	     * Generate Salt.
	     */
	   
	   /**
	     * Generate Salt.
	     */
	   public static String decryptInputText(String ciphertext) throws Exception {
			SecretKey secretKey = getKey("o9szYIOq1rRMiouNhNvaq96lqUvCekxR");// constant o9szYIOq1rRMiouNhNvaq96lqUvCekxR
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(java.util.Base64.getDecoder().decode(ciphertext)));
		}
	   
	
	   
	   public static byte[] getSalt() throws NoSuchAlgorithmException
	{
	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	byte[] salt = new byte[16];
	sr.nextBytes(salt);
	return salt;
	}
	   
	   public static SecretKey getKey(String secretKey) throws Exception {
			byte[] decodeSecretKey = java.util.Base64.getDecoder().decode(secretKey);
			return new SecretKeySpec(decodeSecretKey, 0, decodeSecretKey.length, "AES");
		}
	   
	   
	   /**
	     * Generate a new encryption key.
	     */
	   
	   private static Key generateKey() throws Exception
	   {
		   
		  
		   return new SecretKeySpec(TempAESEncryptionbackup.keyValue, TempAESEncryptionbackup.ALGORITHM);
	   }

}