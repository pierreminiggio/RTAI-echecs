/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import vue.Observateur;

/**
 *
 * @author pminiggio
 */
public class Jeu {
    private Piece[][] plateau;
    private Joueur j1;
    private Joueur j2;
    private Joueur nextPlayer;
    private int nbCoups;
    private boolean gagnee;
    private ArrayList<Observateur> listObservateurs;
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
    
    public Joueur getPlayer(){
        return this.nextPlayer;
    }
    
    
    private void changerPlayer(){
        this.nextPlayer=nextPlayer == j1 ? j2 : j1;
    }
    
    // a faire tour de jeu
    /*public void play(int i, int j){        
        if(this.board[i][j]==0){ 
            this.board[i][j]=getPlayer();
            this.setNbCoups(this.getNbCoups() + 1);
            avertirAllObservateurs(i,j);
            changerPlayer();               
            this.setGagnee(unVainqueur(i,j));
            if(unVainqueur(i,j)){
                avertirFinPartieAllObservateurs(true);
                nouvellePartie();
            }
            else if(this.nbCoups==9){
                avertirFinPartieAllObservateurs(false);
                nouvellePartie();
            }
        }
    }
    
    public boolean unVainqueur(int i, int j){
        return false;
    }*/
    
    
    public Jeu() {
        this(new Joueur("J1"), new Joueur("J2"));        
    }
    
    public Jeu(Joueur _j1, Joueur _j2) {
        this.j1 = _j1;
        this.j2 = _j2;
        this.nouvellePartie();
    }
    
    public void nouvellePartie() {
        this.plateau = new Piece[8][8];
        this.placerPieces();
        this.gagnee = false;
        this.nbCoups = 0;
        this.nextPlayer = j1;
        avertirNewGameAllObservateurs();
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
    
    public void affichageConsole() {
        for (int i=7; i>-1; i--) {
           for (int j=0; j<8; j++) {
               try {
                   System.out.print("-"+this.getPlateau()[i][j].getNom()+"-");
               }
               catch (NullPointerException e) {
                   System.out.print("-vide-");
               }
            }
            System.out.println("");
        }
    }
    
    public void addReplacePiece(Piece _piece, int _i, int _j) {
        this.plateau[_i][_j] = _piece;
    }
    
    public boolean deplacerPiece(int iDepart, int jDepart, int iFin, int Jfin) {
        return this.plateau[iDepart][jDepart].deplacementPossible(this.plateau, iDepart, jDepart, iFin, Jfin);
    }
    
    public void supprimerPiece(int i, int j) {
        this.plateau[i][j] = null;
    }
    
    public int getNbCoups() {
        return nbCoups;
    }

    /**
     * @param nbCoups the nbCoups to set
     */
    public void setNbCoups(int nbCoups) {
        this.nbCoups = nbCoups;
    }

    /**
     * @return the gagnee
     */
    public boolean isGagnee() {
        return gagnee;
    }

    /**
     * @param gagnee the gagnee to set
     */
    public void setGagnee(boolean gagnee) {
        this.gagnee = gagnee;
    }
    
    public void register(Observateur o){
        this.listObservateurs.add(o);
    }
    
    public void unregister(Observateur o){
        this.listObservateurs.remove(o);
    }
    
    public void avertirAllObservateurs(int i, int j){
        for(Observateur ob : this.listObservateurs)
            ob.avertir(i, j);
    } 
    
    public void avertirFinPartieAllObservateurs(boolean avecVainqueur){
        for(Observateur ob : this.listObservateurs)
            ob.avertirFinPartie(avecVainqueur);
    }
    
    public void avertirNewGameAllObservateurs(){
        for(Observateur ob : this.listObservateurs)
            ob.avertirNewGame();
    }
}
