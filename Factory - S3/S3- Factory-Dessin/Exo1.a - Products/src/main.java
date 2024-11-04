public class main {



  public static void main(String[] args) {
    MagasinDeDVD magasinDvd = new DVDMethodFactory();
    MagasinDeLivre magasinLivre = new LivreMethodFactory();
    magasinLivre.ajouterLivre("test livre" ,1997);
    magasinDvd.ajouterDVD("test DVD" , 1998);
  }
}
