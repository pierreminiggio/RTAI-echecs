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
public class Cavalier extends Piece {
    public Cavalier(String _couleur) {
        super(_couleur, "test");
    }
    @Override
    public String getNom() {
        return "Cavalier "+this.getCouleur();
    }
    
    @Override
    public boolean deplacementPossible(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        if (((iDepart == iFin+1 || iDepart == iFin-1) && (jDepart == jFin+2 || jDepart == jFin-2)) || ((iDepart == iFin+2 || iDepart == iFin-2) && (jDepart == jFin+1 || jDepart == jFin-1))) {
                if (!this.caseOccupe(plateau, iFin, jFin).equals(this.couleur) ) {
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
            }

        return false;
    }
}
