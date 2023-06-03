package exercice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
        String texte = "exemple de texte a classer";
        List<Character> ordre = List.of('b', 'x', 'e', 't', 'a', 'm', 'p', 'l', 's', 'r', 'd');
        System.out.println(Exercice.solution(texte, ordre));
        // output: [classer, texte, exemple, a, de]
    }
}
