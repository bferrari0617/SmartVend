public class Snack extends Product {
    private String nutritionalInfo;

    public Snack(String name, String id, float price, String nutritionalInfo) {
        super(name, id, price);
        this.nutritionalInfo = nutritionalInfo;
    }

    public String getNutritionalInfo() {
        return nutritionalInfo;
    }
}