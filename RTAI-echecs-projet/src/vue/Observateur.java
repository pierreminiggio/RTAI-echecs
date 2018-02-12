/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author jtrescartes
 */
public interface Observateur {
    public void avertir(int i, int j);
    public void avertirNewGame();
    public void avertirFinPartie(boolean avecVainqueur);
}
