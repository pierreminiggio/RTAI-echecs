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
public abstract class Piece {
    public String couleur;
    private String lienImg;

    
    public Piece(String _couleur, String _lienImg) {
        this.couleur = _couleur;
        this.lienImg = _lienImg;
        
    }
     /**
     * @return the couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the lienImg
     */
    public String getLienImg() {
        return lienImg;
    }

    /**
     * @param lienImg the lienImg to set
     */
    public void setLienImg(String lienImg) {
        this.lienImg = lienImg;
    }
    
    public String getNom() {
        return "Piece "+this.getCouleur();
    }
    
    public boolean caseOccupe(Piece[][] plateau, int _i, int _j) {
        try {
            if (plateau[_i][_j].getNom() == null) {
                
            }
            return true;
        }
        catch (NullPointerException e) {
            return false;
        }
    }
    
    public boolean deplacementPossible(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        return false;
    }
}
