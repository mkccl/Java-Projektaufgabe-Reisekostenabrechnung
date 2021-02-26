package michael;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class ReisekostenPanel extends JPanel implements ActionListener {

	private int height = 40;
	
	// Scheint so dass bei MacOS nur "com.mysql.cj.jdbc.Driver" geht
	// also bitte auf "com.mysql.jdbc.Driver"
	// URL muss auf 127.0.0.1 angepasst werden
    private String treiber = "com.mysql.cj.jdbc.Driver";
    private String url     = "jdbc:mysql://192.168.64.2/Kosten?user=root";
	
    ReisekostenFehler p = new ReisekostenFehler();
	KostenArt tagegeldArt = new KostenArt();
	KostenArt uebernachtungArt = new KostenArt();
	KostenArt fahrtkostenArt = new KostenArt();
	KostenArt sonstigesArt = new KostenArt();
	KundenId k = new KundenId();
	
	
	JButton abschicken = new JButton("Absenden!");
	
	JTextField rechNummerText = new JTextField("");
	JTextField datumText = new JTextField("");
	
	JTextField nameText = new JTextField("");
	JTextField strasseText = new JTextField("");
	JTextField plzText = new JTextField("");
	JTextField vornameText = new JTextField("");
	JTextField ortText = new JTextField("");
	
	JLabel datumLabel      = new JLabel("Datum:           ");
	JLabel rechNummerLabel = new JLabel("Rechnungsnummer: ");
	JLabel nameLabel       = new JLabel("Name:            ");
	JLabel strasseLabel    = new JLabel("Straße:		  ");
	JLabel plzLabel        = new JLabel("PLZ:			  ");
	JLabel vornameLabel    = new JLabel("Vorname:		  ");
	JLabel ortLabel 	   = new JLabel("Ort:			  ");
	
	JLabel kostenLabel = new JLabel("KOSTENART");
	JLabel anzahlLabel = new JLabel("ANZAHL");
	JLabel einzelLabel = new JLabel("EINZELVERGÜTUNG");
	JLabel gesamtLabel = new JLabel("GESAMTVERGÜTUNG");
	
	JLabel tagegeldLabel = new JLabel("");
	JLabel uebernachtungLabel = new JLabel("");
	JLabel fahrtkosten = new JLabel("");
	JLabel sonstiges = new JLabel("");
	
	JTextField anzahlTagegeldText = new JTextField("0");
	JTextField anzahlUebernachtungText = new JTextField("0");
	JTextField anzahlFahrtkostenText = new JTextField("0");
	JTextField anzahlSonstigesText = new JTextField("0");
	
	JLabel einzelTagesgeldText = new JLabel("TestTest");
	JLabel einzelUebernachtungText = new JLabel("TestTest");
	JLabel einzelFahrtkostenText = new JLabel("TestTest");
	JLabel einzelSonstigesText = new JLabel("TestTest");
	
	JLabel gesamtTagegeld = new JLabel("0.0");
	JLabel gesamtUebernachtung = new JLabel("0.0");
	JLabel gesamtFahrtkosten = new JLabel("0.0");
	JLabel gesamtSonstiges = new JLabel("0.0");
	
	
	public ReisekostenPanel() {
		
		this.setLayout(null);
		this.add(abschicken);
		this.add(tagegeldLabel);
		this.add(uebernachtungLabel);
		this.add(fahrtkosten);
		this.add(sonstiges);
		this.add(anzahlTagegeldText);
		this.add(anzahlUebernachtungText);
		this.add(anzahlFahrtkostenText);
		this.add(anzahlSonstigesText);
		this.add(einzelTagesgeldText);
		this.add(einzelUebernachtungText);
		this.add(einzelFahrtkostenText);
		this.add(einzelSonstigesText);
		this.add(gesamtTagegeld);
		this.add(gesamtUebernachtung);
		this.add(gesamtFahrtkosten);
		this.add(gesamtSonstiges);
		
		this.add(rechNummerLabel);
		this.add(rechNummerText);
		this.add(nameLabel);
		this.add(nameText);
		this.add(strasseLabel);
		this.add(strasseText);
		this.add(plzLabel);
		this.add(plzText);
		this.add(datumLabel);
		this.add(datumText);
		this.add(vornameLabel);
		this.add(vornameText);
		this.add(ortLabel);
		this.add(ortText);
		
		this.add(einzelLabel);
		this.add(kostenLabel);
		this.add(anzahlLabel);
		this.add(gesamtLabel);
		
		abschicken.setBounds(20,40,120,30);
		
		gesamtTagegeld.setBounds(540,490,150,40);
		gesamtUebernachtung.setBounds(540,530,150,40);
		gesamtFahrtkosten.setBounds(540,570,150,40);
		gesamtSonstiges.setBounds(540,610,150,40);
		
		einzelTagesgeldText.setBounds(380,490,150,40);
		einzelUebernachtungText.setBounds(380,530,150,40);
		einzelFahrtkostenText.setBounds(380,570,150,40);
		einzelSonstigesText.setBounds(380,610,150,40);
		
		tagegeldLabel.setBounds(70,490,150,40);
		uebernachtungLabel.setBounds(55,530,150,40);
		fahrtkosten.setBounds(60,570,150,40);
		sonstiges.setBounds(70,610,150,40);
		
		kostenLabel.setBounds(65,450,150,40);
		anzahlLabel.setBounds(230,450,150,40);
		einzelLabel.setBounds(345,450,150,40);
		gesamtLabel.setBounds(490,450,150,40);
		
		anzahlTagegeldText.setBounds(180,490,150,40);
		anzahlUebernachtungText.setBounds(180,530,150,40);
		anzahlFahrtkostenText.setBounds(180,570,150,40);
		anzahlSonstigesText.setBounds(180,610,150,40);
		anzahlTagegeldText.setHorizontalAlignment(JTextField.CENTER);
		anzahlFahrtkostenText.setHorizontalAlignment(JTextField.CENTER);
		anzahlSonstigesText.setHorizontalAlignment(JTextField.CENTER);
		anzahlUebernachtungText.setHorizontalAlignment(JTextField.CENTER);
		
		
		datumLabel.setBounds     (400,100,200,40);
		datumText.setBounds      (480,100,160,40);
		vornameLabel.setBounds   (400,200,200,40);
		vornameText.setBounds    (480,200,160,40);
		ortLabel.setBounds       (400,280,200,40);
		ortText.setBounds        (480,280,160,40);
		rechNummerLabel.setBounds(30,100,200,40);
		rechNummerText.setBounds (160,100,160,40);
		nameLabel.setBounds      (30,200,200,40);
		nameText.setBounds       (160,200,160,40);
		strasseLabel.setBounds   (30,240,200,40);
		strasseText.setBounds    (160,240,160,40);
		plzLabel.setBounds       (30,280,200,40);
		plzText.setBounds        (160,280,160,40);
		
		
		
		abschicken.addActionListener(this);
		
		tageGeld();
		uebernachtung();
		fahrtkosten();
		sonstiges();
			
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = 30, y = 450;
		
		g.drawString("Reisekostenabrechnung", 280, 40 );
		g.drawLine(280, 40, 430, 40);
		
		for(int i = 0; i < 4; i++) {
			for(int z = 0; z < 5; z++) {
				g.drawRect(x, y, 150, height);
				y += 40;
			}
			x += 150;
			y = 450;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == abschicken) {
			p.setName(nameText.getText());
			p.setVorname(vornameText.getText());
			p.setOrt(ortText.getText());
			p.setPlz(plzText.getText());
			p.setStrasse(strasseText.getText());
			p.setDatum(datumText.getText());
			
			
			vornameText.setText(p.getVorname());
			strasseText.setText(p.getStrasse());
			nameText.setText(p.getName());
			plzText.setText(p.getPlz());
			ortText.setText(p.getOrt());
			datumText.setText(p.getDatum());
			if(p.schreibeInDieDatenbank() == true)
				rechNummerText.setText(p.getRechnungnummer());
			
			try {
				p.setTageAnzahl(Integer.parseInt(anzahlTagegeldText.getText()));
				float sum = p.getTageAnzahl() * p.getTagegeldPreis();
				p.setTagegeldGesamt(sum);
			}
			catch(NumberFormatException nfe) {
				anzahlTagegeldText.setText("0");
			}
			try {
				p.setUebernachtungAnzahl(Integer.parseInt(anzahlUebernachtungText.getText()));
				float sum = p.getUebernachtungAnzahl() * p.getUebernachtungPreis();
				p.setUebernachtungGesamt(sum);
			}
			catch(NumberFormatException nfe) {
				anzahlUebernachtungText.setText("0");
			}
			try {
				p.setFahrtkostenAnzahl(Integer.parseInt(anzahlFahrtkostenText.getText()));
				float sum = p.getFahrtkostenAnzahl() * p.getFahrtkostenPreis();
				p.setFahrtkostenGesamt(sum);
			}
			catch(NumberFormatException nfe) {
				anzahlFahrtkostenText.setText("0");
			}
			try {
				p.setSonstigesAnzahl(Integer.parseInt(anzahlSonstigesText.getText()));
				float sum = p.getSonstigesAnzahl() * p.getSonstigesPreis();
				p.setSonstigesGesamt(sum);
			}
			catch(NumberFormatException nfe) {
				anzahlSonstigesText.setText("0");
			}

			gesamtTagegeld.setText("" + p.getTagegeldGesamt());
			gesamtUebernachtung.setText("" + p.getUebernachtungGesamt());
			gesamtFahrtkosten.setText("" + p.getFahrtkostenGesamt());
			gesamtSonstiges.setText("" + p.getSonstigesGesamt());

			
			if(p.schreibeInDieDatenbank() == true) {
				schreibeDatenbank();
			}
			else
				System.out.println("Fehleingaben vorhanden");
		}
		
		
	}
	
	public void schreibeDatenbank() {
		
		
		try {
			Class.forName(treiber);
			Connection c = DriverManager.getConnection(url);
			String sql = String.format("INSERT INTO Kunde (Name,Vorname,Straße,PLZ,Ort,Rechnungsnummer,Datum)"
					+ "VALUES ('%s','%s','%s','%s','%s','%s','%s')" , p.getName(),p.getVorname(),p.getStrasse(),p.getPlz(), p.getOrt(),p.getRechnungnummer(),p.getDatum());
			
			Statement s = c.createStatement ();
			s.executeUpdate (sql);
			
			c.close();
				
			
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
		kundeIdHolen();
		tagegeldSchreiben();
		uebernachtungSchreiben();
		fahrtkostenSchreiben();
		sonstigesSchreiben();
	}
	
	public void kundeIdHolen() {
		// Kunden ID holen
		try {
			Class.forName(treiber);
			Connection c2 = DriverManager.getConnection(url);
			String sql2 = String.format("SELECT * FROM Kunde WHERE name = '%s'", p.getName());
			
			Statement s2 = c2.createStatement ();
			ResultSet rs2 = s2.executeQuery (sql2);
			
			while(rs2.next()) {
				k.setKundenId(rs2.getInt("KundeID"));
			}
			
			c2.close();			
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void uebernachtungSchreiben() {
		try {
			Class.forName(treiber);
			Connection c1 = DriverManager.getConnection(url);
			String sql1 = String.format("INSERT INTO KundeKostenGesamt (KundeID,KostenartID,Anzahl,Gesamt)"
					+ "VALUES ('%s','%s','%s','%s')"
					, k.getKundenId(),uebernachtungArt.getKostenArtId(),p.getUebernachtungAnzahl(),p.getUebernachtungGesamt() );
			
			Statement s1 = c1.createStatement ();
			s1.executeUpdate (sql1);
			
			c1.close();
	
			}
			catch(ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			}
			catch(SQLException sqle) {
				System.out.println(sqle);
			}
	}
	public void fahrtkostenSchreiben() {
		try {
			Class.forName(treiber);
			Connection c1 = DriverManager.getConnection(url);
			String sql1 = String.format("INSERT INTO KundeKostenGesamt (KundeID,KostenartID,Anzahl,Gesamt)"
					+ "VALUES ('%s','%s','%s','%s')"
					, k.getKundenId(),fahrtkostenArt.getKostenArtId(),p.getFahrtkostenAnzahl(),p.getFahrtkostenGesamt());
			
			Statement s1 = c1.createStatement ();
			s1.executeUpdate (sql1);
			
			c1.close();
						
			}
			catch(ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			}
			catch(SQLException sqle) {
				System.out.println(sqle);
			}
	}
	public void sonstigesSchreiben() {
		try {
			Class.forName(treiber);
			Connection c1 = DriverManager.getConnection(url);
			String sql1 = String.format("INSERT INTO KundeKostenGesamt (KundeID,KostenartID,Anzahl,Gesamt)"
					+ "VALUES ('%s','%s','%s','%s')"
					, k.getKundenId(),sonstigesArt.getKostenArtId(),p.getSonstigesAnzahl(),p.getSonstigesGesamt());
			
			Statement s1 = c1.createStatement ();
			s1.executeUpdate (sql1);
			
			c1.close();
							
			}
			catch(ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			}
			catch(SQLException sqle) {
				System.out.println(sqle);
			}
	}
	public void tagegeldSchreiben() {
		// Tagegeld
		try {
		Class.forName(treiber);
		Connection c1 = DriverManager.getConnection(url);
		String sql1 = String.format("INSERT INTO KundeKostenGesamt (KundeID,KostenartID,Anzahl,Gesamt)"
				+ "VALUES ('%s','%s','%s','%s')"
				, k.getKundenId(),tagegeldArt.getKostenArtId(),p.getTageAnzahl(),p.getTagegeldGesamt());
		
		Statement s1 = c1.createStatement ();
		s1.executeUpdate (sql1);
		
		c1.close();
		
		
		

		System.out.println("Erfolgreich in die Datenbank geschrieben!");
			
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void sonstiges() {
		
		String preis;
		
		try {
			Class.forName(treiber);
			Connection c = DriverManager.getConnection(url);
			String sql = "SELECT * FROM Kostenart WHERE KostenartID = 4";
			
			Statement s = c.createStatement ();
			ResultSet rs = s.executeQuery (sql);
			
			while(rs.next()) {
				sonstiges.setText(rs.getString("KostenArt"));
				einzelSonstigesText.setText(rs.getString("Kosten"));
				preis = rs.getString("Kosten");
				sonstigesArt.setKostenArtId(rs.getInt("KostenartID"));
				p.setSonstigesPreis(Float.parseFloat(preis));
				
			}
			
			c.close();
							
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void fahrtkosten() {
		
		String preis;
		
		try {
			Class.forName(treiber);
			Connection c = DriverManager.getConnection(url);
			String sql = "SELECT * FROM Kostenart WHERE KostenartID = 3";
			
			Statement s = c.createStatement ();
			ResultSet rs = s.executeQuery (sql);
			
			while(rs.next()) {
				fahrtkosten.setText(rs.getString("KostenArt"));
				einzelFahrtkostenText.setText(rs.getString("Kosten"));
				preis = rs.getString("Kosten");
				fahrtkostenArt.setKostenArtId(rs.getInt("KostenartID"));
				p.setFahrtkostenPreis(Float.parseFloat(preis));
			}
			
			c.close();
					
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void uebernachtung() {
		
		String preis;
		
		try {
			Class.forName(treiber);
			Connection c = DriverManager.getConnection(url);
			String sql = "SELECT * FROM Kostenart WHERE KostenartID = 2";
			
			Statement s = c.createStatement ();
			ResultSet rs = s.executeQuery (sql);
			
			while(rs.next()) {
				uebernachtungLabel.setText(rs.getString("KostenArt"));
				einzelUebernachtungText.setText(rs.getString("Kosten"));
				preis = rs.getString("Kosten");
				uebernachtungArt.setKostenArtId(rs.getInt("KostenartID"));
				p.setUebernachtungPreis(Float.parseFloat(preis));
			}
			
			c.close();
					
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void tageGeld() {
		
		String preis;
		
		try {
			Class.forName(treiber);
			Connection c = DriverManager.getConnection(url);
			String sql = "SELECT * FROM Kostenart WHERE KostenartID = 1";
			
			Statement s = c.createStatement ();
			ResultSet rs = s.executeQuery (sql);
			
			while(rs.next()) {
				tagegeldLabel.setText(rs.getString("KostenArt"));
				einzelTagesgeldText.setText(rs.getString("Kosten"));
				preis = rs.getString("Kosten");
				tagegeldArt.setKostenArtId(rs.getInt("KostenartID"));
				p.setTagegeldPreis(Float.parseFloat(preis));
			}
			
			c.close();
					
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
}
