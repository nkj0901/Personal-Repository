import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main20920영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<String, Integer>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(word.length() < M) continue;
            words.put(word, words.getOrDefault(word, 0)+1);
        }

        List<Map.Entry<String, Integer>> list = words.entrySet().stream().collect(Collectors.toList());

        list.sort((o1, o2) -> {
            if(o1.getValue() != o2.getValue()) return o2.getValue()-o1.getValue();

            if(o1.getKey().length() != o2.getKey().length()) return o2.getKey().length()-o1.getKey().length();

            return o1.getKey().compareTo(o2.getKey());

        });

        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i).getKey()+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
