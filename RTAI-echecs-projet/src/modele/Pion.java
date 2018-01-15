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
public class Pion extends Piece {
    
    
    public Pion(String _couleur) {
        super(_couleur, "test");
    }
    
    @Override
    public String getNom() {
        return "Pion "+this.getCouleur();
    }
    
    @Override
    public boolean deplacementPossible(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        int un = 1;
        int deux = 2;
        int depart = 1;
        if (this.couleur.equals("blanc")) {
            un = 1;
            deux = 2;
            depart = 1;
            
        }
        //déplacement 1 case
            if (iDepart+un == iFin && jDepart == jFin && this.caseOccupe(plateau, iFin, jFin) == false) {
                return true;
            }
            
            //déplacement 2 cases
            else if (iDepart == depart && iDepart+deux == iFin && jDepart == jFin && this.caseOccupe(plateau, iFin, jFin) == false && this.caseOccupe(plateau, iFin-un, jFin) == false) {
                return true;
            }
            
            //manger en diagonale droite
            else if (iDepart+un == iFin && jDepart+1 == jFin && this.caseOccupe(plateau, iFin, jFin) == true) {
                return true;
            }
            
            //manger en diagonale gauche
            else if (iDepart+un == iFin && jDepart-1 == jFin && this.caseOccupe(plateau, iFin, jFin) == true) {
                return true;
            }
            
        return false;
    }
}
