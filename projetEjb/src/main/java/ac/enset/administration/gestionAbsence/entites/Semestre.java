package ac.enset.administration.gestionAbsence.entites;

public enum Semestre {
    SEMESTRE1("Premier Semestre"),SEMESTRE2("Deuxième Semestre"),SEMESTRE3("Troisième Semestre"),SEMESTRE4("Quatrième Semestre"),SEMESTRE5("Cinquième Semestre")
    ,SEMESTRE6("Sixieme Semestre");
    
    
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
