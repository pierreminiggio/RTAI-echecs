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
public class Joueur {
    String pseudo;
    boolean rocknroll;
    
    public Joueur(String _pseudo) {
        this.pseudo = _pseudo;
        this.rocknroll = false;
    }
    
    public String getPseudo() {
        return this.pseudo;
    }
    
    public void setPseudo(String _pseudo) {
        this.pseudo = _pseudo;
    }
    
    public boolean getRocknroll() {
        return this.rocknroll;
    }
    
    public void setRocknroll(boolean _rocknroll) {
        this.rocknroll = _rocknroll;
    }
}
