package jsonProjet;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Classe représentant les opérations que l'on peut faire avec les données json (partie 1)
 */
public class JsonOperations {
	
	public JsonOperations() {}
	
    /**
     * Écrit le contenu de la liste dans le fichier json
     * @param List<Arbre> arbreList, String jsonFile
     * @return boolean
     * @exception JsonGenerationException, JsonMappingException, IOException
     * @throws JsonProjetException 
     */
	public boolean ecritureJson(List<Arbre> arbreList, String jsonFile)throws JsonProjetException {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		boolean flag = false;
		try {
			objectMapper.writeValue(new File(jsonFile), arbreList);
			System.out.println("Le fichier a été bien modifié.");
			flag = true;
		} catch (JsonGenerationException e) {
			throw new JsonProjetException("Erreur d'écriture : JsonGenerationException" + e.getMessage());
		} catch (JsonMappingException e) {
			throw new JsonProjetException("Erreur d'écriture ou de lecture : JsonMappingException" + e.getMessage());
		} catch (IOException e) {
			throw new JsonProjetException("Impossible d'écrire ou de lire." + e.getMessage());
		}
		if (flag == false) {
            System.out.println("*****Aucune modification n'est apportée au fichier*****");
        }
		return flag;
	}
	
    /**
     * Afficher un arbre spécifique de la liste. Le recordid est utilisé comme clé de recherche.
     * @param String recordid, List<Arbre> arbreList
     * @return Arbre
     * Renvoie null si le recordid n'existe pas dans la liste
     * @exception JsonGenerationException, JsonMappingException, IOException
     * @throws JsonProjetException 
     */
	public Arbre afficherUnArbre(String recordid, List<Arbre> arbreList) throws JsonProjetException {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		boolean flag = false;
				
		for (Arbre arbre : arbreList) {
			if (arbre.getRecordid().equals(recordid)) {
				StringWriter stringArb = new StringWriter();
				try {
					objectMapper.writeValue(stringArb, arbre);
					System.out.println("L'élément json que vous avez cherché : \n"+stringArb);
					flag = true;
					return arbre;
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
            System.out.println("*****Aucun arbre avec ce recordId dans le fichier*****");
        }
		return null;
	}
	
	/**
     * Création d'un objet Arbre
     * @param List<Arbre> arbreList, , Map<String, String> donneSaisi
     * @return Arbre
     * Renvoie null si le recordid existe déjà  dans la liste
     */
	public Arbre creerArbre(List<Arbre> arbreList, Map<String, String> donneSaisi) {

		Arbre arb = new Arbre();
		arb.setDatasetid();
		
		for (Arbre arbre : arbreList) {
			String recordId = arbre.getRecordid();
			if (recordId.equals(donneSaisi.get("recordId"))) {
				System.out.println("Le recordid existe déjà  dans la liste.");
				return null;
			}
		}
		arb.setRecordid(donneSaisi.get("recordId"));
		arb.setRecord_timestamp(donneSaisi.get("recordTimeStamp"));
		
		Fields fields = new Fields();
		List<Float> geomXY = new ArrayList<Float>();
		float geomXFloat=Float.parseFloat(donneSaisi.get("geomX"));
		geomXY.add(geomXFloat);
		float geomYFloat=Float.parseFloat(donneSaisi.get("geomY"));
		geomXY.add(geomYFloat);
		fields.setGeomXY(geomXY);
		fields.setLibellefrancais(donneSaisi.get("libelle"));
		int objectID=Integer.parseInt(donneSaisi.get("objectID"));  
		fields.setObjectid(objectID);
		fields.setIdemplacement(donneSaisi.get("emplacement"));
		fields.setArrondissement(donneSaisi.get("arrondissement"));
		float circonference=Float.parseFloat(donneSaisi.get("circonference"));
		fields.setCirconferenceencm(circonference);
		float hauteur=Float.parseFloat(donneSaisi.get("hauteur"));
		fields.setHauteurenm(hauteur);
		fields.setEspece(donneSaisi.get("espece"));
		fields.setAdresse(donneSaisi.get("adresse"));
		fields.setDomanialite(donneSaisi.get("domanialite"));
		fields.setPepiniere(donneSaisi.get("pepiniere"));
		fields.setStadedeveloppement(donneSaisi.get("stade"));
		fields.setRemarquable(donneSaisi.get("remarquable"));
		float base=Float.parseFloat(donneSaisi.get("base"));
		fields.setIdbase(base);
		fields.setGenre(donneSaisi.get("genre"));
		fields.setVarieteoucultivar(donneSaisi.get("variete"));
		fields.setComplementadresse(donneSaisi.get("complement"));
		fields.setTypeemplacement();
		fields.setDateplantation(donneSaisi.get("date"));
		arb.setFields(fields);
		
		Geometry geo = new Geometry();
		geo.setType();
		List<Float> coordinates = new ArrayList<Float>();		
		coordinates.add(geomYFloat);
		coordinates.add(geomXFloat);
		geo.setCoordinates(coordinates);
		arb.setGeometry(geo);
		
		System.out.println("L'arbe a été bien crée.");
		return arb;
	}
	
	/**
     * Ajouter un objet Arbre dans la liste
     * @param Arbre arbre, List<Arbre> arbreList
     * @return List<Arbre>
	 * @exception JsonGenerationException, JsonMappingException, IOException
	 * @throws JsonProjetException 
     */
	public List<Arbre> ajouterArbre(Arbre arbre, List<Arbre> arbreList) throws JsonProjetException {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		
		if (arbre != null ) {
			for (Arbre arb : arbreList) {
				String recordId = arb.getRecordid();
				if (recordId.equals(arbre.getRecordid())) {
					System.out.println("Le recordid existe déjà  dans la liste.");
					return arbreList;
				}
			}
			arbreList.add(arbre);		
			try {
				StringWriter stringArbNew = new StringWriter();
				objectMapper.writeValue(stringArbNew, arbre);
				System.out.println("Cet item est ajouté dans le fichier : \n"+stringArbNew);
			} catch (JsonGenerationException e) {
				throw new JsonProjetException("Erreur d'écriture : JsonGenerationException" + e.getMessage());
			} catch (JsonMappingException e) {
				throw new JsonProjetException("Erreur d'écriture ou de lecture : JsonMappingException" + e.getMessage());
			} catch (IOException e) {
				throw new JsonProjetException("Impossible d'écrire ou de lire." + e.getMessage());
			}
		}
		return arbreList;
	}
}