public class main {

  public static void main(String[] args) {

    LivreFactory livreFactory = new LivreFactory();
    DVDFactory dvdFactory = new DVDFactory();
    Magasin magasinLivre = new Magasin(livreFactory);
    Magasin magasinDVD = new Magasin(dvdFactory);
    magasinLivre.ajouter("Livre" , 1990 );
    magasinDVD.ajouter("DVD" , 1992 );

  }
}
