package chatbot;

/*
*This is a Product base class.
 */
public class Product {

    /*instance variables*/
    private int pId;
    private String pBrand;
    private String pModel;

    /*constructor*/
    public Product(int pId, String pBrand, String pModel) {
        super();
        this.pId = pId;
        this.pBrand = pBrand;
        this.pModel = pModel;
    }

    /*setters and getters*/
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpModel() {
        return pModel;
    }

    public void setpModel(String pModel) {
        this.pModel = pModel;
    }

    /*toString*/
    @Override
    public String toString() {
        return "Product [pId=" + pId + ", pBrand=" + pBrand + ", pModel=" + pModel + "]";
    }

}
