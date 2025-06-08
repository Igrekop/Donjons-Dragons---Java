package personnages.entite;
import interfacejeu.MapMilieu;

public interface entite {
    String affichageClass();
    String getAffichageCourt();
    String getAffichageLong();

    int getPosX();
    int getPosY();
    boolean setPosXY(int x, int y, MapMilieu map);
    String getNom();
    int getInitiative();
    String AfficherPVDB();
    void setPV(int degats);
    void setPosSansVerif(int x, int y);
    boolean estMonstre();
    boolean estMort();
}
