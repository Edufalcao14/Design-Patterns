import java.util.Date;

public class Album {

  private final String titre ; //required
  private final String artistName; //Required
  private final String label; //Optional
  private final String productor; //Optional
  private final String country; //Optional
  private final String version; //Optional
  private final String gender; //Optional
  private final int realeaseDate; //Optional
  private final Boolean isRemastered; //Optional
  private final int originalRealeaseDate; //Optional
  private final String standardQualityRate; //Optional
  private final String subscriberQualityRate; //Optional


  private Album(AlbumBuilder albumBuilder) {
    this.titre = albumBuilder.titre;
    this.artistName = albumBuilder.artistName;
    this.label = albumBuilder.label;
    this.productor = albumBuilder.productor;
    this.country = albumBuilder.country;
    this.version = albumBuilder.version;
    this.gender = albumBuilder.gender;
    this.realeaseDate = albumBuilder.realeaseDate;
    this.isRemastered = albumBuilder.isRemastered;
    this.originalRealeaseDate = albumBuilder.originalRealeaseDate;
    this.standardQualityRate = albumBuilder.standardQualityRate;
    this.subscriberQualityRate = albumBuilder.subscriberQualityRate;
  }


  public static class AlbumBuilder{
    private final String titre ; //required
    private final String artistName; //Required
    private String label; //Optional
    private String productor; //Optional
    private String country; //Optional
    private String version; //Optional
    private String gender; //Optional
    private int realeaseDate; //Optional
    private Boolean isRemastered; //Optional
    private int originalRealeaseDate; //Optional
    private String standardQualityRate; //Optional
    private String subscriberQualityRate; //Optional

    public AlbumBuilder(String titre, String artistName) {
      this.titre = titre;
      this.artistName = artistName;
    }
    public AlbumBuilder label (String label){
      this.label = label;
      return this;
    }
    public AlbumBuilder productor (String productor){
      this.productor = productor;
      return this;
    }
    public AlbumBuilder country (String country){
      this.country = country;
      return this;
    }
    public AlbumBuilder version (String country){
      this.version = version;
      return this;
    }
    public AlbumBuilder gender (String gender){
      this.gender = gender;
      return this;
    }
    public AlbumBuilder realeaseDate (int realeaseDate){
      this.realeaseDate = realeaseDate;
      return this;
    }
    public AlbumBuilder isRemastered (Boolean isRemastered){
      this.isRemastered = isRemastered;
      return this;
    }
    public AlbumBuilder originalRealeaseDate (int originalRealeaseDate){
      this.originalRealeaseDate = originalRealeaseDate;
      return this;
    }
    public AlbumBuilder standardQualityRate (String standardQualityRate){
      this.standardQualityRate = standardQualityRate;
      return this;
    }
    public AlbumBuilder subscriberQualityRate (String subscriberQualityRate){
      this.subscriberQualityRate = subscriberQualityRate;
      return this;
    }
    public Album build() {
      return new Album(this);
    }


  }
}

