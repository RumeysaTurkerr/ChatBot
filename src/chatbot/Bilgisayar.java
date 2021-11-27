package chatbot;

/*
 * This is a type definition for Bilgisayar that extends Product.
 */

public class Bilgisayar extends Product {

    /*instance variables*/
    private String bIslemciTipi;
    private String bRam;
    private String bHarddisk;
    private String bEkranBoyutu;

    /*constructor*/
    public Bilgisayar(int pid, String brand, String model, String bIslemciTipi, String bRam, String bHarddisk, String bEkranBoyutu) {

        super(pid, brand, model);
        this.bIslemciTipi = bIslemciTipi;
        this.bRam = bRam;
        this.bHarddisk = bHarddisk;
        this.bEkranBoyutu = bEkranBoyutu;
    }

    /*setters and getters*/
    public String getbIslemciTipi() {
        return bIslemciTipi;
    }

    public void setbIslemciTipi(String bIslemciTipi) {
        this.bIslemciTipi = bIslemciTipi;
    }

    public String getbRam() {
        return bRam;
    }

    public void setbRam(String bRam) {
        this.bRam = bRam;
    }

    public String getbHarddisk() {
        return bHarddisk;
    }

    public void setbHarddisk(String bHarddisk) {
        this.bHarddisk = bHarddisk;
    }

    public String getbEkranBoyutu() {
        return bEkranBoyutu;
    }

    public void setbEkranBoyutu(String bEkranBoyutu) {
        this.bEkranBoyutu = bEkranBoyutu;
    }

    /*toString*/
    @Override
    public String toString() {
        return super.toString() + "bIslemciTipi=" + bIslemciTipi + ", bRam=" + bRam + ", bHarddisk=" + bHarddisk + ", bEkranBoyutu=" + bEkranBoyutu + '}';
    }

}
