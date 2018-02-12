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
public class Roi extends Piece {
    public Roi(String _couleur) {
        super(_couleur, "test");
    }
    @Override
    public String getNom() {
        return "Roi "+this.getCouleur();
    }
    
    @Override
    public boolean deplacementPossible(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        if ((iDepart == iFin+1 || iDepart == iFin-1) && (jDepart == jFin+1 || jDepart == jFin-1)) {
            if (deplacementPossibleLigne(plateau, iDepart, jDepart, iFin, jFin) == true) {
                return true;
            }
            else if (deplacementPossibleDiagonale(plateau, iDepart, jDepart, iFin, jFin) == true) {
                return true;
            }
            else {
                return false;
            }
        }
        
        //rock à faire
        
        else {
            return false;
        }
    }
}