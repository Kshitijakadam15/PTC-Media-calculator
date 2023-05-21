package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import components.Agar;
import components.Macronutrient;
import components.MediaComponent;
import components.Micronutrient;
import components.Ph;
import components.PlantGrowthRegulator;
import components.Vitamin;
import components.sucrose;
import coustomexception.NoComponentException;
import display.Display;

public class MediaCalculator {
	 private List<MediaComponent> components;
	    private double volume;

	    public MediaCalculator() {
	        components = new ArrayList<>();
	    }

	    public void addComponent(MediaComponent component) {
	        components.add(component);
	    }

	    public void setVolume(double volume){
	    	   this.volume=volume ;
	    }
	   
	    public void calculateMedia() {
	        System.out.println("Components of the plant tissue culture media:");

	        for (MediaComponent component : components) {
	            double result = component.calculateComponent(volume);
	            String unit = "";
	            if (component instanceof sucrose|| component instanceof Agar) {
	                unit = "g";
	            } else if (component instanceof Macronutrient || component instanceof Micronutrient||component instanceof Vitamin || component instanceof PlantGrowthRegulator) {
	                unit = "mg";
	            } else if (component instanceof Ph) {
	                unit = "pH";
	            }
	            System.out.printf("%s: %.2f %s%n", component.getClass().getSimpleName(), result, unit);
	        }
	    }
	    
	    public static void main(String[] args)
	    {
	        Scanner inp = new Scanner(System.in);
	        MediaCalculator calculator = new MediaCalculator();
	        Display.display();
	        boolean flag1=false;
	        while(!flag1){
	        try
	        {
	          System.out.println("\n");
	          System.out.print("\nEnter the volume of media to prepare: ");
	          double volume = inp.nextDouble();
	          calculator.setVolume(volume);
	          flag1=true;
	        }
		       catch(Exception  e)
		       {
		    	   System.out.println("Please Enter Number");
		    	   inp.nextLine();
		       }
	       }
	        boolean a=false;
	        boolean b=false;
	        boolean c=false;
	        boolean d=false;
	        
	       while(!a){
	       try
	       {
	    	   System.out.print("Enter the concentration of macronutrient stock solution: ");
		       double macronutrientConcentration = inp.nextDouble();
	    	   calculator.addComponent(new Macronutrient(macronutrientConcentration));
	    	   a=true;
	       }
	       catch(NoComponentException e)
	       {
	    	   System.out.println(e.getMessage());
	    	   inp.nextLine();
	       }
	       catch(Exception  e)
	       {
	    	   System.out.println("Please Enter Number");
	    	   inp.nextLine();
	       }
	     }
	       
	       while(!b) { 
	        try {
	        	System.out.print("Enter the concentration of micronutrient stock solution: ");
		        double micronutrientConcentration = inp.nextDouble();
	            calculator.addComponent(new Micronutrient(micronutrientConcentration));
	            b=true;
	         }
	       catch(NoComponentException e)
	       {
	    	   System.out.println(e.getMessage());
	    	   inp.nextLine();
	       }
	       catch(Exception  e)
	       {
	    	   System.out.println("Please Enter Number");
	    	   inp.nextLine();
	       }
	   }
	        while(!c) 
	        {
	        try
	        {   System.out.print("Enter the concentration of vitamin stock solution: ");
	            double vitaminConcentration = inp.nextDouble();
	        	calculator.addComponent(new Vitamin(vitaminConcentration));
	        	c=true;
	        }
		       catch(NoComponentException e)
		       {
		    	   System.out.println(e.getMessage());
		    	   inp.nextLine();
		       }
		       catch(Exception  e)
		       {
		    	   System.out.println("Please Enter Number");
		    	   inp.nextLine();
		       }
	        }
	        
	        while(!d) 
	        {
	        try
	        { System.out.print("Enter the concentration of plantgrowthregulators stock solution: ");
	           double plantgrowthregulatorsConcentration1 = inp.nextDouble();
	        	calculator.addComponent(new PlantGrowthRegulator(plantgrowthregulatorsConcentration1));
	        	d=true;
	        }
		    catch(NoComponentException e)
		       {
		    	   System.out.println(e.getMessage());
		    	   inp.nextLine();
		       }
		    catch(Exception  e)
		       {
		    	   System.out.println("Please Enter Number");
		    	   inp.nextLine();
		       }
	        }
	           calculator.addComponent(new sucrose());
	    	   calculator.addComponent(new Agar());
	           calculator.addComponent(new Ph());
	           calculator.calculateMedia();
	        inp.close();
	    }
}