package models;

public class MotsObserver implements Observer {

  private int nbrMots = 0;

  @Override
  public void update(String ligne) {
    for (String mot : ligne.trim().split("\\s+")) {
      nbrMots++;
    }
  }

  public int getWordCount() {
    return nbrMots;
  }
}
