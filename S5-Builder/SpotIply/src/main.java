
public class main {

  public static void main(String[] args) {
    Album lonerism = new Album.AlbumBuilder("Lonerism", "Tame Impala").country("Australie").realeaseDate(2012).gender("indie rock").build();
    Album orange = new Album.AlbumBuilder("channel ORANGE", "Frank Ocean").realeaseDate(2012).gender("R&B").build();
    Album visions = new Album.AlbumBuilder("Visions", "Grimes").realeaseDate(2012).label("4AD").gender("Electronic").build();

    System.out.println(lonerism);
    System.out.println(orange);
    System.out.println(visions);

  }

}
