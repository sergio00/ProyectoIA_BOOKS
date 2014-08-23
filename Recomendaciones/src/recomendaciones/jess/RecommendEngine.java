package recomendaciones.jess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import recomendaciones.base.Conexion;
import recomendaciones.model.*;

//import com.mysql.jdbc.Connection;

import jess.*;


public class RecommendEngine {
	private Rete engine;
    private WorkingMemoryMarker marker;
    private Conexion database;
    Person person = new Person ();
    
	public RecommendEngine () throws JessException {
		// Create a Jess rule engine
        engine = new Rete();
        engine.reset();
        
        //Load the pricing rules
        engine.batch("rules.clp");
        
	} 
	
	private void loadData(String pers) throws JessException {
       // Add the person and its contents to working memory
		person.setPersonality(pers);
		engine.add(person);
    }
	
	public Iterator run(String personality) throws JessException {
        // Load data for this person
        loadData(personality);

        // Fire the rules that apply to this order
        engine.run();

        // Return the list of offers created by the rules
        return engine.getObjects(new Filter.ByClass(Theme.class));
    }
	
}
