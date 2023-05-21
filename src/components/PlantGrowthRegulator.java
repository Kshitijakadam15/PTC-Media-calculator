package components;

import coustomexception.NoComponentException;

public class PlantGrowthRegulator extends MediaComponent {
	public PlantGrowthRegulator(double concentration)throws NoComponentException {
		if(concentration>0)
	  {
        this.concentration = concentration;
	  }
        else {
			throw new NoComponentException();
		}
    }
    public double calculateComponent(double volume) {
        return 0.1 * volume * concentration;
    }
}
 