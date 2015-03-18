package ac.enset.administration.gestionAbsence.metier;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import org.junit.*;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;

@RunWith(Arquillian.class)
public class IT_ejb {
    
    @Inject
    Departement departement;
    
    @EJB
    IAbsenceLocal metier;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
            .addClasses(EntityBase.class, Departement.class,IAbsenceLocal.class 
        	    ,IAbsenceImpl.class,Classe.class,AnneeScolaire.class,Filiere.class,TypeFiliere.class)
        	    .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    public void nb_of_departement_test() {
        Assert.assertEquals(0, metier.getDepartements().size());
    }
    
    
}