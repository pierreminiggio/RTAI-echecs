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
        String couleurManger = "blanc";
        if (this.couleur.equals("blanc")) {
            un = 1;
            deux = 2;
            depart = 1;
            couleurManger = "noir";
            
        }
        else if (this.couleur.equals("noir")){
            un = -1;
            deux = -2;
            depart = 6;
            couleurManger = "blanc";
        }
        //déplacement 1 case
            if (iDepart+un == iFin && jDepart == jFin && "vide".equals(this.caseOccupe(plateau, iFin, jFin))) {
                this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                return true;
            }
            
            //déplacement 2 cases
            else if (iDepart == depart && iDepart+deux == iFin && jDepart == jFin && "vide".equals(this.caseOccupe(plateau, iFin, jFin)) && "vide".equals(this.caseOccupe(plateau, iFin-un, jFin))) {
                this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                return true;
            }
            
            //manger en diagonale droite
            else if (iDepart+un == iFin && jDepart+1 == jFin && this.caseOccupe(plateau, iFin, jFin).equals(couleurManger)) {
                this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                return true;
            }
            
            //manger en diagonale gauche
            else if (iDepart+un == iFin && jDepart-1 == jFin && this.caseOccupe(plateau, iFin, jFin).equals(couleurManger)) {
                this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                return true;
            }
            // à faire : prise en passant :
            
        return false;
    }
}
