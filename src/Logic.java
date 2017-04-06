
public class Logic {
	
	private int userNr; /* This i the user input for a particular place in the two digit number */
	private int nr; /* This is the number in the same place as the user input */
	private int secondNr; /* This is the number in the opposite place of the two digit number */
	
	public Logic() {
		
	}

	public void setLogic(int userNr, int nr, int secondNr) {
		this.userNr = userNr;
		this.nr = nr;
		this.secondNr = secondNr;
	}
	public String getState() {
		
		if(userNr == nr) return "Fermi";
		
		else if (userNr == secondNr) return "Pico";
		
		else return "Bagel";
	}
	
}
