/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

import java.util.List;

/**
 *
 * @author Max
 */
public class Joueur {

    private String nom;
    private int fortune;
    private int position;
    private Plateau plateau;
    
    private List<Case> caseDetenue;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFortune() {
        return fortune;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public List<Case> getCaseDetenue() {
        return caseDetenue;
    }

    public void setCaseDetenue(List<Case> caseDetenue) {
        this.caseDetenue = caseDetenue;
    }
    
    

}
