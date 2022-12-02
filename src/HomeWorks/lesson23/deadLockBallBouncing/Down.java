package HomeWorks.lesson23.deadLockBallBouncing;

public class Down {
    private Up up;

    public Up getUp() {
        return up;
    }

    public void setUp(Up up) {
        this.up = up;
    }
    public synchronized String move () {
        return "The ball falls down";
    }
    public synchronized String moveUp (Up up){
        return up.move();
    }
}
