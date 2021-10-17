/* (C)2021 */
package idilsaglam.td.td2;

public class Test2 {
  public static int g(int i) {
    i += 1;
    return i;
  }

  public static void main(String[] args) {
    int i = 0;
    g(i);
    System.out.println(i);
  }
}
