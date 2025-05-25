package personnages.Entité;

public interface entite {
    String affichageClass();
    String getAffichageCourt();
    String getAffichageLong();

    int getPosX();
    int getPosY();
    void setPosXY(int x, int y);
    String getNom();
}
