package test;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;
import ac.enset.administration.gestionAbsence.models.ModelBeanDepartement;


@RunWith(Arquillian.class)
public class ITtest {

	public final static String DATATABLE_TBODY_ID = "formDataTable:datatable_data";


	private static final String CURRENT_ARTEFACT_ID = "GestionAbSsence";


	private static final String MODULE_NAME = "projetEar.ear";


	
	
	@Inject
	private ModelBeanDepartement  modelDepartement;
	
	@Inject
	private IAbsenceLocal metier;
	
	 @Deployment
	    public static EnterpriseArchive createDeployment() {
		 System.out.println(new File(".").getAbsolutePath());
		 WebArchive war = ShrinkWrap.create(ZipImporter.class, "projetWeb.war").
				 importFrom(new File("./target/projetWeb.war"))
         .as(WebArchive.class).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addClass(ITtest.class);
		 
		 JavaArchive jar = ShrinkWrap.create(ZipImporter.class, "projetEjb.jar").
				 importFrom(new File("./../projetEjb/target/projetEjb.jar")).as(JavaArchive.class)
				 		.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
		 
		 
		 EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "projetEar.ear")
				 .addAsModule(war).addAsModule(jar);
		 return ear;
		 
	    }
	 
	 
	@Before
	public void init()
	{
		
		metier.removeAll(Departement.class);
		modelDepartement.update();
	}
	
    @Test
    public void departement_add_modify_show() {

    HtmlUnitDriver driver = new HtmlUnitDriver();
	driver.get("http://localhost:8080/projetWeb/departement.xhtml");
	
	WebElement tableDataElement = driver.findElementById(DATATABLE_TBODY_ID);
	
	// test that only one element exist in the datatable. the empty message row.
	Assert.assertEquals( 1,tableDataElement.findElements(By.xpath("./tr")).size());
	// assure only empty message exist
	Assert.assertEquals(tableDataElement.findElements(By.xpath("./tr")).get(0).getAttribute("class"), "ui-widget-content ui-datatable-empty-message");
	
	// test adding element
	
	
	driver.quit();

    }

}
