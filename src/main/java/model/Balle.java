package model;

import java.awt.*;

public class Balle extends Sprite implements IDessinable{
    private int dx = 1;
    private int dy = 1;
    private int ballSizeY = 15;
    private int speedX = 3;
    private int speedY = 2;



    public Balle(int x, int dx, int y, int dy, int ballSizeX, int ballSizeY, int speedX, int speedY, Color color) {
        super(x,y,ballSizeX,color);
        this.ballSizeY = ballSizeY;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public Balle() {
        super(0,0,15,Color.red);
        this.dx = 1;
        this.dy = 1;
        this.ballSizeY = 15;
        this.speedX = 4;
        this.speedY = 3;
    }

    public void move(int largeur,int hauteur){
        if (getX() > largeur - getLargeur()) dx = -1;
        if (getX() < 0) dx = 1;
        if (getY() > hauteur - ballSizeY) dy = -1;
        if (getY()  < 0) dy = 1;

        setX(getX() + dx * speedX);
        setY(getY() + dy * speedY);
    }
    public void dessiner(Graphics2D dessin){
        dessin.setColor(getCouleur());
        dessin.fillOval(getX(),getY() ,getLargeur() ,getBallSizeY());
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }


    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }


    public int getBallSizeY() {
        return ballSizeY;
    }

    public void setBallSizeY(int ballSizeY) {
        this.ballSizeY = ballSizeY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }


}
