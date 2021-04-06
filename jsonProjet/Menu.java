package jsonProjet;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Classe représentant un objet Menu de notre projet
 */
public class Menu {
	/**
	 * Un menu pour demander à l'utilisateur de choisir l'opération qu'il souhaite faire:
	 * Il faut saisir 1 2 3 ou 4 selon l'opération souhaitée.
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Il faut changer le chemin de fichier json
		final String JSONFILE  = "C:\\Users\\china\\git\\javacoursTAL\\src\\jsonProjet\\arbresremarquablesparis.json";
		
		JsonOperations jsonOpe = new JsonOperations();
		JsonOpeBis jsonOpeBis = new JsonOpeBis();
		try {
			ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

			List<Arbre> arbreList = objectMapper.readValue(
			        new File(JSONFILE), 
			        new TypeReference<List<Arbre>>(){});
			
	        Scanner demande = new Scanner(System.in);  
	        demande.useDelimiter(System.lineSeparator());
	        System.out.println("***************Menu***************");
	        System.out.println("Qu'est ce que vous voulez faire?");
	        System.out.println("1 : Afficher un élément spécifique de fichier json");
	        System.out.println("2 : Créer et ajouter un arbre dans le fichier json");
	        System.out.println("3 : Supprimer un arbre dans le fichier json");
	        System.out.println("4 : Modifier un arbre dans le fichier json");
	        
        	int choix = demande.nextInt();  
        	System.out.println("Choix : " + choix);
	        if (choix == 1 ) {
	        	Scanner chercheArbre = new Scanner(System.in);
	        	chercheArbre.useDelimiter(System.lineSeparator());
	        	System.out.println("Input Record ID (String): ");
	        	String recordId = chercheArbre.next();
	        	try {
	        		Arbre result = jsonOpe.afficherUnArbre(recordId, arbreList);
	        		StringWriter stringArbNew = new StringWriter();
					objectMapper.writeValue(stringArbNew, result);
	        	} catch (JsonProjetException e) {
	        		System.out.println("Erreur lors l'affiche d'un item dans le fichier");
	        	}	
	        }
	        
	        else if (choix == 2) {
	        	Map<String,String> donneSaisi = new HashMap<>();
	        	Scanner saisi = new Scanner(System.in);
	        	saisi.useDelimiter(System.lineSeparator());
	        	
	    		System.out.println("Input Record ID (String): ");
	    		String recordId = saisi.next();
	    		donneSaisi.put("recordId", recordId);
	    		System.out.println("Input Record Time Stamp  (String): ");
	    		System.out.println("Exemple de format : 2021-02-26T12:45:18.176+01:00");
	    		String recordTimeStamp = saisi.next();
	    		donneSaisi.put("recordTimeStamp", recordTimeStamp);
	    		System.out.println("Input geo X (float): ");
	    		String testX = saisi.next();
	    		String geomX = verifierTypeFloat(testX);
	    		donneSaisi.put("geomX", geomX);
	    		System.out.println("Input geo Y (float): ");
	    		String testY = saisi.next();
	    		String geomY = verifierTypeFloat(testY);
	    		donneSaisi.put("geomY", geomY);
	    		System.out.println("Input Libelle francais (String): ");
	    		String libelle = saisi.next();
	    		donneSaisi.put("libelle", libelle);
	    		System.out.println("Input Object Id (int): ");
	    		String testObjectId = saisi.next();
	    		String objectId = verifierTypeInt(testObjectId);
	    		donneSaisi.put("objectID", objectId);
	    		System.out.println("Input Id emplacement (String) : ");
	    		String emplacement = saisi.next();
	    		donneSaisi.put("emplacement", emplacement);
	    		System.out.println("Input Arrondissement (String) : ");
	    		String arrondissement = saisi.next();
	    		donneSaisi.put("arrondissement", arrondissement);
	    		System.out.println("Input Circonference en cm (float): ");
	    		String testCirconference = saisi.next();
	    		String circonference = verifierTypeFloat(testCirconference);
	    		donneSaisi.put("circonference", circonference);
	    		System.out.println("Input Hauteur en m (float): ");
	    		String testHauteur = saisi.next();
	    		String hauteur = verifierTypeFloat(testHauteur);
	    		donneSaisi.put("hauteur", hauteur);
	    		System.out.println("Input Espece  (String): ");
	    		String espece = saisi.next();
	    		donneSaisi.put("espece", espece);
	    		System.out.println("Input Adresse  (String): ");
	    		String adresse = saisi.next();
	    		donneSaisi.put("adresse", adresse);
	    		System.out.println("Input Domanialite  (String): ");
	    		String domanialite = saisi.next();
	    		donneSaisi.put("domanialite", domanialite);
	    		System.out.println("Input Pepiniere  (String): ");
	    		String pepiniere = saisi.next();
	    		donneSaisi.put("pepiniere", pepiniere);
	    		System.out.println("Input Stade developpement  (String): ");
	    		String stade = saisi.next();
	    		donneSaisi.put("stade", stade);
	    		System.out.println("Input Remarquable  (String): ");
	    		String remarquable = saisi.next();
	    		donneSaisi.put("remarquable", remarquable);
	    		System.out.println("Input Id base (float): ");
	    		String testBase = saisi.next();
	    		String base = verifierTypeFloat(testBase);
	    		donneSaisi.put("base", base);
	    		System.out.println("Input Genre  (String): ");
	    		String genre = saisi.next();
	    		donneSaisi.put("genre", genre);
	    		System.out.println("Input Variete ou cultivar  (String): ");
	    		String variete = saisi.next();
	    		donneSaisi.put("variete", variete);
	    		System.out.println("Input Complement adresse  (String): ");
	    		String complement = saisi.next();
	    		donneSaisi.put("complement", complement);
	    		System.out.println("Input Date plantation  (String): ");
	    		String date = saisi.next();
	    		donneSaisi.put("date", date);
	    		
	        	Arbre arb1 = jsonOpe.creerArbre(arbreList,donneSaisi);
	        	if (arb1 != null) {
	        		try {
			    		arbreList = jsonOpe.ajouterArbre(arb1, arbreList);
			    		try {
			        		jsonOpe.ecritureJson(arbreList,JSONFILE);
			        	} catch (JsonProjetException e) {
			    			System.out.println("Erreur lors l'écriture du fichier");
			    		}
		        	} catch (JsonProjetException e) {
		    			System.out.println("Erreur lors l'ajout d'un item dans la list");
		    		}
	        	}
	        	else {
	        		System.out.println("*****Aucune modification n'est apportée au fichier*****");
	        	}
	        }
			
	        else if (choix == 3) {
	        	System.out.println("Entrez le RecordID du donnée que vous voulez supprimer : ");
	        	String idSaisi = demande.next();
	    		int avantSize = arbreList.size();
	    		arbreList = jsonOpeBis.supprimerArbre(idSaisi, arbreList);
	    		int apresSize = arbreList.size();
	    		
	    		if (avantSize > apresSize) {
	    			try {
	    				jsonOpe.ecritureJson(arbreList,JSONFILE);
					} catch (JsonProjetException e) {
						System.out.println("Erreur lors l'écriture du fichier");
					}
	    		}
	    		else {
	    			System.out.println("*****Aucune modification n'est apportée au fichier*****");
	    		}
	        }
			
	        else if (choix == 4) {
	        	System.out.println("Entrez le RecordID du donnée que vous voulez modifier : ");
	        	String idSaisi = demande.next();
	    		
	    		try {
	    			Arbre result = jsonOpe.afficherUnArbre(idSaisi, arbreList);
	        		StringWriter stringArbNew = new StringWriter();
					objectMapper.writeValue(stringArbNew, result);
	    			if (result != null) {
						System.out.println("Entrez le nouveau libelle francais : ");
						String newlibelle = demande.next();
						arbreList = jsonOpeBis.modifierArbre(idSaisi, arbreList, newlibelle);
						try {
			    			jsonOpe.ecritureJson(arbreList,JSONFILE);
			    		} catch (JsonProjetException e) {
			    			System.out.println("Erreur lors l'écriture du fichier");
			    		}
	    			}
	    		} catch (JsonProjetException e) {
	    			System.out.println("Erreur lors la modification d'un item dans le fichier");
	    		}
	        }
	        else {
	        	System.out.println("***Erreur de choix.***");
	        	System.out.println("Recommencez s'il vous plaît.");
	        }
		}
		catch (IOException | InputMismatchException e) {
			System.out.println("Erreur lors de l'input de choix: "  + e.getMessage());
			System.out.println("Recommencez s'il vous plaît.");
		}		
	}
	
	/**
     * Vérification le type du élément saisi (Si c'est float ou pas) par Scanner (l'utlisateur) lors de la création d'un Arbre.
     * Lors d'erreur cet méthode rappelle lui-même récursivement jusuqu'à ce qu'il ne trouve plus d'erreur. 
     * @param String sc
     * @return String
     * @exception NumberFormatException
     */
	@SuppressWarnings("resource")
	static String verifierTypeFloat(String sc) {
	    try {
	    	float f =Float.parseFloat(sc);
	        return sc;
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("***Type erreur : Le type d'élément entré n'est pas correct.***");
	    }
		Scanner saisi = new Scanner(System.in);
		System.out.println("Reinput : Entrez une valeur type FLOAT : ");
		String resaisi = saisi.next();
	    return verifierTypeFloat(resaisi);
	}
	
	/**
     * Vérification le type du élément saisi (Si c'est int ou pas) par Scanner (l'utlisateur) lors de la création d'un Arbre.
     * Lors d'erreur cet méthode rappelle lui-même récursivement jusuqu'à ce qu'il ne trouve plus d'erreur. 
     * @param String sc
     * @return String
     * @exception NumberFormatException
     */
	@SuppressWarnings("resource")
	static String verifierTypeInt(String sc) {
	    try {
	    	int i =Integer.parseInt(sc);
	        return sc;
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("***Type erreur : Le type d'élément entré n'est pas correct.***");
	    }
		Scanner saisi = new Scanner(System.in);
		System.out.println("Reinput : Entrez une valeur type INT : ");
		String resaisi = saisi.next();
	    return verifierTypeInt(resaisi);
	}
}