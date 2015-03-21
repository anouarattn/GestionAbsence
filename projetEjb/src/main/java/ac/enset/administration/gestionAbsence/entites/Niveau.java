package ac.enset.administration.gestionAbsence.entites;

public enum Niveau {
    PremiereAnnee("Premiere Année"),DeuxiemeAnnee("Deuxieme Année"),TroisiemeAnnee("Troisieme Année"),
    QuatrièmeAnnee("Troisieme Année"),CinquièmeAnnee("Cinquième Année"),NonDefini("Non Défini");
   
    private final String niveau;
    private Niveau(String niveau)
    {
	this.niveau=niveau;
    }

}
