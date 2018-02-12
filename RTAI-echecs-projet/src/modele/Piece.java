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
    
    public String caseOccupe(Piece[][] plateau, int _i, int _j) {
        try {
            if (plateau[_i][_j].getCouleur() == null) {
                
            }
            return plateau[_i][_j].getCouleur();
        }
        catch (NullPointerException e) {
            return "vide";
        }
    }
    
    public boolean deplacementPossible(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        return false;
    }
    
    public void deplacementPiece(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        plateau[iFin][jFin] = plateau[iDepart][jDepart];
        this.supprimerPiece(plateau, iDepart, jDepart);
        
    }
    
    public void supprimerPiece(Piece[][] plateau, int i, int j) {
        plateau[i][j] = null;
    }
    
    public boolean deplacementPossibleLigne(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        String couleurManger = "blanc";
        if (this.couleur.equals("blanc")) {
            couleurManger = "noir";   
        }
        else if (this.couleur.equals("noir")) {
            couleurManger = "blanc";   
        }
            //déplacement/manger vers le haut/bas
            if (jDepart == jFin && iDepart != iFin && !this.caseOccupe(plateau, iFin, jFin).equals(this.couleur)){
                if (iDepart < iFin) {
                    for(int i=iDepart; i<iFin-1; i++) {
                        if (this.caseOccupe(plateau, i, jFin).equals(this.couleur) || this.caseOccupe(plateau, i, jFin).equals(couleurManger)) {
                            return false;
                        }
                    }
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
                else if (iDepart > iFin) {
                   for(int i=iDepart; i>iFin+1; i--) {
                        if (this.caseOccupe(plateau, i, jFin).equals(this.couleur) || this.caseOccupe(plateau, i, jFin).equals(couleurManger)) {
                            return false;
                        }
                    }
                   this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                   return true;
                }
               
                
            }
            
            //déplacement/manger vers la droite/gauche
            if (iDepart == iFin && jDepart != jFin && !this.caseOccupe(plateau, iFin, jFin).equals(this.couleur)){
                if (jDepart < jFin) {
                    for(int j=jDepart; j<jFin-1; j++) {
                        if (this.caseOccupe(plateau, iFin, j).equals(this.couleur) || this.caseOccupe(plateau, iFin, j).equals(couleurManger)) {
                            return false;
                        }
                    }
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
                else if (jDepart > jFin) {
                   for(int j=jDepart; j>jFin+1; j--) {
                        if (this.caseOccupe(plateau, iFin, j).equals(this.couleur) || this.caseOccupe(plateau, iFin, j).equals(couleurManger)) {
                            return false;
                        }
                    }
                   this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                   return true;
                }
               
                
            }
            
            
        return false;
    }
    
     public boolean deplacementPossibleDiagonale(Piece[][] plateau, int iDepart, int jDepart, int iFin, int jFin) {
        String couleurManger = "blanc";
        if (this.couleur.equals("blanc")) {
            couleurManger = "noir";   
        }
        else if (this.couleur.equals("noir")) {
            couleurManger = "blanc";   
        }
            // à faire déplacement des fous, copié de la tour
            if (jFin - jDepart == iFin - iDepart  && !this.caseOccupe(plateau, iFin, jFin).equals(this.couleur)){
                if (iDepart < iFin) {
                    for(int i=iDepart; i<iFin-1; i++) {
                        for(int j=jDepart; j<jFin-1; j++) {
                            if (this.caseOccupe(plateau, i, j).equals(this.couleur) || this.caseOccupe(plateau, i, j).equals(couleurManger)) {
                            return false;
                        }
                        
                        }
                    }
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
                else if (iDepart > iFin) {
                    for(int i=iDepart; i>iFin-1; i--) {
                        for(int j=jDepart; j<jFin-1; j--) {
                            if (this.caseOccupe(plateau, i, j).equals(this.couleur) || this.caseOccupe(plateau, i, j).equals(couleurManger)) {
                            return false;
                        }
                        
                        }
                    }
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
               
                
            }
            else if (jFin - jDepart == -(iFin - iDepart)  && !this.caseOccupe(plateau, iFin, jFin).equals(this.couleur)){
                if (iDepart < iFin) {
                    for(int i=iDepart; i<iFin-1; i++) {
                        for(int j=jDepart; j<jFin-1; j--) {
                            if (this.caseOccupe(plateau, i, j).equals(this.couleur) || this.caseOccupe(plateau, i, j).equals(couleurManger)) {
                            return false;
                        }
                        
                        }
                    }
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
                else if (iDepart > iFin) {
                    for(int i=iFin; i>iDepart-1; i--) {
                        for(int j=jDepart; j<jFin-1; j++) {
                            if (this.caseOccupe(plateau, i, j).equals(this.couleur) || this.caseOccupe(plateau, i, j).equals(couleurManger)) {
                            return false;
                        }
                        
                        }
                    }
                    this.deplacementPiece(plateau, iDepart, jDepart, iFin, jFin);
                    return true;
                }
            }
            
            
        return false;
    }
   
}
