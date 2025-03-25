package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {

    public void reader() throws IOException {
        String filename = "prueba.txt";

        BufferedReader br = new BufferedReader(new FileReader(filename));
        Map<String, Integer> map = new HashMap<>();
        List<String> words = new ArrayList<>();
        String linea = br.readLine();

        while (linea != null) {
            linea = linea.toLowerCase();
            //separate words by some defined delimiter
            StringTokenizer st = new StringTokenizer(linea, " ¿.¡,!?;:()[]{}'\"");

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                words.add(word);
            }
            linea = br.readLine();
        }

        for (String word : words) {

            //If the word is already in the map, we get its value and increment it
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                //If the word is not present, the counter is initialized to 1
                map.put(word, 1);
            }
        }

        //Compares two map entries by value and sorts them
        List<Map.Entry<String, Integer>> orderedList = new ArrayList<>(map.entrySet());
        orderedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        //shows the 10 most frequent words
        for (int i = 0; i < Math.min(10, orderedList.size()); i++) {
            System.out.println(orderedList.get(i).getKey() + " -> " + orderedList.get(i).getValue());
        }
    }
}
