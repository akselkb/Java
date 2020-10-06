package app;


public class Kvoteinnhold {

	private double beerQuota = 2, wineQuota = 1.5, liquorQuota = 1, 
			cigaretteQuota = 2, tobaccoQuota = 2.5, rollingpaperQuota = 2;
	
	
	public Kvoteinnhold() {
		
	}
	
	public Kvoteinnhold(double beerAmount, double wineAmount, double fwineAmount, double liquorAmount, 
			double cigaretteAmount, double tobaccoAmount, double rollingpaperAmount) {
		
		isValid(beerAmount, wineAmount, fwineAmount, liquorAmount, cigaretteAmount, tobaccoAmount, rollingpaperAmount);
		isRegular(beerAmount, wineAmount, fwineAmount, liquorAmount, cigaretteAmount, tobaccoAmount, rollingpaperAmount);
		swapAlcohol(beerAmount, wineAmount, fwineAmount, liquorAmount);
		swapTobacco(cigaretteAmount, tobaccoAmount, wineAmount, fwineAmount, beerAmount);
	}
	
	
	
	public double getBeerQuota() {
		return beerQuota;
	}

	public double getWineQuota() {
		return wineQuota;
	}

	public double getLiquorQuota() {
		return liquorQuota;
	}

	public double getCigaretteQuota() {
		return cigaretteQuota;
	}

	public double getTobaccoQuota() {
		return tobaccoQuota;
	}

	public double getRollingpaperQuota() {
		return rollingpaperQuota;
	}

	
	
	private void isRegular(double beerAmount, double wineAmount, double fwineAmount, double liquorAmount, double cigaretteAmount,
			double tobaccoAmount, double rollingpaperAmount) {
		 if(!((beerAmount+wineAmount+fwineAmount<=27)
				&& (liquorAmount <= 4)
				&& (cigaretteAmount <= 4)
				&& (tobaccoAmount <= 5)
				&& (rollingpaperAmount <= 4))) {
			 throw new IllegalArgumentException("Varene går utenfor kvoten for forenklet fortolling");
		 }
	}
	
	
	
	private void swapAlcohol(double beerAmount, double wineAmount, double fwineAmount, double liquorAmount) {
		
		if(liquorAmount == 0) {
			if(beerAmount<=beerQuota) {
				wineQuota += 1.5;
			}
			else if(wineAmount+fwineAmount<=wineQuota) {
				beerQuota += 1.5;
			}
			else {
				wineQuota += 1.5;
			}
			liquorQuota = 0;
		}	
		
		if(wineAmount+fwineAmount<wineQuota) {
			beerQuota += wineQuota-(wineAmount+fwineAmount);
			wineQuota = wineAmount+fwineAmount;
		}
	}
	
	
	
	private void swapTobacco(double cigaretteAmount, double tobaccoAmount, double wineAmount, double fwineAmount, double beerAmount) {
		if(cigaretteAmount == 0 && tobaccoAmount == 0) {
			if(wineAmount+fwineAmount<=wineQuota) {
				beerQuota += 1.5;
			}
			else if(beerAmount<=beerQuota) {
				wineQuota += 1.5;
			}
			else {
				wineQuota += 1.5;
			}
			cigaretteQuota = 0;
			tobaccoQuota = 0;
		}
		
		else if(cigaretteAmount>0) {
			tobaccoQuota = 0;
		}
		else if(tobaccoAmount>0) {
			cigaretteQuota = 0;
		}
	}
	
	
	
	private void isValid(double beerAmount, double wineAmount, double fwineAmount, double liquorAmount, 
			double cigaretteAmount, double tobaccoAmount, double rollingpaperAmount) {
		
		if(!(beerAmount >= 0 && wineAmount >= 0 && fwineAmount >= 0 && liquorAmount >= 0 
				&& cigaretteAmount >= 0 && tobaccoAmount >= 0 && rollingpaperAmount >= 0)) {
			throw new IllegalArgumentException("Ugyldig(e) verdi(er).");
		}
	}

	
}
