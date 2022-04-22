import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    String series;
    Huffman huffman=new Huffman();
    Map<Character,Integer> mapOccurences=new HashMap<>();
    public static void main(String[] args) {
        Main main=new Main();
        main.loadSeries();
        main.putInMap();

        main.displayMap();
        main.implementatNode();
        System.out.println("Suma wszystkich bitow: "+Huffman.finalSum);

    }
    private void loadSeries(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Podaj ciag znakow:");
        series= sc.nextLine();
    }
    private void putInMap(){
        int occurences=1;
        for(int i=0;i<series.length();i++){
            char letter=series.charAt(i);
            if(!mapOccurences.containsKey(letter))
                mapOccurences.put(letter,occurences);
            else
                mapOccurences.put(letter, mapOccurences.get(letter) + 1);

        }

    }
    private void displayMap(){
        int counter=0;
        int finalSum=0;
        int mapSize=mapOccurences.size();
        double value=  Math.sqrt(mapSize);
        int val= (int)Math.ceil(value);
        String pattern="%"+val+"s";

        for (Map.Entry<Character, Integer> entry : mapOccurences.entrySet()) {
            String tmp=String.format(pattern, Integer.toBinaryString(counter)).replace(' ','0');
            int bits=tmp.length()*entry.getValue();
            finalSum+=bits;
            System.out.println(entry.getKey() + ":" +tmp+" - "+entry.getValue().toString()+" : lacznie bitow: "+bits);
            counter++;
        }
        System.out.println("Suma wszystkich bitów: "+finalSum);
        System.out.println("--------After compresion----------");
    }
    private void implementatNode(){
        huffman.implementNodes(mapOccurences,series.length());
    }

}
