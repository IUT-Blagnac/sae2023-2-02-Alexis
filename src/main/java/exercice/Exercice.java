package exercice;

import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = Arrays.asList(str.split(" "));

        // Créer une table de hachage pour stocker les indices de chaque lettre
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            indexMap.put(ordre.get(i), i);
        }

        // Trier les mots en utilisant un comparateur personnalisé basé sur l'ordre des lettres
        mots.sort(new Comparator<String>() {
            int compare(String mot1, String mot2) {
                int len1 = mot1.length();
                int len2 = mot2.length();
                int minLen = Math.min(len1, len2);

                for (int i = 0; i < minLen; i++) {
                    char c1 = mot1.charAt(i);
                    char c2 = mot2.charAt(i);

                    if (c1 != c2) {
                        int index1 = indexMap.get(c1);
                        int index2 = indexMap.get(c2);
                        return Integer.compare(index1, index2);
                    }
                }

                return Integer.compare(len1, len2);
            }
        });

        return mots;
    }
}