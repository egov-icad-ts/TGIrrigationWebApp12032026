package in.ts.icad.leagal.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;





//import org.apache.commons.codec.binary.Base64;



public class AESEncryption  {
	

	private static final String ALGORITHM = "AES";
	
	 private static final String SECRET_KEY ="o9szYIOq1rRMiouNhNvaq9";
			 
			 //"o9szYIOq1rRMiouNhNvaq96lqUvCekxR";
			 //
			 
			 
			 
			 //"o9szYIOq1rRMiouNhNvaq9"; 
	 private static final byte[] keyValue =
	            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
	 
	 private static final byte[] keyValueNew =
	            new byte[]{'o', '9', 's', 'z', 'Y', 'I', 'O', 'q', '1', 'r', 'R', 'M', 'i', 'o', 'u', 'N'};
	 
	 
	 /**
	     * Encrypt a string with AES algorithm.
	     *
	     * @param data is a string
	     * @return the encrypted string
	     * 
	     * 
	     */
	   public static String encrypt(String value) throws Exception
	   {
	       
		   Key key = generateKey();
	       Cipher cipher = Cipher.getInstance(AESEncryption.ALGORITHM);
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
	       Cipher cipher = Cipher.getInstance(AESEncryption.ALGORITHM);
	       cipher.init(Cipher.DECRYPT_MODE, key);
	       byte [] decryptedValue64 = Base64.decodeBase64(value);
	       byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
	       String decryptedValue = new String(decryptedByteValue,"utf-8");
	       return decryptedValue;
	               
	   }
	   /**
	     * Generate Salt.
	     */
	   public static String decryptInputText(String ciphertext) throws Exception {
		   
		//   String base64Key = "o9szYIOq1rRMiouNhNvaq96lqUvCekxR";
		 //  byte[] keyBytes = 
		   
		   byte[] keyValue = Base64.decodeBase64(SECRET_KEY);
				   
				   //SECRET_KEY.getBytes();
		   
		  // System.out.println(keyValue+"keyValue");
		 //  SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
		   
		   SecretKeySpec secretKeySpec = new SecretKeySpec(keyValue, ALGORITHM);
		   Cipher cipher = Cipher.getInstance(ALGORITHM);
		   //System.out.println("Key Bytes: " + bytesToHex(keyBytes));
		 //  System.out.println("ciphertext "+ciphertext);
		//	SecretKey secretKey = getKey("o9szYIOq1rRMiouNhNvaq96lqUvCekxR");// constant o9szYIOq1rRMiouNhNvaq96lqUvCekxR
		//	Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			
			//System.out.println("secretKey"+secretKey);
			//System.out.println("Cipher.DECRYPT_MODE"+Cipher.DECRYPT_MODE);
			
			 byte[] decryptedValue = Base64.decodeBase64(ciphertext);
			 byte[] decryptedBytes = cipher.doFinal(decryptedValue);
			 
			// String(cipher.doFinal(java.util.Base64.getDecoder().decode(ciphertext)))
			return new String(decryptedBytes);
		}
	
	   
	   private static String bytesToHex(byte[] bytes) {
	        StringBuilder hexStringBuilder = new StringBuilder(2 * bytes.length);
	        for (byte b : bytes) {
	            hexStringBuilder.append(String.format("%02x", b & 0xFF));
	        }
	        return hexStringBuilder.toString();
	    }
	   public static byte[] getSalt() throws NoSuchAlgorithmException
		{
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
		}
	   
	   
	   /**
	     * Generate a new encryption key.
	     */
	   
	   public static SecretKey getKey(String secretKey) throws Exception {
			byte[] decodeSecretKey = java.util.Base64.getDecoder().decode(secretKey);
			
		//	System.out.println("secretKey"+secretKey);
			return new SecretKeySpec(decodeSecretKey, 0, decodeSecretKey.length, "AES");
		}
	   
	   private static Key generateKey() throws Exception
	   {
		   
		  
		   return new SecretKeySpec(AESEncryption.keyValue, AESEncryption.ALGORITHM);
	   }

}