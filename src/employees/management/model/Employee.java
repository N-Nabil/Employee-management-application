package employees.management.model;
import java.time.LocalDate;

public class Employee {
	protected int id;
	protected String nom;
	protected String prenom;
	protected String cin;
	protected String type_contrat;
	protected String sexe;
	protected String poste;
	protected String email;
	protected String num_tel;
	protected LocalDate date_naissance , date_entree ;
	
	public Employee () {
	}
	
	public Employee(int id, String nom, String prenom, String cin, String type_contrat, String sexe, String poste,
			String email, String num_tel, LocalDate date_naissance, LocalDate date_entree) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.type_contrat = type_contrat;
		this.sexe = sexe;
		this.poste = poste;
		this.email = email;
		this.num_tel = num_tel;
		this.date_naissance = date_naissance;
		this.date_entree = date_entree;
	}
	public Employee(String nom, String prenom, String cin, String type_contrat, String sexe, String poste, String email,
			String num_tel, LocalDate date_naissance, LocalDate date_entree) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.type_contrat = type_contrat;
		this.sexe = sexe;
		this.poste = poste;
		this.email = email;
		this.num_tel = num_tel;
		this.date_naissance = date_naissance;
		this.date_entree = date_entree;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getType_contrat() {
		return type_contrat;
	}
	public void setType_contrat(String type_contrat) {
		this.type_contrat = type_contrat;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	public LocalDate getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}
	public LocalDate getDate_entree() {
		return date_entree;
	}
	public void setDate_entree(LocalDate date_entree) {
		this.date_entree = date_entree;
	} 
}
