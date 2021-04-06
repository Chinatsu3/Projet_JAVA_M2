package jsonProjet;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe représentant un objet Arbre avec une information allérgie supplémentaire
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArbreAllergie extends Arbre{
	
	private String allergie; 
	
	public ArbreAllergie(String recordid, String allergie) {
		super(recordid);
		this.allergie = allergie;
	}
	
	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** Arbre Détails *****\n");
		sb.append("Record ID="+getRecordid()+"\n");
		sb.append("allergie="+getAllergie()+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
}
