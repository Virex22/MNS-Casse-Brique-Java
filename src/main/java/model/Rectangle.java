package model;

import java.awt.*;

public class Rectangle extends Sprite implements IDessinable {
    private int hauteur;

    public Rectangle(int x, int y, int largeur, Color couleur, int hauteur) {
        super(x, y, largeur, couleur);
        this.hauteur = hauteur;
    }

    @Override
    public void dessiner(Graphics2D dessin) {

        dessin.setColor(Color.black);
        dessin.fillRect(getX(),getY(),getLargeur(),getHauteur());
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
