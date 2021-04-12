package game;

import java.util.ArrayList;

public class Win {
    ArrayList<Player> players = new ArrayList<>();
    public void Winner(){
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        if (player1.score > player2.score && player1.score > player3.score){
            System.out.println(player1.name + " is winner with " + player1.score);
        }else
            if(player2.score > player1.score && player2.score > player3.score){
                System.out.println(player2.name + " is winner with " + player2.score);
            }else
                System.out.println(player3.name + " is winner with " + player3.score);
    }
}
