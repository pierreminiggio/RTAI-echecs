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
public class Tour extends Piece {
    public Tour(String _couleur) {
        super(_couleur, "test");
    }
    @Override
    public String getNom() {
        return "Tour "+this.getCouleur();
    }
    
    @Override
    public boolean deplacementPossible(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        return deplacementPossibleLigne(plateau, iDepart, jDepart, iFin, jFin);
    }
}
