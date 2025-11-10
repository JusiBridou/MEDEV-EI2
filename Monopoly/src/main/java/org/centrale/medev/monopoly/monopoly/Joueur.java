/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

import java.util.List;

/**
 *  Un joueur
 * @author Max
 */
public class Joueur {

    private String nom;
    private int fortune;
    private int position;
    private Plateau plateau;
    
    private List<Case> caseDetenue;
    
    /**
     *  Constructeur d'un joueur
     * @param nom
     * @param fortune
     * @param position
     * @param plateau
     * @param caseDetenue
     */
    public Joueur(String nom, int fortune, int position, Plateau plateau, List<Case> caseDetenue) {
        this.nom = nom;
        this.fortune = fortune;
        this.position = position;
        this.plateau = plateau;
        this.caseDetenue = caseDetenue;
        
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

    /**
     *
     * @return
     */
    public List<Case> getCaseDetenue() {
        return caseDetenue;
    }

    /**
     *
     * @param caseDetenue
     */
    public void setCaseDetenue(List<Case> caseDetenue) {
        this.caseDetenue = caseDetenue;
    }

    
    
    

}
