import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("words.txt"));
        String str="";
        String readStr="";
        while((readStr = br.readLine())!=null){
            str+=readStr+" ";
        }
        String[] words = str.split(" ");
        HashMap<String,Integer> hashMap= new HashMap<>();

        for(String word:words){
            if(hashMap.containsKey(word)){
                int x = hashMap.get(word);
                hashMap.put(word, x+1);
            }else{
                hashMap.put(word,1);
            }
        }
        Collection<String> values = hashMap.keySet();
        for (String value: values){
            System.out.println(value + " " + hashMap.get(value));
        }
    }
}
