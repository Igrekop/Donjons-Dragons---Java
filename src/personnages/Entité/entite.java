package personnages.Entité;
import interfacejeu.map_milieu;

public interface entite {
    String affichageClass();
    String getAffichageCourt();
    String getAffichageLong();

    int getPosX();
    int getPosY();
    boolean setPosXY(int x, int y, map_milieu map);
    String getNom();
    int getInitiative();
    String AfficherPVDB();
    void setPV(int degats);
    void setPosSansVerif(int x, int y);
    boolean estMonstre();
    boolean estMort();
}
