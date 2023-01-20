package tests;

import static org.junit.jupiter.api.Assertions.*;
import config.Constants;
import main.LoadJson;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

class TestJsonFiles {

	@Test
	void testSameFiles() {
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonNoErrorCopy = LoadJson.load(Constants.PATHNOCOPY);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonNoErrorCopy, JSONCompareMode.LENIENT);
			assertTrue(true);
		} catch (JSONException e) {
			assertTrue(false);
		} catch (AssertionError erreurs) {
			assertTrue(false);
		}
	}
	
	@Test
	void testSwapSubObject() {
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonSwapSubObject = LoadJson.load(Constants.PATHSWAPSUB);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSwapSubObject, JSONCompareMode.LENIENT);
			 assertTrue(true);
		} catch (JSONException e) {
			assertTrue(false);
		} catch (AssertionError erreurs) {
			assertTrue(false);
		}
	}
	
	
	@Test
	void testSwapFirstNames() {
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonSwapFirstNames = LoadJson.load(Constants.PATHSWAPFN);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSwapFirstNames, JSONCompareMode.LENIENT);
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);
		}
	}
	
	@Test
	void testSubObjectRemoved() {
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonSubObjectRemoved = LoadJson.load(Constants.PATHSUBRM);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSubObjectRemoved, JSONCompareMode.LENIENT);
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);
		}
	}
	
	@Test
	void testSubObjectRemovedWithError() {
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonSubObjectRemovedWithError = LoadJson.load(Constants.PATHSUBRMONE);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSubObjectRemovedWithError, JSONCompareMode.LENIENT);
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);
		}
	}
	
	@Test
	void testLeftError() {
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonOneError = LoadJson.load(Constants.PATHONE);
		try {
			JSONAssert.assertEquals(jsonOneError, jsonNoError, JSONCompareMode.LENIENT);
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);
		}
	}
	
	@Test
	void testRightError() {	
		String jsonNoError = LoadJson.load(Constants.PATHNO);
		String jsonOneError = LoadJson.load(Constants.PATHONE);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonOneError, JSONCompareMode.LENIENT);
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);
		}
	}
}

