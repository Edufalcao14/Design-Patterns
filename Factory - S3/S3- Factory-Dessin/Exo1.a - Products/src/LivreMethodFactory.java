public class LivreMethodFactory extends MagasinDeLivre{
  @Override
  protected Livre getLivre(String name, int anneeDeParution) {
    return new Livre(name , anneeDeParution);
  }
}
