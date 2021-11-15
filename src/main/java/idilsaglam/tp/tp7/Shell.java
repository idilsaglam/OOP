/* (C)2021 */
package idilsaglam.tp.tp7;

import java.io.InputStream;
import java.util.Scanner;

public class Shell {

  private Dossier dossierCourant, dossierRacine;

  public Shell(Dossier dossier) {
    this.dossierCourant = dossier;
    this.dossierRacine = dossier;
  }

  public Dossier getDossierCourant() {
    return this.dossierCourant;
  }

  public void setDossierCourant(Dossier d) {
    this.dossierCourant = d;
  }

  public Dossier getDossierRacine() {
    return this.dossierRacine;
  }

  public void setDossierRacine(Dossier d) {
    this.dossierRacine = d;
  }

  public void interagir(InputStream in) {
    Scanner sc = new Scanner(in);
    String line;
    CommandeShell command = null;
    while (true) {
      line = sc.nextLine();
      if (line.equals("quit")) {
        System.exit(0);
      }
      if (line.equals("help")) {
        CommandeCat.aide();
        CommandeCd.aide();
        CommandeEd.aide();
        CommandeLs.aide();
        CommandeMkdir.aide();
        CommandeMv.aide();
        CommandeRm.aide();
        System.out.println("help");
        System.out.println("quit");
        continue;
      }
      String[] splittedLine = line.trim().split(" ");
      if (splittedLine[0].equals("cd")) {
        command =
            new CommandeCd(this.dossierCourant, line.replaceAll("^cd ", "").trim().split(" "));
        Dossier d = command.executer();
        if (d != null) this.dossierCourant = d;
        continue;
      }
      ;
      String[] args = new String[splittedLine.length - 1];
      System.arraycopy(splittedLine, 1, args, 0, splittedLine.length - 1);
      command =
          (switch (splittedLine[0]) {
            case "ed" -> new CommandeEd(this.dossierCourant, args, sc, (in != System.in));
            case "rm" -> new CommandeRm(this.dossierCourant, args);
            case "cat" -> new CommandeCat(this.dossierCourant, args);
            case "ls" -> new CommandeLs(this.dossierCourant, args);
            case "mkdir" -> new CommandeMkdir(this.dossierCourant, args);
            case "mv" -> new CommandeMv(this.dossierCourant, args);
            default -> null;
          });
      if (command == null) {
        continue;
      }
      command.executer();
    }
  }
}
