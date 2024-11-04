public class DVDMethodFactory extends MagasinDeDVD{

  @Override
  protected DVD getDVD(String name, int anneeDeParution) {
    return new DVD(name,anneeDeParution);
  }
}
