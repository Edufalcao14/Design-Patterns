public class Bear {
  public enum State{
    SLEEPING{
      @Override
      public void attack(Bear bear) {
        System.out.println("Zzzzzz");
      }
      @Override
      public void sleep(Bear bear) {
        throw new RuntimeException("already sleeping");
      }
    },
    NOT_SLEEPING{
      @Override
      public void attack(Bear bear) {
        System.out.println("GroaaR");
      }
      @Override
      public void wakeup(Bear bear) {
        throw new RuntimeException("Not sleeping");
      }
    };
    abstract void attack(Bear bear);

    public void sleep(Bear bear){
      bear.setState(SLEEPING);
    }

    public void wakeup(Bear bear) {
      bear.setState(NOT_SLEEPING);
    }
  }
  private State state;
  public Bear() {
    setState(State.NOT_SLEEPING);
  }
  public void attack() {
    state.attack(this);
  }

  public void sleep() {
    state.sleep(this);
  }

  public void wakeup() {
    state.wakeup(this);
  }

  public void setState(State state) {
    this.state= state;
  }

  public static void main(String[] args) {
    Bear b= new Bear();
    b.attack();
    b.sleep();
    b.attack();
  }
}