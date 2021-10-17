/* (C)2021 */
package idilsaglam.td.td1;

public abstract class Main {
  public static void main(String[] args) {
    Personne tony = new Personne("Parker", "Tony", 29, 3);
    System.out.println(tony);
    Personne mickael = tony;
    mickael.setPrenom("Mickael");
    System.out.println(tony);
  }
}
