public class Etudiant implements InterfEtudiant{
		private int matricule;
	    private String nom;
	    private String prenom;
	    private String email ;
	    private String pwd;
	    private int nbLivreMensuel_Autorise;
	    private int nbLivreEmprunte;
	    private int id_universite;
	    
	   
		public Etudiant(int matricule, String nom, String prenom, String email,String pwd, int id_universite) {
			
			this.matricule = matricule;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.pwd = pwd;
			this.id_universite = id_universite;
		}
		@Override
		public void setMatricule(int matricule) {
			this.matricule = matricule;
		}
		@Override
		public String getNom() {
			return nom;
		}
		@Override
		public void setNom(String nom) {
			this.nom = nom;
		}
		@Override
		public String getPrenom() {
			return prenom;
		}
		@Override
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		@Override
		public String getEmail() {
			return email;
		}
		@Override
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public int getNbLivreMensuel_Autorise() {
			return nbLivreMensuel_Autorise;
		}
		@Override
		public void setNbLivreMensuel_Autorise(int nbLivreMensuel_Autorise) {
			this.nbLivreMensuel_Autorise = nbLivreMensuel_Autorise;
		}
		@Override
		public int getNbLivreEmprunte() {
			return nbLivreEmprunte;
		}
		@Override
		public void setNbLivreEmprunte(int nbLivreEmprunte) {
			this.nbLivreEmprunte = nbLivreEmprunte;
		}
		@Override
		public int getId_universite() {
			return id_universite;
		}
		@Override
		public void setId_universite(int id_universite) {
			this.id_universite = id_universite;
		}
		@Override
		public String getPwd() {
			return pwd;
		}
		@Override
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		@Override
		public int getMatricule() {
			// TODO Auto-generated method stub
			return 0;
			return matricule;
		}


		
		
	    }