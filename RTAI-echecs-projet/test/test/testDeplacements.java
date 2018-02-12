/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import modele.Jeu;
import modele.Joueur;
import modele.Pion;

/**
 *
 * @author pminiggio
 */
public class testDeplacements {
    public static void main (String[] args){
        Pion pion1 = new Pion("noir");
        System.out.println(pion1.getCouleur());
        System.out.println(pion1.getLienImg());
        
        Joueur j1 = new Joueur("j1");
        Joueur j2 = new Joueur("j2");
        Jeu jeu = new Jeu(j1, j2);
        
        boolean test = jeu.deplacerPiece(1, 3, 3, 3);
        System.out.println(test);    
        
        jeu.addReplacePiece(new Pion("noir"), 2, 0);
        jeu.affichageConsole();
            
        //boolean test2 = jeu.getPlateau()[1][1].deplacementPossible(jeu.getPlateau(), 1, 1, 2, 0);
        boolean test2 = jeu.deplacerPiece(1, 1, 2, 0);
        System.out.println(test2);
        jeu.affichageConsole();
        
        jeu.addReplacePiece(new Pion("blanc"), 5, 0);
        boolean test3 = jeu.deplacerPiece(6, 2, 4, 2);
        System.out.println(test3);
        boolean test4 = jeu.deplacerPiece(6, 1, 5, 0);
        System.out.println(test4);
        boolean test5 = jeu.deplacerPiece(5, 0, 4, 0);
        System.out.println(test5);
        jeu.affichageConsole();
        jeu.supprimerPiece(4, 0);
        jeu.supprimerPiece(1, 0);
        jeu.affichageConsole();
        boolean test6 = jeu.deplacerPiece(0, 0, 1, 0);
        System.out.println(test6);
        boolean test7 = jeu.deplacerPiece(1, 0, 0, 0);
        System.out.println(test7);
        jeu.addReplacePiece(new Pion("noir"), 1, 0);
        jeu.affichageConsole();
        boolean test8 = jeu.deplacerPiece(0, 0, 1, 0);
        System.out.println(test8);
        jeu.affichageConsole();
        jeu.addReplacePiece(new Pion("noir"), 1, 1);
        jeu.affichageConsole();
        boolean test9 = jeu.deplacerPiece(1, 0, 1, 1);
        System.out.println(test9);
        jeu.affichageConsole();
        jeu.supprimerPiece(1, 1);
        //jeu.addReplacePiece(new Pion("noir"), 2, 0); //
        boolean test10 = jeu.deplacerPiece(0, 2, 2, 0);
        System.out.println(test10);
        jeu.affichageConsole();
        boolean test11 = jeu.deplacerPiece(0, 3, 2, 3);
        System.out.println(test11);
        jeu.affichageConsole();
        boolean test12 = jeu.deplacerPiece(0, 1, 2, 2);
        System.out.println(test12);
        jeu.affichageConsole();
    }
}
