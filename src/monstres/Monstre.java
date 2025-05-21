package monstres;

import interfacejeu.ContenuCase;
import personnages.Affichable.affichable;
import personnages.Joueur;

public abstract class Monstre implements ContenuCase, affichable {
    private String m_espece;
    private int m_numero;
    private int m_pointDeVie;
    private int m_force;
    private int m_dexterite;
    private int m_initiative;
    private int m_classeArmure;
    private String m_typeAttaque;
    private int m_portee;
    private String m_degats;
    private int posX;
    private int posY;


    public Monstre(String espece, int numero, int pointDeVie, int force, int dexterite, int initiative,
                   int classeArmure, String typeAttaque, int portee, String degats) {
        m_espece = espece;
        m_numero = numero;
        m_pointDeVie = pointDeVie;
        m_force = force;
        m_dexterite = dexterite;
        m_initiative = initiative;
        m_classeArmure = classeArmure;
        m_typeAttaque = typeAttaque;
        m_portee = portee;
        m_degats = degats;
    }

    public abstract void attaquer(Joueur cible);

    @Override
    public String toString() {
        return m_espece + " #" + m_numero + " [PV: " + m_pointDeVie + ", Attaque: " + m_typeAttaque +
                ", Dégâts: " + m_degats + ", Portée: " + m_portee + "]";
    }

    public int getPointDeVie() {
        return m_pointDeVie;
    }

    public abstract int getPvDeBase();

    public String getDegats() {
        return m_degats;
    }

    public int getForce() {
        return m_force;
    }

    public int getPortee() {
        return m_portee;
    }

    public String getTypeAttaque() {
        return m_typeAttaque;
    }

    public String getEspece() {
        return m_espece;
    }

    public int getNumero() {
        return m_numero;
    }

    public int getDexterite() {
        return m_dexterite;
    }

    /**
     * Réduit les points de vie du monstre.
     * @param degatsSubis points de vie à soustraire (doit être positif)
     * @return points de vie restants
     */
    public int subirDegats(int degatsSubis) {
        if (degatsSubis < 0) {
            throw new IllegalArgumentException("Les dégâts subis doivent être positifs");
        }
        m_pointDeVie -= degatsSubis;
        if (m_pointDeVie < 0) {
            m_pointDeVie = 0;
        }
        return m_pointDeVie;
    }

    public int getClasseArmure() {
        return m_classeArmure;
    }

    public int getInitiative() {
        return m_initiative;
    }

    public boolean estMort() {
        if (this.getPointDeVie() <= 0) {
            return true;
        }
        else {return false;}
    }

    public int getPosX() {return this.posX;
    }

    public int getPosY() {return this.posY;
    }

    public void setPosXY(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public abstract String afficher();

    @Override
    public String getTypeContenu() {
        return "Monstre";
    }

    @Override
    public String affichageClass(){
        return getClass().toString();
    }

    @Override
    public String getAffichageCourt() {
        return afficher();
    }

    @Override
    public String getAffichageLong() {
        return getEspece() + " (" + getPointDeVie() + "/" + getPvDeBase() + " HP)";
    }






}
