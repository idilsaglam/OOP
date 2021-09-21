package td.td1;

public class Personne {
    private String nom;
    private String prenom;
    public int age;
    private int monnaie;

    public Personne(String nom,String prenom,int age,int monnaie){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.monnaie = monnaie;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void anniversaire(){
        this.age++;
    }

    public String toString(){
        return "Je m'appelle : "+this.prenom+" "+this.nom+" J'ai "+this.age+" ans.";
    }
}
