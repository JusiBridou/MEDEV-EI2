/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 *
 * @author Max
 */
public abstract class Case {
    private int numero;
    private String nom;

    /**
     * Constructeur d'une case
     * @param numero
     * @param nom
     */
    public Case( String nom, int numero) {
        this.numero = numero;
        this.nom = nom;
    }
    
    /**
     *
     * @param nom
     */
    public Case(String nom){
        this.numero = 0; // numéro par défaut qui sera modifié par l'appel
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Méthode permettant d'afficher une case
     * @return le nom de la case
     */
    @Override
    public String toString(){
        String txt = this.getNom();
        return txt;
    }
    
}
