public class SquareAbstractFactory implements AbstractFactory {

  @Override
  public Shape createShape(double size, Point p) {
    return new Square(size,p);
  }
}
