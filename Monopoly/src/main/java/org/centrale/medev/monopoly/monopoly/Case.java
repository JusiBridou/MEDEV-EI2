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
    int numero;
    String nom;
    
    public Case (String nom,int numero){
        this.nom= nom;
        this.numero=numero;
    }
}
