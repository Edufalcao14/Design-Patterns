import java.util.HashMap;
import java.util.Map;


public abstract class MagasinDeDVD {
	private Map<String,DVD> bac= new HashMap<String,DVD>();
	public void ajouterDVD(String name, int anneeDeParution){
		DVD dvd=this.getDVD(name, anneeDeParution);
		bac.put(name,dvd);
	}

	protected abstract DVD getDVD(String name, int anneeDeParution);

	public DVD retourneDVD(String name){
		return bac.get(name);
	}
}
