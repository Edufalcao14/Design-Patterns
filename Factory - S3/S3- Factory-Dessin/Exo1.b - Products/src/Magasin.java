import java.util.HashMap;
import java.util.Map;


public class Magasin {
	private Map<String,Product> bac= new HashMap<String,Product>();
	private AbstractFactory a;

	public Magasin(AbstractFactory a) {
		this.a = a;
	}

	public void ajouter(String name, int anneeDeParution ){
		Product product = a.getProduct(name , anneeDeParution);
		bac.put(name,product);
	}
	public Product retourneDVD(String name){
		return bac.get(name);
	}
}
