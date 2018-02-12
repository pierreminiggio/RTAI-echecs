/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author jtrescartes
 */
public class EchecsModel {
    private int [][] board;
    private int nextPlayer;
    private int nbCoups;
    private boolean gagnee;
    private ArrayList<Observateur> listObservateurs;
    
    public EchecsModel(){        
        this.listObservateurs=new ArrayList<Observateur>();
         nouvellePartie();
    }
      
    public void nouvellePartie(){
        this.setBoard(new int[8][8]);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.board[i][j]=0;
            }
        }  
        this.setGagnee(false);
        this.setNbCoups(0);
        this.nextPlayer=1;
        avertirNewGameAllObservateurs();
    }
    
    int getPlayer(){
        return this.nextPlayer;
    }
    
    private void changerPlayer(){
        this.nextPlayer=nextPlayer == 1 ? 2 : 1;
    }
    
    public void play(int i, int j){        
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
        boolean one, two, three, four;
        one=((this.board[i][0] == this.board[i][1]) && this.board[i][1] == this.board[i][2]);
        two=(this.board[0][j] == this.board[1][j] && this.board[1][j] == this.board[2][j]);
        three=(i == j	
                && this.board[0][0] == this.board[1][1]
                && this.board[1][1] == this.board[2][2]);
        four=(i + j == 2	
                && this.board[0][2] == this.board[1][1]
                && this.board[1][1] == this.board[2][0]);
        
        return one || two || three || four;
    }
    
    int getCase(int i, int j){
        return this.board[i][j];
    }

    @Override
    public String toString() {
        return "MorpionModel{" + "board=" + Arrays.toString(this.board) + ", nextPlayer=" + this.nextPlayer + ", nbCoups=" + this.getNbCoups() + '}';
    }

    /**
     * @return the board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * @return the nbCoups
     */
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
