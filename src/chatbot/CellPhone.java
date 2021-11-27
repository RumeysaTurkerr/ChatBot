package chatbot;

/*
 * This is a type definition for CellPhone that extends Product.
 */
public class CellPhone extends Product {

    /*instance variables*/
    private int cameraSize;
    private String ramSize;

    /*constructor*/
    public CellPhone(int pid, String brand, String model, int cameraSize, String ramSize) {
        super(pid, brand, model);
        this.cameraSize = cameraSize;
        this.ramSize = ramSize;
    }

    /*setters and getters*/
    public int getCameraSize() {
        return cameraSize;
    }

    public void setCameraSize(int cameraSize) {
        this.cameraSize = cameraSize;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    /*toString*/
    @Override
    public String toString() {
        return super.toString() + " --CellPhone [cameraSize=" + cameraSize + ", ramSize=" + ramSize + "]";
    }

}
