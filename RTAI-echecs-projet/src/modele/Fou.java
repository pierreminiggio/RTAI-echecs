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
public class Fou extends Piece {
    public Fou(String _couleur) {
        super(_couleur, "test");
    }
    @Override
    public String getNom() {
        return "Fou "+this.getCouleur();
    }
}