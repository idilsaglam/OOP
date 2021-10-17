/* (C)2021 */
package idilsaglam.td.td2;

public class Test3a {
  public static void h(C k) {
    k.setNumber(5);
  }

  public static void main(String[] args) {
    C k = new C(0);
    h(k);
    System.out.println(k);
  }
}
