/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 * Classe de la case prison
 * @author Max
 */
public class Prison extends CaseSpeciale {
	
	/**
	 * Constructeur de la case prison
	 */
    public Prison() {
		super(10, "Prison");
	}
	
	/**
	 * Redéfinition de la fonction toString
	 * @return Prison
	 */
	@Override
	public String toString() {
		return this.getNom();
	}
}
