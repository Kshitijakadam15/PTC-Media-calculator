package components;

import coustomexception.NoComponentException;

public class Macronutrient extends MediaComponent   {
	public Macronutrient(double concentration) throws NoComponentException {
		if(concentration>0)
		{
        this.concentration = concentration;
		}
		else {
			throw new NoComponentException();
			
		}
    }
	 public double calculateComponent(double volume)
	    {
	        return 0.50 * volume * concentration;
	    }
}