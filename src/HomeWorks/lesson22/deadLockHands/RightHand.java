package HomeWorks.lesson22.deadLockHands;

public class RightHand {
    private LeftHand leftHand;

    public LeftHand getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(LeftHand leftHand) {
        this.leftHand = leftHand;
    }

    public synchronized String washHand() {
        return "Right hand wash left hand";
    }

    public synchronized String washLeftHand(LeftHand leftHand) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return leftHand.washHand();
    }

}
