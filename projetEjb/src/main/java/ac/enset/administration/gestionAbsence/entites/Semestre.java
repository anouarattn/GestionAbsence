package ac.enset.administration.gestionAbsence.entites;

public enum Semestre {
    SEMESTRE1("Premier Semestre"),SEMESTRE2("Deuxième Semestre");
    
    
    private String semestre;

    private Semestre(String semestre)
    {
	this.semestre = semestre;
    }
    
    public String getSemestre()
    {
	return semestre;
    }
}
