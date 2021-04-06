package jsonProjet;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Classe représentant les tests pour des méthodes
 */
public class JsonTest {
		
	private List<Arbre> testliste ; 
	private JsonOperations jsonOpe ;
	private JsonOpeBis jsonOpeBis ;
	private Arbre arb;
	
	@BeforeEach
	void setUp() throws Exception {
		testliste = new ArrayList<Arbre>();
		jsonOpe = new JsonOperations();
		jsonOpeBis = new JsonOpeBis();
		
		arb = new Arbre();
		arb.setDatasetid();
		arb.setRecordid("test");
		arb.setRecord_timestamp("2021-02-26T12:45:18.176+01:00");
		
		Fields fields = new Fields();
		List<Float> geomXY = new ArrayList<Float>();
		geomXY.add((float) 48.868294);
		geomXY.add((float) 2.3631895);
		fields.setGeomXY(geomXY);
		
		fields.setLibellefrancais("Chêne");
		fields.setObjectid(207977);
		fields.setIdemplacement("000401009");
		fields.setArrondissement("PARIS 10E ARRDT");
		fields.setCirconferenceencm((float)51.0);
		fields.setHauteurenm((float)7.0);
		fields.setEspece("cerris");
		fields.setAdresse("PLACE DE LA REPUBLIQUE");
		fields.setDomanialite("Alignement");
		fields.setPepiniere("Guillot Bourne");
		fields.setStadedeveloppement("J");
		fields.setRemarquable("1");
		fields.setIdbase((float) 2017817.0);
		fields.setGenre("Quercus");
		fields.setVarieteoucultivar(null);
		fields.setComplementadresse(null);
		fields.setTypeemplacement();
		fields.setDateplantation("2017-11-09T02:00:00+01:00");
		arb.setFields(fields);
		
		Geometry geo = new Geometry();
		geo.setType();
		
		List<Float> coordinates = new ArrayList<Float>();		
		
		coordinates.add((float) 2.3631895);
		coordinates.add((float) 48.868294);
		geo.setCoordinates(coordinates);
		arb.setGeometry(geo);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test pour la méthode afficherUnArbre
	 */
	@Test
	void testAfficherUnArbre() {
		//GIVEN
		String recordid = "test";
		try {
			testliste = jsonOpe.ajouterArbre(arb,testliste);
		} catch (JsonProjetException e1) {
			System.out.println("Erreur lors l'ajout d'un item dans le fichier");
		}	
			
		try {
			//WHEN
			Arbre result = jsonOpe.afficherUnArbre(recordid, testliste);
			
			//THEN
			assertNotNull(testliste);
			assertNotNull(recordid);
			assertNotNull(result);
			assertTrue(recordid.equals(result.getRecordid()));
			System.out.println("***** Test afficherUnArbre ----- Succès.\n");
		}
		catch (JsonProjetException e1) {
			System.out.println("Erreur lors l'affiche d'un item dans le fichier");
		}	
	}	
	
	/**
	 * Test pour la méthode creerArbre
	 */
	@Test
	void testCreerArbre() {
		//GIVEN
		Map<String,String> donneTest = new HashMap<>();
		donneTest.put("recordId", "test1");
		donneTest.put("recordTimeStamp", "test1");
		donneTest.put("geomX", "1.0");
		donneTest.put("geomY", "2.0");
		donneTest.put("libelle", "libelle");
		donneTest.put("objectID", "1");
		donneTest.put("emplacement", "emplacement");
		donneTest.put("arrondissement", "arrondissement");
		donneTest.put("circonference", "1.0");
		donneTest.put("hauteur", "2.0");
		donneTest.put("espece", "espece");
		donneTest.put("adresse", "adresse");
		donneTest.put("domanialite", "domanialite");
		donneTest.put("pepiniere", "pepiniere");
		donneTest.put("stade", "stade");
		donneTest.put("remarquable", "remarquable");
		donneTest.put("base", "1.0");
		donneTest.put("genre", "genre");
		donneTest.put("variete", "variete");
		donneTest.put("complement", "complement");
		donneTest.put("date", "date");
		
		//WHEN
		Arbre testarbre = jsonOpe.creerArbre(testliste,donneTest);
		String recordid = testarbre.getRecordid();
		
		//THEN
		assertNotNull(testarbre);
		assertNotNull(recordid);
		assertTrue(recordid.equals("test1"));
		System.out.println("***** Test creerArbre ----- Succès.\n");
	}
	
	/**
	 * Test pour la méthode ajouterArbre 
	 */
	@Test
	void testAjouterArbre(){
		//GIVEN
		int avantSize = testliste.size();
		
		try {
			//WHEN
			testliste = jsonOpe.ajouterArbre(arb,testliste);
			int apresSize = testliste.size();
			
			//THEN
			assertNotNull(arb);
			assertNotNull(apresSize);
			assertEquals(avantSize+1, apresSize);
			System.out.println("***** Test ajouterArbre ----- Succès.\n");
			
		}
		catch (JsonProjetException e) {
			System.out.println("Erreur lors l'ajout d'un item dans le fichier");
		}
	}

	/**
	 * Test pour la méthode supprimerArbre
	 */
	@Test
	void testSupprimerArbre() {
		//GIVEN
		String recordid = "test";
		
		try {
			testliste = jsonOpe.ajouterArbre(arb,testliste);
			
			//WHEN
			int avantSize = testliste.size();
			testliste = jsonOpeBis.supprimerArbre(recordid, testliste);
			int apresSize = testliste.size();
									
			//THEN
			assertFalse(testliste.contains(arb));
			assertNotNull(apresSize);
			assertEquals(avantSize, apresSize+1);
			System.out.println("***** Test supprimerArbre ----- Succès.\n");
		}
		catch (JsonProjetException e) {
			System.out.println("Erreur lors la suppression d'un item dans le fichier");
		}												
	}
	

	/**
	 * Test pour la méthode modifierArbre
	 */
	@Test
	void testModifierArbre() {

		//GIVEN
		String recordid = "test";
		
		try {
			testliste = jsonOpe.ajouterArbre(arb,testliste);
			
			//WHEN
			String avantLibelle = arb.getFields().getLibellefrancais();
			int avantSize = testliste.size();
			testliste = jsonOpeBis.modifierArbre(recordid, testliste,"Savonnier");
			int apresSize = testliste.size();
			String apresLibelle = arb.getFields().getLibellefrancais();
									
			//THEN
			assertNotNull(arb);
			assertNotNull(apresSize);
			assertEquals(avantSize, apresSize);	
			assertFalse(avantLibelle.equals(apresLibelle));
			System.out.println("***** Test modifierArbre ----- Succès.\n");
		}
		catch (JsonProjetException e) {
			System.out.println("Erreur lors la modification d'un item dans le fichier");
		}
	}	
	
	/**
	 * Test pour la méthode ecritureJson
	 */
	@Test
	void testEcritureJson(){
		
		// Il faut changer le chemin de fichier json
		final String JSONFIETEST = "C:\\Users\\china\\git\\javacoursTAL\\src\\jsonProjet\\arbreTest.json";
		
		try {
			testliste = jsonOpe.ajouterArbre(arb,testliste);
			
			//WHEN
			boolean result = jsonOpe.ecritureJson(testliste,JSONFIETEST);
									
			//THEN
			assertTrue(result);	
			System.out.println("***** Test ecritureJson ----- Succès.\n");
		}
		catch (JsonProjetException e) {
			System.out.println("Erreur lors de l'écriture du fichier");
		}
	}	
}