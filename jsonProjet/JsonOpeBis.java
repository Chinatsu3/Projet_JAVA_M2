package jsonProjet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Classe représentant les opérations que l'on peut faire avec les données json (partie 2)
 */
public class JsonOpeBis extends JsonOperations {
	
	public JsonOpeBis() {
		super();
	}
	
	/**
     * Suppression d'un élément de la liste
     * @param String recordid, List<Arbre> arbreList
     * @return List<Arbre>
     */
	public List<Arbre> supprimerArbre(String recordid, List<Arbre> arbreList) {
		boolean flag = false;
		for (Iterator<Arbre> iterator = arbreList.iterator(); iterator.hasNext(); ) {
		    Arbre arb1 = iterator.next();
		    if (arb1.getRecordid().equals(recordid)) {
		        iterator.remove();
		        System.out.println("L'élément json a été supprimé : " + recordid);
		        flag = true;
		    }
		}
		if (flag == false) {
			System.out.println("Aucun élément avec cet recordid.");
		}
		return arbreList;
	}
	
	/**
     * Modification d'un élément de la liste
     * @param String recordid, List<Arbre> arbreList, String newLibelle
     * @return List<Arbre>
     * @exception JsonGenerationException, JsonMappingException, IOException
     * @throws JsonProjetException 
     */
	public List<Arbre> modifierArbre(String recordid, List<Arbre> arbreList, String newLibelle) throws JsonProjetException {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		boolean flag = false;
		
		for (Iterator<Arbre> iterator = arbreList.iterator(); iterator.hasNext(); ) {
		    Arbre arb1 = iterator.next();
		    if (arb1.getRecordid().equals(recordid)) {
		    	Fields modif = arb1.getFields();
		    	modif.setLibellefrancais(newLibelle);
		    	arb1.setFields(modif);
		    	System.out.println("L'élément a été modifié : " + recordid);
		    	flag = true;
		    	try {
					StringWriter stringArb = new StringWriter();
					objectMapper.writeValue(stringArb, arb1);
					System.out.println("Après modification : \n"+stringArb);
		    	} catch (JsonGenerationException e) {
					throw new JsonProjetException("Erreur d'écriture : JsonGenerationException" + e.getMessage());
				} catch (JsonMappingException e) {
					throw new JsonProjetException("Erreur d'écriture ou de lecture : JsonMappingException" + e.getMessage());
				} catch (IOException e) {
					throw new JsonProjetException("Impossible d'écrire ou de lire." + e.getMessage());
				}
		    }
		}
		if (flag == false) {
			System.out.println("Aucun élément avec cet recordid.");
		}
		return arbreList;
	}	
}