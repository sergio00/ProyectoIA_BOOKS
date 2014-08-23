package recomendaciones.model;

public class Person {
    private String personality;
    
    //private int age;

    public Person() {

    }
    
    public Person(String personal) {
		personality = personal;
		//this.age = age;
    }
    
    public String getPersonality() {
    	return personality;
    }
    
    public void setPersonality(String personal) {
    	personality = personal;
    }
    /*public int getAge() {
    	return age;
    }*/
}
