package michael;

import javax.swing.JFrame;

public class Reisekosten extends JFrame{
	
	public Reisekosten(String titel) {
		super(titel);
		setBounds(700,700,700,700);
		add( new ReisekostenPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Reisekosten("Reisekosten von Michael Krause");
	}
	
}
