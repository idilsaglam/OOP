/* (C)2021 */
package idilsaglam.tp.tp9;

import idilsaglam.tp.tp9.view.Vue;

public class Palette {
  private Vue view;

  public Palette() {
    view = new Vue();
    view.setVisible(true);
  }

  public static void main(String[] args) {
    new Palette();
  }
}
