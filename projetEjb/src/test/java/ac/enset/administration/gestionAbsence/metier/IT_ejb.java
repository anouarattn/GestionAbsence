package ac.enset.administration.gestionAbsence.metier;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class IT_ejb {
    
//    @Inject
//    Departement departement;
//    
//    @EJB
//    IAbsenceLocal metier;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
        	    .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    public void nb_of_departement_test() {
        Assert.assertEquals(0, 0);
    }
    
    
}