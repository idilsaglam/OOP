/* (C)2021 */
package idilsaglam.tp.tp12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.function.Consumer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Cadre extends JFrame {

  private static final int WIDTH = 600, HEIGHT = 600;
  private static int USABLE_WIDTH, USABLE_HEIGHT;
  private final GameArea pane;
  private JPanel etiquette;

  public Cadre() {
    super.setSize(Cadre.WIDTH, Cadre.HEIGHT);
    super.setTitle("Cadre");
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setVisible(true);

    Cadre.USABLE_HEIGHT = Cadre.HEIGHT - this.getInsets().top - this.getInsets().bottom;
    Cadre.USABLE_WIDTH = Cadre.WIDTH - this.getInsets().left - this.getInsets().right;

    this.etiquette = new JPanel();
    this.pane = new GameArea();
    this.pane.finishGameListener =
        (Boolean b) -> {
          if (b) {
            this.finJeu();
          }
        };
    this.etiquette.setBounds(
        (Cadre.USABLE_WIDTH - 200) / 2, (Cadre.USABLE_HEIGHT - 200) / 2, 200, 200);
    this.etiquette.setPreferredSize(new Dimension(200, 200));
    JLabel label = new JLabel("FIN DU JEU");
    label.setForeground(Color.RED);
    label.setFont(label.getFont().deriveFont(label.getFont().getStyle() | Font.BOLD));
    label.setHorizontalAlignment(0);
    label.setVerticalAlignment(0);
    this.etiquette.add(label);
    this.etiquette.setBackground(new Color(255, 255, 255, 0));
    this.etiquette.setVisible(false);

    this.pane.add(this.etiquette);

    super.setContentPane(this.pane);
  }

  /** Déclare le fin du jeu */
  public void finJeu() {
    this.etiquette.setVisible(true);

    GameArea.finishGame();
  }

  private static class GameArea extends JPanel implements MouseInputListener, MouseMotionListener {

    private final Carre[] carres;

    private static boolean EOG = false;

    private Consumer<Boolean> finishGameListener;

    /** Déclare le fin du jeu et change le comportement du game area */
    public static void finishGame() {
      GameArea.EOG = true;
      Carre.finishGame();
    }

    public GameArea() {
      Random r = new Random();
      int nbCarres = r.nextInt(11);
      carres = new Carre[nbCarres];
      super.setSize(new Dimension(Cadre.USABLE_WIDTH, Cadre.USABLE_HEIGHT));
      super.setPreferredSize(new Dimension(Cadre.USABLE_WIDTH, Cadre.USABLE_HEIGHT));
      super.setLayout(null);
      for (int i = 0; i < nbCarres; i++) {
        // Vérifions si on peut ajouter le carré sans aucune collision
        if (addCarre(new Carre(), i)) {
          // Si c'est la cas continuons
          continue;
        }
        // Sinon revenons en arrière pour re-essayer
        i--;
      }
      super.addMouseListener(this);
      super.addMouseMotionListener(this);
    }

    /**
     * Ajoute un carré s'il ne superpose pas avec un des carrés existant
     *
     * @param c Le carré à ajouter
     * @param nbCarres Nombre de carrés existant
     * @return True si le carré est ajouté, false sinon
     */
    private boolean addCarre(Carre c, int nbCarres) {
      for (int i = 0; i < nbCarres; i++) {
        if (this.carres[i].overflowWith(c)) {
          return false;
        }
      }
      // Quand on clique sur un carré, tous les autres doit être véroillé et le carré cliqué sera
      // dévérouillé
      c.addMouseClickedListener(
          (MouseEvent event) -> {
            if (c.isLocked()) {
              this.lockAll();
            }
            c.changeLockState();
          });

      c.addMouseMovedListener(
          (Point p) -> {
            Carre uc = getUnlockedCarre();
            if (uc != null) {
              uc.setLocation(p.x, p.y);
              uc.repaint();
            }
          });

      c.addBackgroundChangeListener(
          (Color color) -> {
            if (this.gagne()) {
              this.lockAll();
              this.finishGameListener.accept(true);
            }
          });

      carres[nbCarres] = c;
      super.add(carres[nbCarres]);
      return true;
    }

    /**
     * Fonction qui vérifie si tous les carrés sont de même couleur
     *
     * @return
     */
    public boolean gagne() {
      Color c = this.carres[0].getBackground();
      for (int i = 1; i < this.carres.length; i++) {
        if (c.equals(this.carres[i].getBackground())) {
          continue;
        }
        return false;
      }
      return true;
    }

    /**
     * Retourne le seul carré qui est dévroillé, renvoie null si tous les carrés sont véroillés
     *
     * @return Le carré dévérouillé ou null s'il n'y a aucun
     */
    public Carre getUnlockedCarre() {
      for (Carre c : this.carres) {
        if (c.isLocked()) continue;
        return c;
      }
      return null;
    }

    /** Véroille tous les carrés */
    private void lockAll() {
      for (Carre c : this.carres) c.lock();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if (GameArea.EOG) System.exit(0);
      this.lockAll();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
      Carre c = this.getUnlockedCarre();
      if (c == null) {
        return;
      }
      c.setLocation(e.getX(), e.getY());
      c.repaint();
      this.repaint();
    }
  }

  private static class Carre extends JPanel implements MouseInputListener {

    private static final int X = 100, Y = 200, SIDE = 50;

    private static boolean EOG = false;

    private Consumer<MouseEvent> mouseClickListener;
    private Consumer<Point> mouseMovedListener;
    private Consumer<Color> backgroundChangeListener;
    private Point focusPoint;

    /** Déclare le fin du jeu et change le comportement de tous les carrés */
    public static void finishGame() {
      Carre.EOG = true;
    }

    private boolean locked;
    private final Model model;

    /** Crée un objet carré */
    private Carre() {
      this(new Random());
    }

    /**
     * Crée un carré avec la position et la couleur aléatoire
     *
     * @param r Objet random qui génère les nombre aléatoire
     */
    private Carre(Random r) {
      this(
          r.nextInt(Cadre.USABLE_WIDTH - Carre.SIDE),
          r.nextInt(Cadre.USABLE_HEIGHT - Carre.SIDE),
          Carre.SIDE,
          new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256)));
    }

    /**
     * Créé un objet carré avec des coordonnées et le longueur d'un côté ainsi que sa couleir
     *
     * @param x L'abscisse du coin en haut à gauche du carré
     * @param y L'ordonnée du coin en haut à gauche du carré
     * @param side Le longueur d'un côté du carré
     * @param color La couleur du carré
     */
    private Carre(int x, int y, int side, Color color) {
      this.model = new Model(color, this);
      this.locked = true;

      super.setBounds(x, y, side, side);
      super.setVisible(true);
      super.addMouseListener(this);
      super.addMouseMotionListener(this);
    }

    /**
     * Retourne si le carré est vérouillé
     *
     * @return True si le carré est vérouillé, false sinon
     */
    public boolean isLocked() {
      return this.locked;
    }

    /**
     * Vérifie si le carré courant superpose avec le carré passé en paramètres
     *
     * @param c La carré avec lequel nous allons vérifier
     */
    public boolean overflowWith(Carre c) {
      return (new Point(this.getX(), this.getY())).distance(new Point(c.getX(), c.getY()))
          < Carre.SIDE;
    }

    /**
     * Ajoute une fonction à déclencher quend l'arrière plan change
     *
     * @param backgroundChangeListener LA fonction à déclencher
     */
    public void addBackgroundChangeListener(Consumer<Color> backgroundChangeListener) {
      this.backgroundChangeListener = backgroundChangeListener;
    }

    /**
     * Ajoute une fonction à déclencher quand il y a une clique sur le souris
     *
     * @param mouseClickListener La fonction à déclencher sur le clique du souris
     */
    public void addMouseClickedListener(Consumer<MouseEvent> mouseClickListener) {
      this.mouseClickListener = mouseClickListener;
    }

    /**
     * Ajoute un fonction qui se déclenche au mouvement de souris
     *
     * @param mouseMovedListener La fonction à déclencher avec les mouvements de la souris
     */
    public void addMouseMovedListener(Consumer<Point> mouseMovedListener) {
      this.mouseMovedListener = mouseMovedListener;
    }

    /**
     * Renvoie l'attribut focus point du carré cournat
     *
     * @return L'attribut focus point
     */
    public Point getFocusPoint() {
      return this.focusPoint;
    }

    /** Change le status du véroillage du carré courant */
    public void changeLockState() {
      this.locked = !this.locked;
    }

    /** Vérouille le carée actuel */
    public void lock() {
      this.locked = true;
    }

    @Override
    public Color getBackground() {
      if (this.model == null) return super.getBackground();
      return this.model.getColor();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if (Carre.EOG) {
        System.exit(0);
      }
      this.model.setColor(Color.GREEN);
      this.mouseClickListener.accept(e);
      this.focusPoint = this.locked ? null : new Point(e.getX(), e.getY());
    }

    @Override
    public void setLocation(int x, int y) {
      if (!this.locked) {
        int nX = x - (this.getX() + this.focusPoint.x), nY = y - (this.getY() + this.focusPoint.y);
        super.setLocation(this.getX() + nX, this.getY() + nY);
      }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
      this.model.setColor(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
      this.mouseMovedListener.accept(new Point(this.getX() + e.getX(), this.getY() + e.getY()));
    }

    @Override
    public void setBackground(Color c) {
      super.setBackground(c);
      if (backgroundChangeListener == null) {
        return;
      }
      this.backgroundChangeListener.accept(c);
    }
  }

  private static class Model {
    private Color color;
    private final Carre carre;

    public Model(Color color, Carre carre) {
      this.carre = carre;
      this.setColor(color);
    }

    /**
     * Renvoie le couleur du modele
     *
     * @return La couleur du modèle
     */
    public Color getColor() {
      return this.color;
    }

    /**
     * Mets à jour le couleur du modèle ainsi que celui du controlleur
     *
     * @param c
     */
    public void setColor(Color c) {
      this.color = c;
      this.carre.setBackground(this.color);
      this.carre.repaint();
    }
  }
}
