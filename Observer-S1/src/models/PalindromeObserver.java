package models;

public class PalindromeObserver implements Observer {
  private int nbrPalindromes = 0;

  @Override
  public void update(String ligne) {
    for (String mot : ligne.trim().split("\\s+")) {
      StringBuffer temp = new StringBuffer(mot);
      if (mot.equalsIgnoreCase(temp.reverse().toString()) && mot.length() > 1) {
        nbrPalindromes++;
      }
    }
  }

  public int getPalindromeCount() {
    return nbrPalindromes;
  }
}
