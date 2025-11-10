/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 *
 * @author Max
 */
public class Gare extends CaseAchetable{

    /**
     * Constructeur d'une gare
     * @param prix
     * @param proprietaire
     * @param numero
     * @param nom
     */
    public Gare(int prix, Joueur proprietaire, int numero, String nom) {
        super(prix, proprietaire, numero, nom);
    }

    /**
     * Méthode qui permet d'afficher une case gare
     * @return chaîne de caractère qui ajoute à la méthode super le propriétaire, et si besoin, le loyer à payer sur cette case
     */
    @Override
    public String toString(){
        String txt = super.toString();
        if (this.getProprietaire() == null){
            txt +=" - sans propriétaire";
        }
        else{
            txt += " - propriétaire : "+this.getProprietaire();
            int loyer = calculerLoyer(this.getProprietaire());
            txt += ", loyer = "+loyer;
        }
        return txt;
    }

    /**
     * Méthode qui permet de calculer le loyer d'une case gare 
     * @param prop joueur qui possède la case gare
     * @return le loyer à payer par un joueur arrivant sur cette case, qui dépend du nombre de gare possédée par le joueur à payer 
     */
    @Override
    public int calculerLoyer(Joueur prop) {
        if (prop==null){
            return 0;
        }
        else{
            return prop.getNbGare()*2500;
        }
    }
}
