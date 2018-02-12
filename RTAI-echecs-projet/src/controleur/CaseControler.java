/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modele.*;

/**
 *
 * @author jtrescartes
 */
public class CaseControler extends MouseAdapter{
    Jeu jeu;
    int i;
    int j;
    int iDepart;
    int jDepart;
    int iFin;
    int jFin;

    public CaseControler(int _i, int _j, Jeu mM){
        this.jeu=mM;
        i = _i;
        j = _j;
        this.resetIJ();
        
    }
    
    public void mouseClicked(MouseEvent e) {
        System.out.println(i + " " + j);
        if(this.jeu.getBoard()[i][j]==0){ 
            jeu.play(i,j);  
        }
        
    }
    
    public void resetIJ(){
        iDepart = -1;
        jDepart = -1;
        iFin = -1;
        jFin = -1;
    }
}
