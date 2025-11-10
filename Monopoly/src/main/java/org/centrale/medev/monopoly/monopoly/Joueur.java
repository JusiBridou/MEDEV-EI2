/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

import java.util.List;
import java.util.Random;

/**
 *
 * @author selli
 */
public class Joueur {

    private String nom;
    private int fortune;
    private int position;
    private Plateau plateau;
    private int nbGare;
    private int nbFournisseur;
    
    private int tourRestantPrison;
    
    
    /**
     *  Constructeur d'un joueur
     * @param nom
     * @param fortune
     * @param position
     * @param plateau
     * @param nbGare
     * @param nbFournisseur
     * @param tourRestantPrison
     */
    
    public Joueur(String nom, int fortune, int position, Plateau plateau, int nbGare, int nbFournisseur, int tourRestantPrison) {    
        this.nom = nom;
        this.fortune = fortune;
        this.position = position;
        this.plateau = plateau;
        this.nbGare = nbGare;
        this.nbFournisseur = nbFournisseur;
        this.tourRestantPrison = tourRestantPrison;
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
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public int getFortune() {
        return fortune;
    }

    /**
     *
     * @param fortune
     */
    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    /**
     *
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public Plateau getPlateau() {
        return plateau;
    }

    /**
     *
     * @param plateau
     */
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public int getTourRestantPrison() {
        return tourRestantPrison;
    }

    public void setTourRestantPrison(int tourRestantPrison) {
        this.tourRestantPrison = tourRestantPrison;
    }
    
    /**
     * Le joueur avance de d case depuis la case c
     * @param d lancer de dès
     * @param c case
     */
    public void avance(int d,Case c){
        for(int i=0; i<d;i++){
            if (position+1<40){
                position=position+1;
            }else{
                position=0;
                this.setFortune(this.fortune + 200);
            }
        }
    }   

    public int getNbGare() {
        return nbGare;
    }

    public void setNbGare(int nbGare) {
        this.nbGare = nbGare;
    }

    public int getNbFournisseur() {
        return nbFournisseur;
    }

    public void setNbFournisseur(int nbFournisseur) {
        this.nbFournisseur = nbFournisseur;
    }
    
    /**
     * Un paiement
     * @param loyer 
     * @param j 
     */
    
    public void paiement(int loyer, Joueur j){
        if (loyer>this.fortune){
            j.setFortune(this.fortune + j.getFortune());
            this.fortune = 0;
        }else{
            j.setFortune(this.fortune + j.getFortune());
            this.fortune = this.fortune - loyer;
        }
    }
 
}
