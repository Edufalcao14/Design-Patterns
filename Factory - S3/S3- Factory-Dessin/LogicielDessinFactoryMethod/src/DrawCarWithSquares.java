public class DrawCarWithSquares extends DrawCar{


  @Override
  public Shape createShape(double size, Point point) {
    return new Square(size,point);
  }
}
