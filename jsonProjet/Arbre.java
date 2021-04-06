package jsonProjet;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe représentant un objet Arbre
 */
@JsonPropertyOrder({"datasetid", "recordid", "fields", "record_timestamp", "geometry"})
public class Arbre {
	final String datasetid = "arbresremarquablesparis";
	private String recordid;
	private String record_timestamp;
	private Fields fields;
	private Geometry geometry;
	

	public Arbre() {
	}
	
	public Arbre(String recordid) {
		this.recordid = recordid;
	}

	public String getDatasetid() {
		return datasetid;
	}
	
	public String setDatasetid() {
		return this.datasetid;
	}

	public String getRecordid() {
		return recordid;
	}
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
	public Fields getFields() {
		return fields;
	}
	public void setFields(Fields fields) {
		this.fields = fields;
	}
	public String getRecord_timestamp() {
		return record_timestamp;
	}
	public void setRecord_timestamp(String record_timestamp) {
		this.record_timestamp = record_timestamp;
	}
	
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** Arbre Détails *****\n");
		sb.append("Dataset ID="+getDatasetid()+"\n");
		sb.append("Record ID="+getRecordid()+"\n");
		sb.append("Fields="+getFields()+"\n");
		sb.append("Geometry="+getGeometry()+"\n");
		sb.append("Time Stamp="+getRecord_timestamp()+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
}