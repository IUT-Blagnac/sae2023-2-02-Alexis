package main.java.exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EfficaciteMeilleur33 {
    public static List<String> solution(String str, List<Character> ordre) {
        Map<Character, List<String>> motParPremiereLettre = new HashMap<>();
		
        for(int i = 0; i < ordre.size(); i++) {
            motParPremiereLettre.put(ordre.get(i), new ArrayList<>());
        }
        StringBuilder motCourant = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char lettre = str.charAt(i);
            if (lettre == ' ') {
                if (motCourant.length() > 0 && motParPremiereLettre.containsKey(motCourant.charAt(0))) {
                    motParPremiereLettre.get(motCourant.charAt(0)).add(motCourant.toString());
                }
                motCourant.setLength(0); 
            } else {
                motCourant.append(lettre);
            }
        }

        List<String> motsTries = new ArrayList<>();
        for(int i = 0; i < ordre.size(); i++) {
            motsTries.addAll(motParPremiereLettre.get(ordre.get(i)));
        }

        return motsTries;
    }
}

