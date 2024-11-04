public class CircleAbstractFactory implements AbstractFactory {

  @Override
  public Shape createShape(double size, Point p) {
    return new Circle(size,p);
  }
}
