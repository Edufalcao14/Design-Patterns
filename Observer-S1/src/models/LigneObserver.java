package models;

public class LigneObserver implements Observer {
 private int compteurLignes = 0;

 @Override
 public void update(String ligne) {
  if (ligne != null) {
   compteurLignes++;
  }
 }

 public int getLineCount() {
  return compteurLignes;
 }
}