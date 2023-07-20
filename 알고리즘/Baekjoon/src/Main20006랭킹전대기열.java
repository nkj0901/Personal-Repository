import java.io.*;
import java.util.*;

public class Main20006랭킹전대기열 {

    static class Room {
        int low;
        int high;
        TreeMap<String, Integer> names;
        int current;

        Room(int low, int high, TreeMap<String,Integer> names, int current) {
            this.low = low;
            this.high = high;
            this.names = names;
            this.current = current;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int player = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for(int i = 0; i < player; i++){
            st = new StringTokenizer(br.readLine());
            boolean check = false;
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            for(int j = 0; j < rooms.size(); j++){
                Room room = rooms.get(j);
                if(room.current == capacity) continue;
                if(room.low<=level && room.high>=level) {
                    room.names.put(name, level);
                    room.current++;
                    check = true;
                    break;
                }
            }

            if(!check) {
                TreeMap<String, Integer> tmpNames = new TreeMap<>();
                tmpNames.put(name, level);
                rooms.add(new Room(level-10, level+10, tmpNames, 1));
            }
        }

        for(int i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.current == capacity) bw.write("Started!"+"\n");
            else bw.write("Waiting!" + "\n");

            for(String key : room.names.keySet()){
                bw.write(room.names.get(key) + " " + key + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
