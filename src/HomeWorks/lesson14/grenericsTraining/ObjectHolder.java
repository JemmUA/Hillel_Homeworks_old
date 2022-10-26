package HomeWorks.lesson14.grenericsTraining;

public class ObjectHolder <I, D, S> {
    private I objectI ;
    private D objectD ;
    private S objectS ;

    public ObjectHolder(I objectI, D objectD, S objectS) {
        this.objectI = objectI;
        this.objectD = objectD;
        this.objectS = objectS;
    }

    public I getObjectI() {
        return objectI;
    }

    public void setObjectI(I objectI) {
        this.objectI = objectI;
    }

    public D getObjectD() {
        return objectD;
    }

    public void setObjectD(D objectD) {
        this.objectD = objectD;
    }
    public S getObjectS() {
        return objectS;
    }

    public void setObjectS(S objectS) {
        this.objectS = objectS;
    }

    public S sum (I varI, D varD) {
        if (varI instanceof Integer && varD instanceof Double) {
            System.out.println("Numbers");
            objectS = (S)String.valueOf((int)varI + (double)varD);
        } else if (varI instanceof String && varD instanceof String) {
            System.out.println("Strings");
            objectS = (S)(varI.toString() + varD.toString());
        } else {
            System.out.println("return null");
            return null;
        }
        return objectS;
    }

}
