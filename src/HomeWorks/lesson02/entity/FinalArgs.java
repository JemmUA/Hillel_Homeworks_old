package HomeWorks.lesson02.entity;

// Final classes can't be inheritanced. Final methods can't be overrided.
// Final variables make setter method pointless.
final public class FinalArgs {
    final int x, y, z; // Not initialized final variables at once -  MUST be initialized in constructor!


    // Constructors
    public FinalArgs () {
        x = 10;
        y = 20;
        z = 30;
    }

    public FinalArgs(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    // Getters, setters

/*    public setX(int x) {
        this.x = x;
    }
    public setX(int y) {
        this.y = y;
    }
    public setX(int z) {
        this.z = z;
    }*/

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() {
        return z;
    }

}
