package tp.tp4;

public class Film extends Media{
    private int duree;
    private String productrice;
    private String langue;

    public Film(int duree, String productrice, String langue, String nom){
        super(nom);
        this.duree = duree;
        this.langue = langue;
        this.productrice = productrice;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getProductrice() {
        return productrice;
    }

    public void setProductrice(String productrice) {
        this.productrice = productrice;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }


}
