package personnages.Entité;
import
import interfacejeu.map_milieu;

public interface entite {
    String affichageClass();
    String getAffichageCourt();
    String getAffichageLong();

    int getPosX();
    int getPosY();
    boolean setPosXY(int x, int y, map_milieu map);
    String getNom();
}
