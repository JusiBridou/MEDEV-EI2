/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 *
 * @author dytri
 */
public class Taxe extends CaseSpeciale{
    private int montant;
    
    /**
    * Constructeur de la case prison
    */
    public Taxe(String nom, int num, int prix) {
	super(nom,num);
        this.montant = prix;
    }
    
    /**
    * Redéfinition de la fonction toString
    * @return Prison
    */
    @Override
    public String toString() {
	return this.getNom();
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    
}
