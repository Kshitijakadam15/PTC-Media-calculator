package components;

import coustomexception.NoComponentException;

public class Micronutrient extends MediaComponent {
	 public Micronutrient(double concentration)throws  NoComponentException
	    {
		 if(concentration>0)
		{
	        this.concentration = concentration;
		}
		 else {
				throw new NoComponentException();
			}
	    }
	 public double calculateComponent(double volume) {
	        return 0.38 * volume * concentration;
	    }
}
