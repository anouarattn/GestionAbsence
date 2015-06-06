package test;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
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
		   EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "application-ear.ear")

                   .addAsDirectory("C:/Users/anouarattn/Documents/jbossGA/standalone/deployments/projetEar.ear")
                   .as(EnterpriseArchive.class);
		   
		   JavaArchive testLibraryHelper = ShrinkWrap.create(JavaArchive.class)
                   .addClass(ITtest.class);
		   	ear.addAsLibrary(testLibraryHelper)
		   	.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");;
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
