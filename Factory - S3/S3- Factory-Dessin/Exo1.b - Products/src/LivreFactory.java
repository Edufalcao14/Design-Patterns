public class LivreFactory implements AbstractFactory{


  @Override
  public Product getProduct(String name, int anneeDeParution) {
    return new Livre(name,anneeDeParution);
  }
}
