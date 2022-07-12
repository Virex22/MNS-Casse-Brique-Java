import model.Balle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Windows extends Canvas {
    //Propriétés
    //Dimensions de la fenetre
    private int largeur;
    private int hauteur;

    public Windows(int largeur, int hauteur) {

        this.largeur = largeur;
        this.hauteur = hauteur;

        //fenetre principale
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeur, hauteur));
        setBounds(0, 0, largeur, hauteur);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);

        demarrer();
    }
    private int random(int min, int max){
        int rand = (int)(Math.random() * (min + max)) + min;
        return rand;
    }

    public void demarrer() {

        ArrayList<Balle> balles = new ArrayList<Balle>();

        for (int i = 0; i < 5; i++) {
            balles.add(new Balle(this.random(1,largeur) ,1,this.random(1,hauteur),1,15,15,this.random(1,12),this.random(1,12),Color.red));
        }

        model.Rectangle rec = new model.Rectangle(100,100,200,Color.CYAN,100);

        while (true) {

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();


            dessin.setColor(Color.white);
            dessin.fillRect(0,0,largeur,hauteur);

            rec.dessiner(dessin);

            for ( Balle balle : balles) {
                balle.move(largeur,hauteur);
                balle.dessiner(dessin);
            }
            dessin.dispose();
            getBufferStrategy().show();
            try {
                Thread.sleep(1000 / 60);
            } catch (Exception e) {
            }
        }
    }
}