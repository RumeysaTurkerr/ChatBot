package chatbot;

/*
 * This is a type definition for Televizyon that extends Product.
 */
public class Televizyon extends Product {

    /*instance variables*/
    private String tEkranBoyutu;
    private String tEkranTuru;
    private String goruntuKalitesi;

    /*constructor*/
    public Televizyon(int pid, String brand, String model, String tEkranBoyutu, String tEkranTuru, String goruntuKalitesi) {
        super(pid, brand, model);
        this.tEkranBoyutu = tEkranBoyutu;
        this.tEkranTuru = tEkranTuru;
        this.goruntuKalitesi = goruntuKalitesi;
    }

    /*setters and getters*/
    public String gettEkranBoyutu() {
        return tEkranBoyutu;
    }

    public void settEkranBoyutu(String tEkranBoyutu) {
        this.tEkranBoyutu = tEkranBoyutu;
    }

    public String gettEkranTuru() {
        return tEkranTuru;
    }

    public void settEkranTuru(String tEkranTuru) {
        this.tEkranTuru = tEkranTuru;
    }

    public String getGoruntuKalitesi() {
        return goruntuKalitesi;
    }

    public void setGoruntuKalitesi(String uyduAlıcı) {
        this.goruntuKalitesi = goruntuKalitesi;
    }

    /*toString*/
    @Override
    public String toString() {
        return "Televizyon{" + "tEkranBoyutu=" + tEkranBoyutu + ", tEkranTuru=" + tEkranTuru + ", goruntuKalitesi=" + goruntuKalitesi + '}';
    }

}
