package michael;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;


public class ReisekostenFehler {
	
	private Date date = new Date();
	private Random rand = new Random();
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	private SimpleDateFormat datumKurz = new SimpleDateFormat("ddMMYYYY");
	
	private String name,
				   rechnungsnummer,
				   datum,
				   vorname,
				   strasse,
				   plz,
				   ort;
	private int   tagegeldAnzahl,
				  uebernachtungAnzahl,
				  fahrtkostenAnzahl,
				  sonstigesAnzahl;
	private float tagegeldPreis,
				  uebernachtungPreis,
				  fahrtkostenPreis,
				  sonstigesPreis;
	
	private float tagegeldGesamt = 0.0f,
				  uebernachtungGesamt = 0.0f,
				  fahrtkostenGesamt = 0.0f,
				  sonstigesGesamt = 0.0f;
	
	boolean nameFehler = true,
			vornameFehler = true,
			strasseFehler = true,
			plzFehler = true,
			ortFehler = true,		
			tagegeldFehler = true,
			uebernachtungFehler = true,
			fahrtkostenFehler = true,
			sonstigesFehler = true;
			
			

	public ReisekostenFehler() {
		
	}
	// Ort
	public void setOrt(String ort) {
		
		if(ort != null && !ort.isEmpty() && ort != " ") {
			ort = ort.substring(0,1).toUpperCase() + ort.substring(1);
			this.ort = ort;
			ortFehler = false;
		}
		else {
			this.ort = "Ort ist leer!";
			ortFehler = true;
		}
	}
	public String getOrt() {
		return ort;
	}
	// PLZ
	public void setPlz(String plz) {
		if(Pattern.compile("[0-9]").matcher(plz).find()) {
			this.plz = plz;
			plzFehler = false;
		}
		else {
			this.plz = "Nur Zahlen!";
			plzFehler = true;
		}
	}
	public String getPlz() {
		return plz;
	}
	// Straße
	public void setStrasse(String strasse) {
		if(strasse != null && !strasse.isEmpty() && strasse != " ") {
			strasse = strasse.substring(0,1).toUpperCase() + strasse.substring(1);
			this.strasse = strasse;
			strasseFehler = false;
		}
		else {
			this.strasse = "Straße ist leer!";
			strasseFehler = true;
		}
	}
	public String getStrasse() {
		return strasse;
	}
	// Vorname
	public void setVorname(String vorname) {
		if(vorname != null && !vorname.isEmpty() && vorname != " ") {
			vorname = vorname.substring(0,1).toUpperCase() + vorname.substring(1);
			this.vorname = vorname;
			vornameFehler = false;
		}
		else {
			this.vorname = "Vorname ist leer!";
			vornameFehler = true;
		}
	}
	public String getVorname() {
		return vorname;
	}
	// Datum
	public void setDatum(String datum) {
		datum = formatter.format(date);
		this.datum = datum;
	}
	public String getDatum() {
		return datum;
	}
	// Rechnungsnummer
	public void setRechnungsnummer(String rechnungsnummer) {
		this.rechnungsnummer = rechnungsnummer;
	}
	public String getRechnungnummer() {
		
		String name = getName();
		String vname = getVorname();
		String rechnung = "REC";
		char n = name.charAt(0);
		char v = vname.charAt(0);
		
		rechnungsnummer = rechnung + datumKurz.format(date) + n + v + (rand.nextInt(999) + 1);
		
		return rechnungsnummer;
	}
	// Name
	public void setName(String name) {
		if(name != null && !name.isEmpty() && name != " ") {
			name = name.substring(0,1).toUpperCase() + name.substring(1);
			this.name = name;
			nameFehler = false;
		}
		else {
			this.name = "Name ist leer!";
			nameFehler = true;
		}
	}
	public String getName() {
		return name;
	}
	
	/*
	 * 
	 * Anzahl 
	 * 
	 */
	
	// Tagegeld Anzahl
	public void setTageAnzahl(int tagegeldAnzahl) {
		if(tagegeldAnzahl >= 0) {
			this.tagegeldAnzahl = tagegeldAnzahl;
			tagegeldFehler = false;
		}
		else
			tagegeldFehler = true;
	}
	public int getTageAnzahl() {
		return tagegeldAnzahl;
	}
	// Übernachtung Anzahl
	public void setUebernachtungAnzahl(int uebernachtungAnzahl) {
		if(uebernachtungAnzahl >= 0) {
			this.uebernachtungAnzahl = uebernachtungAnzahl;
			uebernachtungFehler = false;
		}
		else
			uebernachtungFehler = true;
	}
	public int getUebernachtungAnzahl() {
		return uebernachtungAnzahl;
	}
	// Fahrtkosten Anzahl
	public void setFahrtkostenAnzahl(int fahrtkostenAnzahl) {
		if(fahrtkostenAnzahl >= 0) {
			this.fahrtkostenAnzahl = fahrtkostenAnzahl;
			fahrtkostenFehler = false;
		}
		else
			fahrtkostenFehler = true;
	}
	public int getFahrtkostenAnzahl() {
		return fahrtkostenAnzahl;
	}
	// Sonstiges Anzahl
	public void setSonstigesAnzahl(int sonstigesAnzahl) {
		if(sonstigesAnzahl >= 0) {
			this.sonstigesAnzahl = sonstigesAnzahl;
			sonstigesFehler = false;
		}
		else
			sonstigesFehler = true;
	}
	public int getSonstigesAnzahl() {
		return sonstigesAnzahl;
	}
	
	/*
	 * 
	 * Einzelvergütung 
	 * 
	 */
	// Tagegeld Preis
	public void setTagegeldPreis(float tagegeldPreis) {
		this.tagegeldPreis = tagegeldPreis;
	}
	public float getTagegeldPreis() {
		return tagegeldPreis;
	}
	// Übernachtung Preis
	public void setUebernachtungPreis(float uebernachtungPreis) {
		this.uebernachtungPreis = uebernachtungPreis;
	}
	public float getUebernachtungPreis() {
		return uebernachtungPreis;
	}
	// Fahrtkosten Preis
	public void setFahrtkostenPreis(float fahrtkostenPreis) {
		this.fahrtkostenPreis = fahrtkostenPreis;
	}
	public float getFahrtkostenPreis() {
		return fahrtkostenPreis;
	}
	// Sonstiges Preis
	public void setSonstigesPreis(float sonstigesPreis) {
		this.sonstigesPreis = sonstigesPreis;
	}
	public float getSonstigesPreis() {
		return sonstigesPreis;
	}
	
	/*
	 * 
	 * Gesamtvergütung 
	 * 
	 */
	// Tagegeld gesamt
	public void setTagegeldGesamt(float tagegeldGesamt) {				
		this.tagegeldGesamt = tagegeldGesamt;
	}
	public float getTagegeldGesamt() {
		return tagegeldGesamt;
	}
	// Übernachtung gesamt
	public void setUebernachtungGesamt(float uebernachtungGesamt) {
		this.uebernachtungGesamt = uebernachtungGesamt;
	}
	public float getUebernachtungGesamt() {
		return uebernachtungGesamt;
	}
	// Fahrtkosten gesamt
	public void setFahrtkostenGesamt(float fahrtkostenGesamt) {
		this.fahrtkostenGesamt = fahrtkostenGesamt;
	}
	public float getFahrtkostenGesamt() {
		return fahrtkostenGesamt;
	}
	// Sonstiges gesamt
	public void setSonstigesGesamt(float sonstigesGesamt) {
		this.sonstigesGesamt = sonstigesGesamt;
	}
	public float getSonstigesGesamt() {
		return sonstigesGesamt;
	}
	
	public boolean schreibeInDieDatenbank() {

		if(nameFehler == false && vornameFehler == false 
		   && strasseFehler == false && plzFehler == false
		   && ortFehler == false && tagegeldFehler == false
		   && uebernachtungFehler == false && fahrtkostenFehler == false
		   && sonstigesFehler == false) {
			return true;			
		}
		else
			return false;
		
	}
	
}
