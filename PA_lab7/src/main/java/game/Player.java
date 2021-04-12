package game;

import java.util.*;

public class Player extends Thread {
    int score = 0;
    String name;
    private final Board board;
    List<Token> tokenList = new ArrayList<>();
    Player(String name, Board board){
        this.name = name;
        this.board = board;
    }

    @Override
    public void run() {
        while(!board.tokenList.isEmpty()){
            try{
                extractToken();
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println("There are no tokens left on the board!");
            }
        }
        for (Token t: tokenList){
            System.out.println(t.name + " -> " + t.number1 + " " + t.number2 + ", " + t.specificValue );
            score = score + t.specificValue;
        }
        System.out.println( name + "->" + score);
    }
    public void extractToken(){
        synchronized (board){
            Random random = new Random();
            int rand = random.nextInt(board.tokenList.size());
            Token t;
            t = board.tokenList.get(rand);
            tokenList.add(t);
            board.tokenList.remove(rand);
        }

    }
}