package tp.tp4;

/**
 * Exercice 5.1
 * Avec le Java 8 nous pouvons réaliser cette question par une interface fonctionnelle (FunctionalInterface)
 * De cette manière nous ne sont pas obligé de définir une définition par défaut à cette fonction. Nous avons pu utiliser
 * une classe abstraite aussi, mais comme il y aura une unique fonction on peut s'en sortir avec une interface fonctionnelle.
 */
interface Predicat {
     boolean estVrai(Media m);
}
