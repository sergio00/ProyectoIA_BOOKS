package recomendaciones.model;

public class FoundPersonality {
	private String typeEI, typeSN, typeTF, typeJP;
	
	public FoundPersonality(String ei, String sn, String tf, String jp){
		typeEI = ei;
		typeSN = sn;
		typeTF = tf;
		typeJP = jp;
	}
	
	public String getTypeEI(){
		return typeEI;
	}
	
	public String getTypeSN(){
		return typeSN;
	}
	
	public String getTypeTF(){
		return typeTF;
	}
	
	public String getTypeJP(){
		return typeJP;
	}
}
