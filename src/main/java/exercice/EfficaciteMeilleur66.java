package main.java.exercice;

import java.util.ArrayList;
import java.util.List;

public class EfficaciteMeilleur66 {

    public static List<String> solution(String str, List<Character> ordre) { // La méthode prend en paramètre une chaine de caractère et une liste de caractère
        List<String> motOrdreList = new ArrayList<>(); // Liste des mots dans l'ordre
        List<String> motSepareList = new ArrayList<>(); // Liste des mots séparés
        String mots = ""; // Mot en cours de traitement
    
        for (char caractere : str.toCharArray()) { // le foreach permet de parcourir chaque caractère de la chaine de caractère
            if (caractere == ' ' || caractere == '\'' || caractere == ',') { // Si le caractère est un espace, une apostrophe ou une virgule
                if (!mots.isEmpty()) { // De plus, si le mot n'est pas vide
                    motSepareList.add(mots); // Ajouter le mot à la liste des mots séparés
                    mots = ""; // Réinitialiser le mot
                }
            } else {
                mots += caractere; // Ajouter le caractère au mot
            }
        }
    
        if (!mots.isEmpty()) { // Si le mot n'est pas vide
            motSepareList.add(mots); // Ajouter le mot à la liste des mots séparés
        }
    
        if (str.isEmpty()) { // Si la chaine de caractère est vide
            motOrdreList.add(""); // Ajouter un mot vide à la liste des mots dans l'ordre
        } else {
            for (char motOrd : ordre) { // le foreach permet de parcourir chaque caractère de la liste des ordres, 
                for (String motSep : motSepareList) { // le foreach permet de parcourir chaque mot de la liste des mots séparés
                    if (motSep.charAt(0) == motOrd) { // Si le premier caractère du mot est égal à l'ordre
                        motOrdreList.add(motSep); // Ajouter le mot à la liste des mots dans l'ordre
                    }
                }
            }
    
            for (String motSep : motSepareList) { // le foreach permet de parcourir chaque mot de la liste des mots séparés
                if (!motOrdreList.contains(motSep)) {  // Si le mot n'est pas dans la liste des mots dans l'ordre
                    motOrdreList.add(motSep); // Ajouter le mot à la liste des mots dans l'ordre
                }
            }
        }
    
        return motOrdreList; // Retourne la liste des mots dans l'ordre
    }
}

// Points particuliers :

// La boucle foreach est plus efficace que la boucle for car elle permet de parcourir chaque élément d'une liste sans avoir à utiliser un indice, ce qui permet de gagner du temps.
// La méthode toCharArray() permet de convertir une chaine de caractère en tableau de caractère. 
// La méthode charAt() permet de retourner le caractère à l'indice spécifié.
// La méthode isEmpty() permet de vérifier si une chaine de caractère est vide.
// La méthode contains() permet de vérifier si une liste contient un élément.
    