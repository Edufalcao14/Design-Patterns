public class DVDFactory implements AbstractFactory{
  @Override
  public Product getProduct(String name, int anneeDeParution) {
    return new DVD(name,anneeDeParution);
  }
}
