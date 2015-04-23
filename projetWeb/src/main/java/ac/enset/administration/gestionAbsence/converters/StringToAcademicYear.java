package ac.enset.administration.gestionAbsence.converters;

import org.joda.time.LocalDate;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;

public class StringToAcademicYear {
    
    public static AnneeScolaire convert(String value) {
	String[] years = value.split("/");
	if (years.length != 2)
	    return null;
	int beginYear = Integer.parseInt(years[0]);
	int endYear = Integer.parseInt(years[1]);
	if (endYear - beginYear != 1)
	    return null;
	AnneeScolaire anneeScolaire = new AnneeScolaire();
	anneeScolaire.setBeginYear(new LocalDate(beginYear, 1, 1));
	anneeScolaire.setEndYear(new LocalDate(endYear, 1, 1));
	return anneeScolaire;
    }

}
