package td.td1;

public class Compte {
    private int solde;
    public static int numero =0;
    int id;

    public Compte(){
        this.id++;
        this.numero=id;
    }

    public int getSolde(){
        return this.solde;
    }

    public void crediter(int montant){
        this.solde += montant;
    }

    public void debiter(int montant){
        this.solde -= montant;
    }

}
