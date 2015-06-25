package ac.enset.administration.gestionAbsence;

import java.util.List;

import javax.annotation.PostConstruct;



import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import ac.enset.administration.gestionAbsence.entites.AbsenceEtud;
import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.Etudiant;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;
import ac.enset.administration.gestionAbsence.models.ModelBeanAnneeScolaire;
 
@ManagedBean
public class ChartView {
	

	@Inject
    protected IAbsenceLocal metier; 
	
	@Inject
	protected ModelBeanAnneeScolaire modannee;
	
    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
    private LineChartModel areaModel;
    

	@PostConstruct
    public void init() {
		
    	createAreaModel();
        createAnimatedModels();
        
    }
    
    public List<AnneeScolaire> anneescolaires(){
    	
    	return (List<AnneeScolaire>) metier.get(AnneeScolaire.class);
    }
    
    public List<AbsenceEtud> absences(Long id){
    	
    	return metier.getElemnentmoduleAbsences(id); 
    }
 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
    	
         
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Total annuelle des Absence par genre ");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(180);
    }
    
    public int totalHeurs(Long id){
    	int toto = 0;
		for(AbsenceEtud sale : absences(id)) {
			if(sale.getEtudiant().getId() == id)
			toto+= sale.getNbrheurAbsence();
		}
		return toto;
    	
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        
        List<AnneeScolaire> ane=  (List<AnneeScolaire>) metier.get(AnneeScolaire.class);
        boys.setLabel("Homme");
        for(AnneeScolaire an:ane){
        	Long a=metier.getStatistiqueEtudiantbyYears(an.getId(),"Homme");
        	if(a== null) a= 0L;
        	String str= an.getBeginYear().toString();
        	boys.set(""+str.substring(0, 4), Integer.parseInt(""+a));
        	
        }       
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Femme");
        
        for(AnneeScolaire an:ane){
        	Long a=metier.getStatistiqueEtudiantbyYears(an.getId(),"Femme");
        	if(a== null) a= 0L;
        	String str= an.getBeginYear().toString();
        	girls.set(""+str.substring(0, 4), Integer.parseInt(""+a));
        	
        }
        
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
	
    public LineChartModel getAreaModel() {
        return areaModel;
    }
     
    private void createAreaModel() {
        areaModel = new LineChartModel();
        List<AnneeScolaire> ane=  (List<AnneeScolaire>) metier.get(AnneeScolaire.class);
        Long max= 0L;
        
        LineChartSeries boys = new LineChartSeries();
        boys.setFill(true);
        boys.setLabel("Homme");
        
        for(AnneeScolaire an:ane){
        	Long a=metier.getStatistiqueEtudiantbyYears(an.getId(),"Homme");
        	
        	if(a== null) a= 0L;
        	max = max + a;
        	String str= an.getBeginYear().toString();
        	boys.set(""+str.substring(0, 4), Integer.parseInt(""+a));        	
        }
        
        LineChartSeries girls = new LineChartSeries();
        girls.setFill(true);
        girls.setLabel("Femme");
        
        for(AnneeScolaire an:ane){
        	Long a=metier.getStatistiqueEtudiantbyYears(an.getId(),"Femme");
        	
        	if(a== null) a= 0L;
        	max = max + a;
        	String str= an.getBeginYear().toString();
        	girls.set(""+str.substring(0, 4), Integer.parseInt(""+a));        	
        }
        
        
        areaModel.addSeries(boys);
        areaModel.addSeries(girls);        
        
         
        areaModel.setTitle("Total annuelle des Absence par genre ");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
         
        Axis xAxis = new CategoryAxis("Years");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre total des heurs d'absences");
        yAxis.setMin(0);
        yAxis.setMax(30+max);
    }
    
}
