import java.util.HashMap;
import java.util.Map;

public  abstract class MagasinDeLivre {
	private Map<String,Livre> etagere= new HashMap<String,Livre>();
	public void ajouterLivre(String name, int anneeDeParution){
		Livre livre=this.getLivre(name, anneeDeParution);
		etagere.put(name,livre);
	}
	protected abstract Livre getLivre(String name, int anneeDeParution);
	public Livre retourneLivre(String name){
		return etagere.get(name);
	}
}
