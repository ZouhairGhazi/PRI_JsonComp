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
	void testSameFiles() { // Test pour vérifier que 2 fichiers JSON identiques sont reconnus comme tels
		String jsonNoError = LoadJson.load(Constants.PATHNO); // On charge les 2 fichiers en récupérant leur contenu
		String jsonNoErrorCopy = LoadJson.load(Constants.PATHNOCOPY);
		try {
			JSONAssert.assertEquals(jsonNoError, jsonNoErrorCopy, JSONCompareMode.LENIENT); // On compare les 2 fichiers
			assertTrue(true); // Valide le test si aucune erreur n'est identifiée
		} catch (JSONException e) {
			assertTrue(false);
		} catch (AssertionError erreurs) {
			assertTrue(false);
		}
	}
	
	@Test
	void testSwapSubObject() { // Test pour vérifier que même en échangeant 2 sous-objets de place (ordre non-strict) on ne détecte pas d'erreurs
		String jsonNoError = LoadJson.load(Constants.PATHNO);// On charge le fichier de référence
		String jsonSwapSubObject = LoadJson.load(Constants.PATHSWAPSUB); // On charge le fichier avec les sous-objets échangés
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSwapSubObject, JSONCompareMode.LENIENT);// On compare les 2 fichiers
			 assertTrue(true); // Valide le test si aucune erreur n'est identifiée
		} catch (JSONException e) {
			assertTrue(false);
		} catch (AssertionError erreurs) {
			assertTrue(false);
		}
	}
	
	
	@Test
	void testSwapFirstNames() { // Test pour vérifier qu'en échangeant la valeur de 2 prénoms on détecte bien une erreur
		String jsonNoError = LoadJson.load(Constants.PATHNO);// On charge le fichier de référence
		String jsonSwapFirstNames = LoadJson.load(Constants.PATHSWAPFN); // On charge le fichier avec les prénoms échangés
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSwapFirstNames, JSONCompareMode.LENIENT);// On compare les 2 fichiers
			assertTrue(false); 
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true); // Valide le test seulement si on détecte une anomalie dans la comparaison
		}
	}
	
	@Test
	void testSubObjectRemoved() { // Test pour vérifier qu'en supprimant un sous-objet on détecte bien une erreur
		String jsonNoError = LoadJson.load(Constants.PATHNO);// On charge le fichier de référence
		String jsonSubObjectRemoved = LoadJson.load(Constants.PATHSUBRM); // On charge le fichier avec le sous-objet supprimé
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSubObjectRemoved, JSONCompareMode.LENIENT);// On compare les 2 fichiers
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);// Valide le test seulement si on détecte une anomalie dans la comparaison
		}
	}
	
	@Test
	void testSubObjectRemovedWithError() { // Test pour vérifier qu'en supprimant un sous-objet et en implantant une erreur on le détecte bien
		String jsonNoError = LoadJson.load(Constants.PATHNO);// On charge le fichier de référence
		String jsonSubObjectRemovedWithError = LoadJson.load(Constants.PATHSUBRMONE);// On charge le fichier avec le sous-objet supprimé et une erreur
		try {
			JSONAssert.assertEquals(jsonNoError, jsonSubObjectRemovedWithError, JSONCompareMode.LENIENT);// On compare les 2 fichiers
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);// Valide le test seulement si on détecte une anomalie dans la comparaison
		}
	}
	
	@Test
	void testLeftError() {// Test pour vérifier qu'en implémentant une erreur dans un fichier et en le faisant passé en tant que référence, on le détecte bien
		String jsonNoError = LoadJson.load(Constants.PATHNO);// On charge le fichier de référence
		String jsonOneError = LoadJson.load(Constants.PATHONE);// On charge le fichier de référence avec une erreur
		try {
			JSONAssert.assertEquals(jsonOneError, jsonNoError, JSONCompareMode.LENIENT);// On compare les 2 fichiers (en mettant le fichier avec une erreur "à gauche" en tant que référence)
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);// Valide le test seulement si on détecte une anomalie dans la comparaison
		}
	}
	
	@Test
	void testRightError() {	// Test pour vérifier qu'en implémentant une erreur dans un fichier et en le faisant passé en tant que fichier à comparer, on le détecte bien
		String jsonNoError = LoadJson.load(Constants.PATHNO);// On charge le fichier de référence
		String jsonOneError = LoadJson.load(Constants.PATHONE);// On charge le fichier de référence avec une erreur
		try {
			JSONAssert.assertEquals(jsonNoError, jsonOneError, JSONCompareMode.LENIENT);// On compare les 2 fichiers (en mettant le fichier avec une erreur "à droite" en tant que fichier à comparer)
			assertTrue(false);
		} catch (JSONException e) {
			assertTrue(false);
			
		} catch (AssertionError erreurs) {
			assertTrue(true);// Valide le test seulement si on détecte une anomalie dans la comparaison
		}
	}
}

