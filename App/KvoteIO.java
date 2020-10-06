package app;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class KvoteIO implements KvoteIOInterface {

	@Override
	public void save(String filename, KvoteKalkulator calc) throws IOException {
		PrintWriter writer = new PrintWriter(filename);
		
		
		// Hvorfor fungerer ikke dette?
		
//		String s = String.format("%f\n%f\n%f\n%f\n%f\n%f\n%f", calc.getBeerAmount(),
//				calc.getWineAmount(), calc.getFwineAmount(), calc.getLiquorAmount(),
//				calc.getCigaretteAmount(), calc.getTobaccoAmount(), calc.getRollingpaperAmount());
//		
		String s = "";
		s += calc.getBeerAmount() +"\n";
		s += calc.getWineAmount() +"\n";
		s += calc.getFwineAmount() +"\n";
		s += calc.getLiquorAmount() +"\n";
		s += calc.getCigaretteAmount() +"\n";
		s += calc.getTobaccoAmount() +"\n";
		s += calc.getRollingpaperAmount();

		writer.print(s);
		
		writer.flush();
		writer.close();
	}

	@Override
	public KvoteObjectLoader load(String filename) throws IOException {
		
		Scanner scanner = new Scanner(new File(filename));
		
		String[] calc = new String[7];
		for(int i = 0; i<7; i++) {
			calc[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		Double beerAmount = Double.parseDouble(calc[0]);
		Double wineAmount = Double.parseDouble(calc[1]);
		Double fwineAmount = Double.parseDouble(calc[2]);
		Double liquorAmount = Double.parseDouble(calc[3]);
		Double cigaretteAmount = Double.parseDouble(calc[4]);
		Double tobaccoAmount = Double.parseDouble(calc[5]);
		Double rollingpaperAmount = Double.parseDouble(calc[6]);
		
		Kvoteinnhold quota = new Kvoteinnhold(beerAmount, wineAmount, fwineAmount, liquorAmount, 
				cigaretteAmount, tobaccoAmount, rollingpaperAmount);
		
		KvoteKalkulator calculator = new KvoteKalkulator(beerAmount, wineAmount, fwineAmount, 
				liquorAmount, cigaretteAmount, tobaccoAmount, rollingpaperAmount, quota);
		
		
		KvoteObjectLoader loader = new KvoteObjectLoader();
		loader.calculator = calculator;
		
		return loader;
	}

}
