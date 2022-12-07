
public abstract class Package {

	TypePackage pack;



	public Package(TypePackage pack) {
		this.pack=pack;
	}



	public abstract int getNbrLivreAutorise();

	public abstract int getNbrLivreBonus();


}