/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 *
 * @author vdufo
 */

public class Fournisseur extends CaseAchetable{

    /**
     * Construteur d'un fournisseur
     * @param prix
     * @param proprietaire
     * @param numero
     * @param nom
     */
    public Fournisseur(int prix, Joueur proprietaire, int numero, String nom) {
        super(prix, proprietaire, numero, nom);
    }

    /**
     * Méthode qui permet d'afficher une case fournisseur
     * @return chaîne de caractère qui ajoute à la méthode super le propriétaire, et si besoin, le loyer à payer sur cette case
     */
    @Override
    public String toString() {
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
     * Méthode qui permet de calculer le loyer d'une case fournisseur
     * @param prop joueur qui possède la case fournisseur
     * @param scoreDe score de dé du tour de jeu du joueur qui est arrivé sur cette case
     * @return le loyer à payer sur cette case selon le score de dé du joueur et le nombre de fournisseurs possédés par le joueur à payer
     */
    public int calculerLoyer(Joueur prop, int scoreDe) {
        if (prop==null){
            return 0;
        }
        else{
            switch(prop.getNbFournisseur()){
                case 1:
                    return 4*scoreDe*this.getPrix();
                case 2:
                    return 10*scoreDe*this.getPrix();
                default:
                    return 0;
            }
        }
    }
}
