import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("words.txt"));
        String str="";
        String readStr="";
        while((readStr = br.readLine())!=null){
            str+=readStr+" ";
        }
        String[] words = str.split(" ");
        Map<String,Integer> hashMap= new HashMap<>();

        for(String word:words){
            if(hashMap.containsKey(word)){
                int x = hashMap.get(word);
                hashMap.put(word, x+1);
            }else{
                hashMap.put(word,1);
            }
        }

        //++++++++++++++++++++++++++++++
        Map<String,Integer> sortedMap = hashMap.entrySet()
                                                .stream()
                                                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                                .collect(Collectors.toMap(Map.Entry::getKey,
                                                                          Map.Entry::getValue,
                                                                          (e1,e2)->e1,
                                                                           LinkedHashMap::new));


        for(Map.Entry<String,Integer> entry: sortedMap.entrySet()){
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

    }
}
