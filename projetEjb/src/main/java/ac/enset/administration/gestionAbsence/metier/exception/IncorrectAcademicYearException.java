package ac.enset.administration.gestionAbsence.metier.exception;

import javax.ejb.ApplicationException;

@SuppressWarnings("serial")
@ApplicationException(rollback=true)
public class IncorrectAcademicYearException extends Exception {

    public IncorrectAcademicYearException(String arg0) {
	super(arg0);
    }
    
    

}
