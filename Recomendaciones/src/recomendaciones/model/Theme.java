package recomendaciones.model;

public class Theme {
	private final String nombre;
    
    public Theme(String anombre) {
    	this.nombre = anombre;
    }

    public String getNombre() {
    	return nombre;
    }
    
    public String toString() {
    	return nombre;
    }
}
