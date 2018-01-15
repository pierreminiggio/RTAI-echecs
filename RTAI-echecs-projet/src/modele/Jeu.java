/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author pminiggio
 */
public class Jeu {
    private Piece[][] plateau;
    private Joueur j1;
    private Joueur j2;
    /**
     * @return the plateau
     */
    public Piece[][] getPlateau() {
        return plateau;
    }

    /**
     * @param plateau the plateau to set
     */
    public void setPlateau(Piece[][] plateau) {
        this.plateau = plateau;
    }

    /**
     * @return the j1
     */
    public Joueur getJ1() {
        return j1;
    }

    /**
     * @param j1 the j1 to set
     */
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    /**
     * @return the j2
     */
    public Joueur getJ2() {
        return j2;
    }

    /**
     * @param j2 the j2 to set
     */
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    } 
    
    
    public Jeu(Joueur _j1, Joueur _j2) {
        this.j1 = _j1;
        this.j2 = _j2;
        this.plateau = new Piece[8][8];
        this.placerPieces();
    }

    private void placerPieces() {
        this.placerPions();
        this.placerTours();
        this.placerCavaliers();
        this.placerFous();
        this.placerReines();
        this.placerRois();
    }

    private void placerPions() {
        for (int j=0; j<8; j++) {
            this.plateau[1][j] = new Pion("blanc");
            this.plateau[6][j] = new Pion("noir"); 
        }
    }
    
    private void placerTours() {
        this.plateau[0][0] = new Tour("blanc");
        this.plateau[0][7] = new Tour("blanc");
        this.plateau[7][0] = new Tour("noir");
        this.plateau[7][7] = new Tour("noir"); 
    }

    private void placerCavaliers() {
        this.plateau[0][1] = new Cavalier("blanc");
        this.plateau[0][6] = new Cavalier("blanc");
        this.plateau[7][1] = new Cavalier("noir");
        this.plateau[7][6] = new Cavalier("noir"); 
    }

    private void placerFous() {
        this.plateau[0][2] = new Fou("blanc");
        this.plateau[0][5] = new Fou("blanc");
        this.plateau[7][2] = new Fou("noir");
        this.plateau[7][5] = new Fou("noir"); 
    }

    private void placerReines() {
        this.plateau[0][3] = new Reine("blanc");
        this.plateau[7][3] = new Reine("noir");
    }
    
    private void placerRois() {
        this.plateau[0][4] = new Roi("blanc");
        this.plateau[7][4] = new Roi("noir");
    }
    
    public void addReplacePiece(Piece _piece, int _i, int _j) {
        this.plateau[_i][_j] = _piece;
    }

    
}
