package config;

/**
* Constants est la classe qui g�re les diff�rentes constantes fixes du projet, comme les 2 fichiers principaux
* � comparer, les fichiers n�cessaires pour les tests unitaires, etc..
*
* @version 1.0
* @category Structure
* @since JDK version (1.8)
*/

public class Constants {
	
	// Les 2 fichiers � comparer, les paths renvoient aux fichiers dans src/main/resources/Files
	public static final String PATHNEW = "/Files/exempleFull.json";
	public static final String PATHREF = "/Files/exempleFull2.json";

	// Les fichiers � utiliser dans les tests unitaires, pr�sents dans src/main/resources/Tests
	public static final String PATHNO = "/Tests/NoErrorsForTest.json";
	public static final String PATHNOCOPY = "/Tests/NoErrorsForTestCopy.json";
	public static final String PATHONE = "/Tests/OneErrorForTest.json";
	public static final String PATHSUBRM = "/Tests/SubObjectRemovedForTest.json";
	public static final String PATHSUBRMONE = "/Tests/SubObjectRemovedWithErrorForTest.json";
	public static final String PATHSWAPFN = "/Tests/SwapFirstNamesForTest.json";
	public static final String PATHSWAPSUB = "/Tests/SwapSubObjectInSameObjectForTest.json";
	
	// Des fichiers exclusivement pour CSV pour faire d'autres tests
	public static final String PATHNEW_CSV = "/Files/CSV_file1.csv";
	public static final String PATHREF_CSV = "/Files/CSV_file2.csv";
}
