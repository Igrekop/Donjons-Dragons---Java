package inter_face;

public class Case {
    private ContenuCase contenu;

    public Case() {
        this.contenu = null;
    }

    public ContenuCase getContenu() {
        return contenu;
    }

    public void setContenu(ContenuCase contenu) {
        this.contenu = contenu;
    }

    public boolean estVide() {
        return contenu == null;
    }

    public boolean estEquipement() {
        return "Equipement".equals(contenu.getTypeContenu());
    }

    public boolean accessibleParJoueur() {
        return estVide() || estEquipement();
    }

    public String afficher() {
        return estVide() ? " . " : contenu.afficher();
    }
}
