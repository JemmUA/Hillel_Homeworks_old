package HomeWorks.lesson22.deadLockHands;

public class LeftHand {
    private RightHand rightHand;

    public RightHand getRightHand() {
        return rightHand;
    }

    public void setRightHand(RightHand rightHand) {
        this.rightHand = rightHand;
    }

    public synchronized String washHand() {
        return "Left hand wash right hand";
    }

    public synchronized String washRightHand(RightHand rightHand) {
        return rightHand.washHand();
    }
}
