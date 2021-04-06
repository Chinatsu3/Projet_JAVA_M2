package jsonProjet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe représentant un objet Fields
 */
@JsonPropertyOrder({"geom_x_y", "libellefrancais", "objectid", "idemplacement", "arrondissement", "circonferenceencm", 
	"hauteurenm", "espece", "adresse", "domanialite", "pepiniere", "stadedeveloppement", "remarquable", "idbase", "genre",
	"varieteoucultivar", "complementadresse", "typeemplacement", "dateplantation"})
public class Fields {
	@JsonProperty("geom_x_y")
	private List<Float> geomXY;
	private String libellefrancais;
	private int objectid;
	private String idemplacement;
	private String arrondissement;
	private float circonferenceencm;
	private float hauteurenm;
	private String espece;
	private String adresse;
	private String domanialite;
	private String pepiniere;
	private String stadedeveloppement;
	private String remarquable;
	private float idbase;
	private String genre;
	private String varieteoucultivar;
	private String complementadresse;
	final String typeemplacement = "Arbre";
	private String dateplantation;
	
	public Fields() {}
	
	public List<Float> getGeomXY() {
		return geomXY;
	}
	public void setGeomXY(List<Float> geomXY) {
		this.geomXY = geomXY;
	}
	public String getLibellefrancais() {
		return libellefrancais;
	}
	public void setLibellefrancais(String libellefrancais) {
		this.libellefrancais = libellefrancais;
	}
	public int getObjectid() {
		return objectid;
	}
	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}
	public String getIdemplacement() {
		return idemplacement;
	}
	public void setIdemplacement(String idemplacement) {
		this.idemplacement = idemplacement;
	}
	public String getArrondissement() {
		return arrondissement;
	}
	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}
	public double getCirconferenceencm() {
		return circonferenceencm;
	}
	public void setCirconferenceencm(float d) {
		this.circonferenceencm = d;
	}
	public double getHauteurenm() {
		return hauteurenm;
	}
	public void setHauteurenm(float d) {
		this.hauteurenm = d;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDomanialite() {
		return domanialite;
	}
	public void setDomanialite(String domanialite) {
		this.domanialite = domanialite;
	}
	public String getPepiniere() {
		return pepiniere;
	}
	public void setPepiniere(String pepiniere) {
		this.pepiniere = pepiniere;
	}
	public String getStadedeveloppement() {
		return stadedeveloppement;
	}
	public void setStadedeveloppement(String stadedeveloppement) {
		this.stadedeveloppement = stadedeveloppement;
	}
	public String getRemarquable() {
		return remarquable;
	}
	public void setRemarquable(String remarquable) {
		this.remarquable = remarquable;
	}
	public double getIdbase() {
		return idbase;
	}
	public void setIdbase(float d) {
		this.idbase = d;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getComplementadresse() {
		return complementadresse;
	}
	public void setComplementadresse(String complementadresse) {
		this.complementadresse = complementadresse;
	}
	public String getTypeemplacement() {
		return typeemplacement;
	}
	
	public String setTypeemplacement() {
		return this.typeemplacement;
	}

	public String getDateplantation() {
		return dateplantation;
	}
	public void setDateplantation(String dateplantation) {
		this.dateplantation = dateplantation;
	}

	public String getVarieteoucultivar() {
		return varieteoucultivar;
	}
	public void setVarieteoucultivar(String varieteoucultivar) {
		this.varieteoucultivar = varieteoucultivar;
	}
	
	@Override
	public String toString(){
		
		return getGeomXY() + ", "+getLibellefrancais()+", "+getObjectid()+", "+
				getIdemplacement() + ", "+ getArrondissement() + ", "+ getCirconferenceencm()+", "+
				getHauteurenm() + ", "+ getEspece() + ", "+ getAdresse()+ ", "+ getDomanialite()+", "+
				getPepiniere() + ", "+ getStadedeveloppement() + ", "+ getRemarquable()+ ", "+  getIdbase()+", "+
				getGenre() + ", "+ getVarieteoucultivar() + ", "+  getComplementadresse() + ", "+ getTypeemplacement()+ ", "+  getDateplantation();
	}	
}

