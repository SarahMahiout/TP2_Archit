public class ConcreteFactory extends AbstractFactory {

	@Override
	public Package getPackage(TypePackage typePackage) {
		// TODO Auto-generated method stub
		if(typePackage.equals(TypePackage.Standard)){
			return new Standard(null);
		}else if(typePackage.equals(TypePackage.Premium)){
			return new Premium(null);
		}
		return new illimité(null);
	}


}
