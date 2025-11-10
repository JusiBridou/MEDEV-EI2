/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;
import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author Max
 */
public class Plateau {
    private ArrayList<Case> plateau;
    private LinkedList<Joueur> joueurs;
    private ArrayList<Carte> piocheChance;
    private ArrayList<Carte> piocheCommune;
    private ArrayList<Carte> defausseChance;
    private ArrayList<Carte> defausseCommunaute;
    private int nbToursMax = 100;
    private int compteurTours = 1;
    /**
     * 
     */
    public Plateau(){ 
    }
    /**
     * 
     * @return 
     */
    public int lancerDé1(){
        Random randInt = new Random();
        int dé1 = randInt.nextInt(6)+1;

        return dé1;
    }
    public int lancerDé2(){
        Random randInt = new Random();
        int dé2 = randInt.nextInt(6)+1;
        
        return dé2;
    }
    
    public void tourDeJeu(){
        //tour de chaque joueur
        for (Joueur j : joueurs){
            
            //lancé de dé
            int d1 = this.lancerDé1();
            int d2 = this.lancerDé2();
            
            //joueur avance
            j.avance(d1+d2,plateau.get(j.getPosition()-1));
            System.out.println("Vous etes maintenant à la case " + j.getPosition());
            Case c = plateau.get(j.getPosition()-1);
            //on teste si on est sur une case achetable ou non
            if (c instanceof CaseAchetable){
                if ((((CaseAchetable)c).getProprietaire() != null) && (((CaseAchetable)c).getProprietaire() != j)){//case appartient à quelqu'un
                    int m = ((CaseAchetable)c).calculerLoyer(j);
                    j.paiement(m,((CaseAchetable)c).getProprietaire());//paiement au joueur qu'il faut
                } else{//case vide
                    System.out.println("Voulez-vous acheter cette case pour le prix de " + ((CaseAchetable)c).getPrix() + " ? (oui ou non)");
                    Scanner sc = new Scanner(System.in);
                    String choix = sc.nextLine();
                    if (choix.equalsIgnoreCase("oui")){
                        ((CaseAchetable)c).acheter(j);
                        }
                }
            } else{//case spéciale
                if (c instanceof Taxe){//paye taxe
                    int f = j.getFortune();
                    j.setFortune(f-((Taxe)c).getMontant());
                } else if (plateau.get(j.getPosition()-1) instanceof GoPrison){//allez en prison
                    ((GoPrison)c).envoyerJoueurPrison(j);
                } else if (c instanceof CaseCarte){
                    if (((CaseCarte)c).getType()=="chance"){
                        Carte carte = ((CaseCarte)c).tirerUneCarte(this.piocheChance);
                        int f = j.getFortune();
                        j.setFortune(f+carte.getEffet());
                    } else {
                        Carte carte = ((CaseCarte)c).tirerUneCarte(this.piocheCommune);
                        int f = j.getFortune();
                        j.setFortune(f+carte.getEffet());
                    }      
                }
            }
        }         
        supprimerJoueur();
        if (finDePartie()){
            System.out.println("Fin de la partie");
        } else {
            compteurTours ++;
        }
    }

    public void init_joueurs(int nbJoueurs){
        for(int i=0; i<nbJoueurs; i++){
            joueurs.add(new Joueur("Joueur "+Integer.toString(i), 1500, 0, this, 0, 0, 0));
        }
    }
    
    public void affiche(){
        for(Case case_plateau : plateau){
            case_plateau.toString();
        }
    }

    public void supprimerJoueur(){
        for(Joueur j : joueurs){
            if(j.getFortune()<0){
                joueurs.remove(j);
            }
        }
    }
    
    public boolean finDePartie(){
        return (joueurs.size()<=1 || compteurTours > nbToursMax) ;
    }
    
    public ArrayList getPlateau() {
        return plateau;
    }

    public void setPlateau(ArrayList plateau) {
        this.plateau = plateau;
    }

    public LinkedList getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(LinkedList joueurs) {
        this.joueurs = joueurs;
    }
    
    public void initPlateau(){
        LinkedList<String> noms = new LinkedList<>();
        noms.addAll(Arrays.asList("Case Départ","Boulevard de Belleville","Caisse de Communauté","Rue Lecourbe","Impôts sur le revenu",
                "Gare Montparnasse","Rue de Vaugirard","Chance","Rue de Courcelles","Avenue de la République","Prison",
                "Boulevard de la Villette","Compagnie de distribution d'électricité","Avenue de Neuilly","Rue de Paradis",
                "Gare de Lyon","Avenue Mozart","Caisse de Communauté","Boulevard Saint-Michel","Place Pigalle","Parc Gratuit",
                "Avenue Matignon","Chance","Boulevard Malesherbes","Avenue Henri-Martin","Gare du Nord","Faubourg Saint-Honoré",
                "Place de la Bourse","Compagnie de distribution des eaux","Rue la Fayette","Allez en Prison","Avenue de Breteuil",
                "Avenue Foch","Caisse de communauté","Boulevard des Capucines","Gare Saint-Lazare","Chance",
                "Avenue des Champs-Elysées","Taxe de Luxe","Rue de la Paix"));
        for(int i=0;i<40;i++){
            
            if(noms.get(i)=="Chance"||noms.get(i)=="Caisse de Communauté"){
                plateau.add(new CaseCarte(noms.get(i),i,noms.get(i)));
            }
            else if(noms.get(i).substring(0,4)=="Gare"){
                plateau.add(2000, new Gare(2000,null,i, noms.get(i)));
            }
            else if(noms.get(i)=="Allez en Prison"){
                plateau.add(new GoPrison(noms.get(i),i));
            }
            else if(noms.get(i).substring(0,9)=="Compagnie"){
                plateau.add(new Fournisseur( (int) (sqrt(i+1)),null,i, noms.get(i)));
            }
            else if(noms.get(i)=="Case Départ"||noms.get(i)=="Prison"||noms.get(i)=="Parc Gratuit"){
                plateau.add(new Attente(noms.get(i),i));
            }   
            else if(noms.get(i)=="Taxe de Luxe"){
                plateau.add(new Taxe(noms.get(i),i,200));
            }  
            else if(noms.get(i)=="Impôts sur le revenu"){
                plateau.add(new Taxe(noms.get(i),i,100));
            }  
            else{
                plateau.add(new Constructible(0, (int) (sqrt(i+1)*1000),null,i,noms.get(i)));
            }
        }
        
        for(int i=0; i < 25; i++){
            piocheChance.add(new Carte("chance"));
            piocheCommune.add(new Carte("communaute"));
        }
        
    }
}

