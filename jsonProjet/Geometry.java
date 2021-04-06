package jsonProjet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe représentant un objet Geometry
 */
@JsonPropertyOrder({"type", "coordinates"})
public class Geometry {
	final String type = "Point";
	private List<Float> coordinates;
	
	public String getType() {
		return type;
	}
	
	public String setType() {
		return this.type;
	}

	public List<Float> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Float> coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public String toString(){
		return getType() + ", "+getCoordinates();
	}
}

