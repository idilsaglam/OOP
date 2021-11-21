package idilsaglam.tp.tp8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Arbre {
    private final Noeud racine;


    public Arbre(Noeud racine){ this.racine = racine;}


    public Arbre(String racine) throws FileNotFoundException {
        this.racine = new Noeud(racine);
    }

    @Override
    public String toString(){
        return (this.racine==null?"":this.racine.toStringProfondeur(0));
    }

    public void affiche(){
        System.out.println(this);
    }
    private static class Noeud{
        private String nom;
        private long taille;
        private boolean repertoire;
        private ArrayList<Noeud> fils;

        private Noeud(String nom, int taille, boolean repertoire, ArrayList<Noeud> fils){
            this.fils = fils;
            this.nom = nom;
            this.repertoire = repertoire;
            this.taille = taille;
        }

        private Noeud (String path) throws FileNotFoundException {
            this(new File(path));
        }

        private Noeud(File file) throws FileNotFoundException {
            if(file.exists()){
                this.nom = file.getName();
                this.taille = file.length();
                // On suppose par défaut qu'il est un fichier
                this.fils = null;
                this.repertoire = false;
                /*
                    On vérifié s'il s'agit d'une répertoire,
                    si c'est la cas on modifiera les attributs
                    repertoire et fils.
                */
                if(file.isDirectory()) {
                    this.repertoire = true;
                    this.fils = new ArrayList<>();
                    String[] child = file.list();
                    /*
                        Si le tableau des chemins d'accès du contenu de la dossier courant est nulle,
                        on a plus rien à faire dans les constructeur on sors.
                     */
                    if(child==null){
                        return;
                    }
                    // Sinon on parcours tous les éléments du repertoire est crées des nouveaux noeud.
                    for(int i=0; i<child.length; i++){
                        this.fils.add(new Noeud(child[i]));
                    }
                }
                return;
            }
            throw new FileNotFoundException();
        }

        @Override
        public String toString(){
            return String.format("%s [%d]",this.nom,this.taille);
        }

        private String toStringProfondeur(int profondeur){
            String res = String.format("%s%s","\t".repeat(profondeur),this.toString());
            profondeur++;
            if(this.repertoire){
                for(int i=0; i<fils.size();i++){
                    res += "\n"+fils.get(i).toStringProfondeur(profondeur);
                }
            }
            return res;
        }

        private void map(StringTransformation<String> t) {
          if (this.repertoire) {
              this.fils.forEach((Noeud n)->n.map(t));
              return;
          }
          this.nom = t.transf(this.nom);
        }

        private String traverser(String extension){
          if (this.repertoire) {
              this.fils.stream()
                      .map(noeud -> noeud.traverser(extension))
                      .filter(s -> s.length()!=0)
                      .reduce((String s1, String s2)-> {

                      })

          }
          if(this.nom.trim().matches(String.format("\\.%s$",extension))){
              return this.toString();
          }
          return "";
        }
    }
}
