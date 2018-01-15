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
public class maintest {
    
    
    public static void main (String[] args){
        Pion pion1 = new Pion("noir");
        System.out.println(pion1.getCouleur());
        System.out.println(pion1.getLienImg());
        
        Joueur j1 = new Joueur("j1");
        Joueur j2 = new Joueur("j2");
        Jeu jeu = new Jeu(j1, j2);
        
        for (int i=7; i>-1; i--) {
           for (int j=7; j>-1; j--) {
               try {
                   System.out.print("-"+jeu.getPlateau()[i][j].getNom()+"-");
               }
               catch (NullPointerException e) {
                   System.out.print("-vide-");
               }
            }
            System.out.println("");
        }
        boolean test = jeu.getPlateau()[1][1].deplacementPossible(jeu.getPlateau(), 1, 1, 2, 0);
            System.out.println(test);
            
            jeu.addReplacePiece(new Pion("blanc"), 2, 0);
            for (int i=7; i>-1; i--) {
           for (int j=0; j<8; j++) {
               try {
                   System.out.print("-"+jeu.getPlateau()[i][j].getNom()+"-");
               }
               catch (NullPointerException e) {
                   System.out.print("-vide-");
               }
            }
            System.out.println("");
        }
            boolean test2 = jeu.getPlateau()[1][1].deplacementPossible(jeu.getPlateau(), 1, 1, 2, 0);
            System.out.println(test2);
    }
}
