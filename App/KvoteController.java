package app;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class KvoteController {

	@FXML TextField beerAmount, wineAmount, fwineAmount, liquorAmount, cigaretteAmount, tobaccoAmount, rollingpaperAmount;
	@FXML Button button;
	@FXML TextArea output;
	
	private Kvoteinnhold quota;
	private KvoteKalkulator calculator;
	private KvoteIOInterface io;
	
	@FXML
	public void initialize() {
		reset();
		quota = new Kvoteinnhold();
		calculator = new KvoteKalkulator();
		io = new KvoteIO();
	}
	
	public void reset() {
		beerAmount.setText("0");
		wineAmount.setText("0");
		fwineAmount.setText("0");
		liquorAmount.setText("0");
		cigaretteAmount.setText("0");
		tobaccoAmount.setText("0");
		rollingpaperAmount.setText("0");
		
		output.setText("PÂ tide Â fylle opp kvoten!");
	}
	
	public void calculateQuota() {
		try{
			
			double beer = Double.parseDouble(beerAmount.getText());
			double wine = Double.parseDouble(wineAmount.getText());
			double fwine = Double.parseDouble(fwineAmount.getText());
			double liquor = Double.parseDouble(liquorAmount.getText());
			double cigarette = Double.parseDouble(cigaretteAmount.getText());
			double tobacco = Double.parseDouble(tobaccoAmount.getText());
			double rollingpaper = Double.parseDouble(rollingpaperAmount.getText());
			
			quota = new Kvoteinnhold(beer, wine, fwine, liquor, cigarette, tobacco, rollingpaper);
			calculator = new KvoteKalkulator(beer, wine, fwine, liquor, cigarette, tobacco, rollingpaper, quota);
			
			output.setText(calculator.toString());
		}
		catch (Exception e) {
			output.setText(e.toString());
		}
	}
	
	public void save() {
		try {
			io.save("kvotekalkulator.txt", calculator);
		} catch (IOException e) {
			e.printStackTrace();
			output.setText("Noe gikk galt under skriving til fil");
		}
	}
	
	public void load() {
		try {
			KvoteObjectLoader loader = io.load("kvotekalkulator.txt");
			calculator = loader.calculator;
			
			beerAmount.setText(Double.toString(calculator.getBeerAmount()));
			wineAmount.setText(Double.toString(calculator.getWineAmount()));
			fwineAmount.setText(Double.toString(calculator.getFwineAmount()));
			liquorAmount.setText(Double.toString(calculator.getLiquorAmount()));
			cigaretteAmount.setText(Double.toString(calculator.getCigaretteAmount()));
			tobaccoAmount.setText(Double.toString(calculator.getTobaccoAmount()));
			rollingpaperAmount.setText(Double.toString(calculator.getRollingpaperAmount()));

			calculateQuota();
			
		} catch (IOException e) {
			e.printStackTrace();
			output.setText("Filnavnet finnes ikke, er du sikker p√• at du har skrevet riktig? Sjekk en gang til");
		}
	}
}
