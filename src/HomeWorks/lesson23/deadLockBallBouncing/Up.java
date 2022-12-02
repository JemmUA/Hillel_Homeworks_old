package HomeWorks.lesson23.deadLockBallBouncing;

public class Up {
    private Down down;

    public Down getDown() {
        return down;
    }

    public void setDown(Down down) {
        this.down = down;
    }
    public synchronized String move () {
        return "The ball jumps up";
    }
    public synchronized String moveDown (Down down){
        try {
            Thread.sleep(11);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return down.move();
    }
}
