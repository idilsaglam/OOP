/* (C)2021 */
package idilsaglam.tp.tp6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FigureTest {

  Rectangle rectangle;
  Carre carre;
  Triangle triangle;
  Circle circle;
  Ellipse ellipse;

  @BeforeEach
  void initFigures() {
    rectangle = new Rectangle(100.5, 50.25, 0, 0);
    carre = new Carre(22, 10, 10);
    triangle = new Triangle(42, 30, 10, 20);
    circle = new Circle(21, 99, 99);
    ellipse = new Ellipse(122, 88, 53, 43);
  }

  @Test
  void hauteurRectangle() {
    assert rectangle.getHauteur() == 50.25;
  }

  @Test
  void largeurRectangle() {
    assert rectangle.getLargeur() == 100.5;
  }

  @Test
  void afficheRectangle() {
    rectangle.affiche();
    assert rectangle
        .toString()
        .equals("Rectangle, centre (0,0), largeur: 100.500000 l'hauteur: 50.250000");
  }

  @Test
  void surfaceRectangle() {
    assert rectangle.surface() == rectangle.getHauteur() * rectangle.getLargeur();
  }

  @Test
  void deplacementRectangle() {
    rectangle.deplacement(2, 1);
    assert rectangle.getPosX() == 2 && rectangle.getPosY() == 1;
  }

  @Test
  void deformationRectangle() {
    rectangle.affiche();
    Figure rec = rectangle.deformation(0.5, 1.5);
    assert (rec instanceof Rectangle);
    assert rec.getPosX() == rectangle.getPosX();
    assert rec.getPosY() == rectangle.getPosY();
    assert ((Rectangle) rec).getHauteur() == rectangle.getHauteur() * 1.5;
    assert ((Rectangle) rec).getLargeur() == rectangle.getLargeur() * 0.5;
  }

  @Test
  void carreHauteur() {
    assert carre.getHauteur() == 22;
  }

  @Test
  void carreLargeur() {
    assert carre.getLargeur() == 22;
  }

  @Test
  void surfaceCarre() {
    assert carre.surface() == 22 * 22;
  }

  @Test
  void afficheCarre() {
    assert carre
        .toString()
        .equals("Carre, centre (10,10), largeur: 22.000000 l'hauteur: 22.000000");
  }

  @Test
  void afficheEllipse() {
    assert ellipse
        .toString()
        .equals("Ellipse, centre (53,43), Grand rayon: 122.000000 Petit rayon: 88.000000");
  }

  @Test
  void afficheCircle() {
    assert circle.toString().equals("Cercle de centre (99, 99) du rayon 21.000000");
  }

  @Test
  void afficheTriangle() {
    assert triangle
        .toString()
        .equals("Triangle du centre (10,20), base: 42.000000 et l'hauteur 30.000000");
  }
}
