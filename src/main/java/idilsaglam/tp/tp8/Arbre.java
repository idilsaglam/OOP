/* (C)2021 */
package idilsaglam.tp.tp8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Arbre {
  private final Noeud racine;

  public Arbre(Noeud racine) {
    this.racine = racine;
  }

  public Arbre(String racine) throws FileNotFoundException {
    this.racine = new Noeud(racine);
  }

  @Override
  public String toString() {
    return (this.racine == null ? "" : this.racine.toStringProfondeur(0));
  }

  public void affiche() {
    System.out.println(this);
  }

  public void traverser(String extension) {
    System.out.println("Traverser called with " + extension);
    if (this.racine == null) {
      return;
    }
    System.out.println(this.racine.traverser(extension));
  }

  public void supprimer(String extension) throws UnableToDeleteFileException {
    if (this.racine == null) return;
    this.racine.supprimer(extension);
  }

  public void map(StringTransformation<String> t) {
    if (this.racine == null) {
      return;
    }
    this.racine.map(t);
  }

  public static void main(String[] args) {

    Noeud fichier5 = new Noeud("fichier5.txt", 100, false, null);
    List<Noeud> l1 = new ArrayList<>(),
        l2 = new ArrayList<>(),
        l3 = new ArrayList<>(),
        l4 = new ArrayList<>();
    l1.add(fichier5);
    Noeud rep3 = new Noeud("rep3", 100, true, l1);
    l2.add(rep3);
    Noeud rep2 = new Noeud("rep2", 100, true, l2),
        fichier3 = new Noeud("fichier3", 0, false, null),
        fichier4 = new Noeud("fichier4.txt", 5, false, null);
    l3.add(fichier3);
    l3.add(fichier4);
    Noeud rep1 = new Noeud("rep1", 200, true, l3),
        fichier1 = new Noeud("fichier1.txt", 100, false, null),
        fichier2 = new Noeud("fichier2", 200, false, null);
    l4.add(rep1);
    l4.add(fichier1);
    l4.add(fichier2);
    l4.add(rep2);
    Noeud racine = new Noeud("racine", 15, true, l4);
    Arbre a = new Arbre(racine);
    a.affiche();
    /*
        a.map((String t) -> String.format("%s.blah", t));
        a.affiche();
    */
    a.traverser("txt");
  }

  private static class Noeud {
    private final long taille;
    private String nom;
    private boolean repertoire;
    private List<Noeud> fils;
    private File file;

    private Noeud(String nom, long taille, boolean repertoire, List<Noeud> fils) {
      this.fils = fils;
      this.nom = nom;
      this.repertoire = repertoire;
      this.taille = taille;
    }

    private Noeud(String path) throws FileNotFoundException {
      this(new File(path));
    }

    private Noeud(File file) throws FileNotFoundException {
      if (file.exists()) {
        this.nom = file.getName();
        this.taille = file.length();
        // On suppose par d??faut qu'il est un fichier
        this.fils = null;
        this.repertoire = false;
        /*
            On v??rifi?? s'il s'agit d'une r??pertoire,
            si c'est la cas on modifiera les attributs
            repertoire et fils.
        */
        if (file.isDirectory()) {
          this.repertoire = true;
          this.fils = new ArrayList<>();
          String[] child = file.list();
          /*
             Si le tableau des chemins d'acc??s du contenu de la dossier courant est nulle,
             on a plus rien ?? faire dans les constructeur on sors.
          */
          if (child == null) {
            return;
          }
          // Sinon on parcours tous les ??l??ments du repertoire est cr??es des nouveaux noeud.
          for (int i = 0; i < child.length; i++) {
            this.fils.add(new Noeud(child[i]));
          }
        }
        return;
      }
      throw new FileNotFoundException();
    }

    @Override
    public String toString() {
      return String.format("%s [%d]", this.nom, this.taille);
    }

    /**
     * On applique la fonction toString r??cursivement en respectant le profondeur dans
     * l'arborescence
     *
     * @param profondeur Le profondeur du noeud courant
     * @return Le champs de caract??re des appels toString() en respectant le profondeur
     */
    private String toStringProfondeur(int profondeur) {
      /*
      On initialise une cha??ne de caract??re avec le r??sultat de toString avec tabulation
      ajout??s en respectant le profondeur.
      */
      String res = String.format("%s%s", "\t".repeat(profondeur), this.toString());
      // On incr??mente le profondeur de 1
      profondeur++;
      if (this.repertoire) {
        /*
         S'il s'agit d'une r??pertoire on applique cette m??me fonction ?? tous les ??l??ments du r??pertoire.
        */
        for (int i = 0; i < fils.size(); i++) {
          // On concat??ne les cha??nes de caract??res obtenus au r??sultat de notre fonction.
          res += "\n" + fils.get(i).toStringProfondeur(profondeur);
        }
      }
      // On retourne le r??sultat de la fonction
      return res;
    }

    /**
     * Le m??thode map application la fonction transformation t au fils du noeud courant si le noeud
     * courant est une r??pertoire sinon au nom du fichier.
     *
     * @param t La fonction de transformation
     */
    private void map(StringTransformation<String> t) {
      // On v??rifie s'il s'agit d'une r??pertoire
      if (this.repertoire) {
        // Si c'est la cas on appelle la fonction map dans tous les fils du r??pertoire
        this.fils.forEach((Noeud n) -> n.map(t));
        return;
      }
      // Sinon on applique au nom du fichier
      this.nom = t.transf(this.nom);
    }

    /**
     * Le m??thode permets d'afficher les fichiers avec l'extension donn??e
     *
     * @param extension L'extension avec laquelle on va rechercher des fichers
     * @return Une cha??ne de caract??res contenant les affichages des noeuds avec l'extension donn??es
     */
    private String traverser(String extension) {
      // On filtre les noeuds de l'arborescence avec l'extension pass?? en param??tres
      return this.filter(extension).stream()
          // On applique ?? chacun des noeuds la m??thode toString
          .map(Noeud::toString)
          // On cr??e une cha??ne de caract??res pour avoir un repr??sentation textuel du noeud par
          // ligne.
          .reduce("", (String s1, String s2) -> String.format("%s\n%s", s1, s2))
          .trim();
    }

    /**
     * M??thode qui v??rifie que le noeud courant ?? l'extension pass?? en paramt??res
     *
     * @param extension L'extension ?? chercher
     * @return True si le noeud courant ?? l'extension pass?? en param??tres, false sinon
     */
    private boolean hasExtension(String extension) {
      if (this.repertoire) {
        return false;
      }
      String[] pn = this.nom.trim().split("\\.");
      return pn[pn.length - 1].equals(extension);
    }

    /**
     * Methode retourne les noeuds d'arborescence avec l'extension pass?? en param??tres
     *
     * @param extension L'extension avec laquelle on va rechercher les noeuds
     * @return La liste des noeuds qui ont l'extension pass?? en paramt??res
     */
    private List<Noeud> filter(String extension) {
      // V??rifions le noeud courant est une r??pertoire
      if (this.repertoire) {
        // S'il s'agit d'une r??pertoire
        return this.fils.stream()
            // Nous appliquons ?? chacun de ses ??l??ments la fonction courante
            .map((Noeud n) -> n.filter(extension))
            /*
             Nous obtenons une liste qui contient des listes de noeuds
             Nous le convertissons ?? une seule liste
            */
            .reduce(
                new ArrayList<Noeud>(),
                (List<Noeud> l1, List<Noeud> l2) -> {
                  l1.addAll(l2);
                  return l1;
                });
      }
      // S'il n'est pas une repertoire
      ArrayList<Noeud> list = new ArrayList<>();
      // On v??rifie si le noeud courant ?? l'extension pass?? en param??tres
      if (this.hasExtension(extension)) {
        // Si c'est le cas ajoutons le dans la liste
        list.add(this);
      }
      // Retournons la liste
      return list;
    }

    /**
     * M??thode qui v??rifie si un noeud est dans l'arborescence
     *
     * @param n Le noeud ?? chercher
     * @return True si le noeud pass?? en paramt??res est dans l'arborescence, false sinon
     */
    private boolean hasChild(Noeud n) {
      // V??rifions si le noeud courant s'agisse d'une r??pertoire
      if (this.repertoire) {
        // S'il s'agit r??pertoire
        return this.fils.stream()
            // Appelons sur chacun des ??l??ments le m??me m??thode
            .map(noeud -> noeud.hasChild(n))
            /*
                S'il le noeud est dans le r??pertoire,
                il doit y avoir au moins un ??l??ment de cette r??pertoire qui le contient
            */
            .reduce(false, (b1, b2) -> b1 || b2);
      }
      // S'il ne s'agit pas d'une r??pertoire, on v??rifie si le noeud est le m??me que le noeud
      // courant.
      return this.equals(n);
    }

    /**
     * M??thode retourne la liste des noeuds ?? traverser pour arriver au noeud pass?? au param??tres
     * depuis le noeud courant
     *
     * @param n Le noeud dont lequel nous cherchons
     * @return La liste des noeuds ?? traverser pour arriver ?? ce noeud
     * @throws NodeDoesNotExistsException Si le noeud n'existe pas dans l'arborescence
     */
    private List<Noeud> getPath(Noeud n) throws NodeDoesNotExistsException {

      // V??rifions si le noeud courant s'agit d'une r??pertoire
      if (this.repertoire) {
        // S'il s'agit d'une r??pertoire
        List<List<Noeud>> paths =
            this.fils.stream()
                /*
                   Nous v??rifions chacun des ??l??ments de cette r??pertoire
                   s'il contient le noeud que nous cherchons, si c'est le cas nous appliquons
                   notre fonctions sur cet ??l??ment.
                */
                .map(
                    (Noeud noeud) -> {
                      try {
                        return noeud.hasChild(n) ? noeud.getPath(n) : null;
                      } catch (NodeDoesNotExistsException e) {
                        return null;
                      }
                    })
                // Nous filtrons les nulls (qui veut dire qu'il ne contient pas le noeud pass?? en
                // param??tres)
                .filter(Objects::nonNull)
                // Nous transformons le r??sultat sous forme d'une liste
                .collect(Collectors.toList());
        /*
            Si la liste est vide ??a veut dire qu'il n'y a aucun ??l??ment du noeud
            courant qui contient le noeud pass?? en param??tres
        */
        if (paths.size() == 0) {
          // Si la liste est vide nous envoyons une exception
          throw new NodeDoesNotExistsException();
        }
        /*
            Sinon on retourne la premier ??l??ment de la liste
            (?? priori il doit avoir un seul ??l??ment dans la liste)
        */
        return paths.get(0);
      }
      /*
         S'il ne s'agit d'une r??pertoire v??rifions si
         le noeud qu'on cherche est le m??me que le noeud courant
      */
      if (this.equals(n)) {
        // Si c'est le cas nous retournons une liste vide
        return new ArrayList<Noeud>();
      }
      // Sinon on soul??ve une exception pour dire que le noeud n'existe pas
      throw new NodeDoesNotExistsException();
    }

    /**
     * M??thode renvoie une cha??ne de caract??res qui renvoie un chemin d'acc??s au noeud pass?? en
     * param??tres.
     *
     * @param n Le noeud au quel nous voulons acc??der
     * @return La cha??ne de caract??res qui contient le chemin d'acc??s au noeud pass?? en param??tres
     * @throws NodeDoesNotExistsException Si le noeud n'existe pas dans l'arborescence
     */
    private String getAccessPath(Noeud n) throws NodeDoesNotExistsException {
      // Nous r??cup??rons la liste des noeuds
      return this.getPath(n).stream()
          // Pour chaque noeud de la liste nous sortons son nom
          .map(e -> e.nom)
          // On concat??ne les noms des noeuds par des /
          .reduce(this.nom, (String s1, String s2) -> String.format("%s%s%s", s1, "/", s2));
    }

    /**
     * Methode renvoie le File pour le noeud n
     *
     * @param n Le noeud lequel nous cherchons
     * @return Le File attribu?? le noeud n
     * @throws NodeDoesNotExistsException Si le noeud n n'existe pas dans l'arborescence
     */
    private File getFile(Noeud n) throws NodeDoesNotExistsException {
      return new File(this.getAccessPath(n));
    }

    /**
     * M??thode retourne le noeud avec le chemin d'acc??s
     *
     * @param path Le chemin d'acc??s
     * @return Le noeud qui a ce chemin d'acc??s
     */
    private Noeud getNoeud(String path) {
      return this.getNoeudRec(path.split("/"), 0);
    }

    /**
     * M??thode renvoie le noeud avec le chemin d'acc??s pass?? en param??tres
     *
     * @param path Un tableau des string repr??sentatnt le path
     * @param index Un entier indiquant quel ??l??ment de tableau nous sommes
     * @return Le noeud avec le chemin d'acc??s
     */
    private Noeud getNoeudRec(String[] path, int index) {

      if (path.length == 0 || index == path.length) {
        // Si le tableau est vide ou index est ?? la fin du tableau nous sommes dans le noeud qu'on
        // recherche
        return this;
      }
      // V??rifions si c'est une r??pertoire
      if (this.repertoire) {
        // Si c'est un r??pertoire nous r??cup??rons la liste des noeuds avec le nom ?? l'index courant
        // du path
        List<Noeud> l =
            this.fils.stream().filter(e -> e.nom.equals(path[index])).collect(Collectors.toList());
        // Si cette liste est vide, aucun noeud n'existe pour ce path
        if (l.size() == 0) {
          return null;
        }
        // Sinon nous continuons ?? rechercher sur ce noeud avec
        return l.get(0).getNoeudRec(path, index + 1);
      }
      // Si ce n'est pas une r??pertoire, nous retournons null
      return null;
    }

    /**
     * M??thode supprime tous les noeuds avec l'extension pass?? en param??tres
     *
     * @param extension L'extension dont lequel nous recherchons
     * @throws UnableToDeleteFileException Si nous ne pouvons pas supprimer le noeud
     */
    private void supprimer(String extension) throws UnableToDeleteFileException {
      // Nous it??rons sur les liste des noeuds qui ont l'extension extension
      for (Noeud n : this.filter(extension)) {
        try {
          // Pour chacun des ses noeuds nous r??cup??rons le File
          File f = this.getFile(n);
          // V??rifions si nous avons les acc??s pour supprimer ce fichier
          if (f.getParentFile().canWrite()) {
            // Si on a les acc??s pour supprimer ce fichier
            // Nous enlevons le noeud de son parent
            this.getNoeud(f.getParentFile().getPath()).fils.remove(n);
            // Continuons
            continue;
          }
          // Si nous avons pas de permissions d'??criture sur son parent nous levons une exception
          throw new UnableToDeleteFileException(
              String.format(
                  "Nous avons pas permissions d'??criture dans le dossier parent %s", f.getPath()));
        } catch (NodeDoesNotExistsException ignore) {
          // Si nous avons pas trouv?? le noeud qui est bizarre mais si jamais ??a arrive nous levons
          // une exception
          throw new UnableToDeleteFileException(
              String.format("%s n'existe pas dans l'arborescence", n.nom));
        }
      }
    }
  }
}
