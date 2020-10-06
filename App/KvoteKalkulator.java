package app;

public class KvoteKalkulator {
	
	
	private double beerToDeclare, wineToDeclare, fwineToDeclare, liquorToDeclare, 
	cigaretteToDeclare, tobaccoToDeclare, rollingpaperToDeclare = 0;
	
	private double beerAmount, wineAmount, fwineAmount, liquorAmount, 
	cigaretteAmount, tobaccoAmount, rollingpaperAmount = 0;
	
	
	public KvoteKalkulator() {	
	}
	
	public KvoteKalkulator(double beerAmount, double wineAmount, double fwineAmount, double liquorAmount, 
			double cigaretteAmount, double tobaccoAmount, double rollingpaperAmount, Kvoteinnhold quota) {
		
		updateDeclaration(beerAmount, wineAmount, fwineAmount, liquorAmount, cigaretteAmount, 
				tobaccoAmount, rollingpaperAmount, quota);
		
		this.beerAmount = beerAmount;
		this.wineAmount = wineAmount;
		this.fwineAmount = fwineAmount;
		this.liquorAmount = liquorAmount;
		this.cigaretteAmount = cigaretteAmount;
		this.tobaccoAmount = tobaccoAmount;
		this.rollingpaperAmount = rollingpaperAmount;
	}
	
	
	
	private void updateDeclaration(double beerAmount, double wineAmount,double fwineAmount, 
			double liquorAmount, double cigaretteAmount, double tobaccoAmount, 
			double rollingpaperAmount, Kvoteinnhold quota) {
		
		if(!(beerAmount-quota.getBeerQuota()<=0)) {
			beerToDeclare = beerAmount-quota.getBeerQuota();
		}
		
		double wQuota = quota.getWineQuota();
		if(!(fwineAmount-quota.getWineQuota()<=0)) {
			fwineToDeclare = fwineAmount-quota.getWineQuota();
			wQuota = 0;
		}
		else {
			wQuota -= fwineAmount;
		}
		if(!(wineAmount-wQuota <= 0)){
			wineToDeclare = wineAmount-wQuota;
		}
		if(!(liquorAmount-quota.getLiquorQuota()<=0)) {
			liquorToDeclare = liquorAmount-quota.getLiquorQuota();
		}
		if(!(cigaretteAmount-quota.getCigaretteQuota()<=0)) {
			cigaretteToDeclare = cigaretteAmount-quota.getCigaretteQuota();
		}
		if(!(tobaccoAmount-quota.getTobaccoQuota()<=0)) {
			tobaccoToDeclare = tobaccoAmount-quota.getTobaccoQuota();
		}
		if(!(rollingpaperAmount-quota.getRollingpaperQuota()<=0)) {
			rollingpaperToDeclare = rollingpaperAmount-quota.getRollingpaperQuota();
		}
	}
	
	
		
	public String toString() {
		if (beerToDeclare == 0 && wineToDeclare == 0 
				&& liquorToDeclare == 0 && cigaretteToDeclare == 0 
				&& tobaccoToDeclare == 0 && rollingpaperToDeclare == 0) {
			return "Du er innenfor avgiftsfri kvote";
		}
		
		String decleration = "Kvoten oversteget. Følgende må fortolles:\n";
		if(beerToDeclare >0) {
			decleration +="\nØl - " + beerToDeclare + " L : " + Math.round(beerToDeclare*20) + " kr";
		}
		if(wineToDeclare >0) {
			decleration +="\nVin - " + wineToDeclare + " L : " + Math.round(wineToDeclare*60) + " kr";
		}
		if(fwineToDeclare >0) {
			decleration +="\nHetvin - " + fwineToDeclare + " L : " + Math.round(fwineToDeclare*115) + " kr";
		}
		if(liquorToDeclare >0) {
			decleration += "\nBrennvin - " + liquorToDeclare + " L : " + Math.round(liquorToDeclare*325) + " kr";
		}
		if(cigaretteToDeclare >0) {
			decleration += "\nSigaretter - " + Math.round(cigaretteToDeclare*100) + " stk : " + Math.round(cigaretteToDeclare*290) + " kr";
		}
		if(tobaccoToDeclare >0) {
			decleration += "\nAnnen tobakk - " + Math.round(tobaccoToDeclare*100) + " g : " + Math.round(tobaccoToDeclare*120) + " kr";
		}
		if(rollingpaperToDeclare >0) {
			decleration += "\nSigarettpapir - " + Math.round(rollingpaperToDeclare*100) + " stk : " + Math.round(rollingpaperToDeclare*5) + " kr";
		}
		decleration +="\n\nSum: "+Math.round((beerToDeclare*20 + wineToDeclare*60 + fwineToDeclare*115
				+liquorToDeclare*325+cigaretteToDeclare*290+tobaccoToDeclare*120+rollingpaperToDeclare*5)) + " kr";
		
		
		return decleration;
	}

	public double getBeerAmount() {
		return beerAmount;
	}

	public double getWineAmount() {
		return wineAmount;
	}

	public double getFwineAmount() {
		return fwineAmount;
	}

	public double getLiquorAmount() {
		return liquorAmount;
	}

	public double getCigaretteAmount() {
		return cigaretteAmount;
	}

	public double getTobaccoAmount() {
		return tobaccoAmount;
	}

	public double getRollingpaperAmount() {
		return rollingpaperAmount;
	}

	
	
	
	
	
}
