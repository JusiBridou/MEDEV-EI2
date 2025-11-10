/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 *
 * @author Max
 */
public abstract class CaseAchetable extends Case{
    private int prix;
    private Joueur proprietaire;

    /**
     * Constructeur d'une case achetable
     * @param prix
     * @param proprietaire
     * @param numero
     * @param nom
     */
    public CaseAchetable(int prix, Joueur proprietaire, int numero, String nom) {
        super(nom, numero);
        this.prix = prix;
        this.proprietaire = proprietaire;
    }

    /**
     *
     * @return
     */
    public int getPrix() {
        return prix;
    }

    /**
     *
     * @param prix
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }

    /**
     *
     * @return
     */
    public Joueur getProprietaire() {
        return proprietaire;
    }

    /**
     *
     * @param proprietaire
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    /**
     * Méthode abstraite calculerloyer qui sera à redéfinir dans les classes suivantes
     * @param prop joueur qui possède la case achetable
     * @return le loyer à payer par le joueur arrivant sur cette case
     */
    public abstract int calculerLoyer(Joueur prop);
    
    /**
     * Méthode qui permet à un joueur d'acheter une case qui est libre si il a la fortune suffisante
     * @param j joueur qui souhaite acheter la case
     */
    public void acheter(Joueur j){
        if (this.getProprietaire()==null){
            if (j.getFortune()>=this.getPrix()){
                this.setProprietaire(j);
                j.setFortune(j.getFortune()-this.getPrix());
            }
            else{
                System.out.println("Vous n'avez pas assez d'argent pour acheter cette case.");
            }
        }
        else{
            System.out.println("La case est déjà possédée par un joueur");
        }
    }
    
    /**
     * Méthode permettant d'afficher une case achetable
     * @return le nom et le coût de la case
     */
    @Override
    public String toString(){
        String txt = super.toString()+" (coût : "+this.getPrix()+")";
        return txt;
    };
}
