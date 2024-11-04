package models;

public class BelgiqueObserver implements Observer {
  private int nbrBelgique = 0;

  @Override
  public void update(String ligne) {
    if (ligne.contains("Belgique")) {
      nbrBelgique++;
    }
  }

  public int getBelgiqueCount() {
    return nbrBelgique;
  }
}
