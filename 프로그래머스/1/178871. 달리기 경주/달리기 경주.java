import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (String player : callings) {
            int index = map.get(player);
            String tmp = players[index];
            players[index] = players[index-1];
            players[index-1] = tmp;
            map.put(players[index-1], index-1);
            map.put(players[index], index);
        }
        return players;
    }
}