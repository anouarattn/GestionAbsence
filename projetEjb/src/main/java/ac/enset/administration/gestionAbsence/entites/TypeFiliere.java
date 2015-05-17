package ac.enset.administration.gestionAbsence.entites;

public enum TypeFiliere {
    MASTER("Master",2),INGENIEUR("Cycle d'ingénieur",3),DUT("Diplôme universitaire de technologie",2),
    BTS("Brevet de technicien supérieur",2),LICENCEP("Licence Professionnelle",1),LICENCE("Licence",3);
    private int numberOfYears;
    private String name;
    private TypeFiliere(String name , int numberOfYears)
    {
	this.numberOfYears = numberOfYears;
	this.name = name;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    public String getName() {
        return name;
    }
}
