import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void testVigenereEncryption() {
		String plain = "Hello World";
		String key = "Hello";
		String encrypted = CryptoManager.vigenereEncryption(plain,key);
		String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
		System.out.println(encrypted + " " + decrypted);
		assertEquals(encrypted,decrypted);
	}

	@Test
	void testVigenereDecryption() {
		String plain = "STICKYNOTE";
		String key = "Secure";
		String encrypted = CryptoManager.vigenereEncryption(plain, key);
		String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
		System.out.println(encrypted + " " + decrypted);
		assertEquals(encrypted,decrypted);
	}

	@Test
	void testPlayfairEncryption() {
		String plain = "ROCKSTONE";
		String key = "And";
		String encrypted = CryptoManager.playfairEncryption(plain, key);
		String decrypted = CryptoManager.playfairDecryption(encrypted, key);
		System.out.println(encrypted + " " + decrypted);
		assertEquals(encrypted,decrypted);
	}

	@Test
	void testPlayfairDecryption() {
		String plain = "GAMINGNEW$3";
		String key = "Ghost";
		String encrypted = CryptoManager.playfairEncryption(plain, key);
		String decrypted = CryptoManager.playfairDecryption(encrypted, key);
		System.out.println(encrypted + " " + decrypted);
		assertEquals(encrypted,decrypted);
	}

}
