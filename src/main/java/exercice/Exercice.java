package exercice;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Exercice {

    /**
     * Trie les mots d'un texte en fonction de l'ordre spécifié.
     *
     * @param str   Le texte à traiter.
     * @param ordre L'ordre spécifié pour trier les mots.
     * @return Une liste contenant les mots triés.
     */
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();

        StringBuilder motActuel = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (motActuel.length() > 0) {
                    mots.add(motActuel.toString());
                    motActuel.setLength(0);
                }
            } else {
                motActuel.append(c);
            }
        }

        if (motActuel.length() > 0) {
            mots.add(motActuel.toString());
        }

        if (ordre != null) {
            trieMots(mots, ordre);
        }

        return mots;
    }

    /**
     * Trie les mots en utilisant l'ordre spécifié.
     *
     * @param mots  La liste des mots à trier.
     * @param ordre L'ordre spécifié pour trier les mots.
     */
    private static void trieMots(List<String> mots, List<Character> ordre) {
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            indexMap.put(ordre.get(i), i);
        }

        mots.sort((mot1, mot2) -> {
            int len1 = mot1.length();
            int len2 = mot2.length();
            int minLen = Math.min(len1, len2);

            for (int i = 0; i < minLen; i++) {
                char c1 = mot1.charAt(i);
                char c2 = mot2.charAt(i);

                if (c1 != c2) {
                    Integer index1 = indexMap.get(c1);
                    Integer index2 = indexMap.get(c2);
                    if (index1 != null && index2 != null) {
                        return Integer.compare(index1, index2);
                    }
                }
            }

            return Integer.compare(len1, len2);
        });
    }
}
