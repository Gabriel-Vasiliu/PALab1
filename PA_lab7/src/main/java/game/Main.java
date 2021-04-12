package game;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        {
        Token t1 = new Token("t1");
        t1.number1 = 1;
        t1.number2 = 2;
        board.tokenList.add(t1);
        Token t2 = new Token("t2");
        t2.number1 = 1;
        t2.number2 = 3;
        board.tokenList.add(t2);
        Token t3 = new Token("t3");
        t3.number1 = 1;
        t3.number2 = 4;
        board.tokenList.add(t3);
        Token t4 = new Token("t4");
        t4.number1 = 1;
        t4.number2 = 5;
        board.tokenList.add(t4);
        Token t5 = new Token("t5");
        t5.number1 = 1;
        t5.number2 = 6;
        board.tokenList.add(t5);
        Token t6 = new Token("t6");
        t6.number1 = 2;
        t6.number2 = 3;
        board.tokenList.add(t6);
        Token t7 = new Token("t7");
        t7.number1 = 2;
        t7.number2 = 4;
        board.tokenList.add(t7);
        Token t8 = new Token("t8");
        t8.number1 = 2;
        t8.number2 = 5;
        board.tokenList.add(t8);
        Token t9 = new Token("t9");
        t9.number1 = 2;
        t9.number2 = 6;
        board.tokenList.add(t9);
        Token t10 = new Token("t10");
        t10.number1 = 3;
        t10.number2 = 4;
        board.tokenList.add(t10);
        Token t11 = new Token("t11");
        t11.number1 = 3;
        t11.number2 = 5;
        board.tokenList.add(t11);
        Token t12 = new Token("t12");
        t12.number1 = 3;
        t12.number2 = 6;
        board.tokenList.add(t12);
        Token t13 = new Token("t13");
        t13.number1 = 4;
        t13.number2 = 5;
        board.tokenList.add(t13);
        Token t14 = new Token("t14");
        t14.number1 = 4;
        t14.number2 = 6;
        board.tokenList.add(t14);
        Token t15 = new Token("t15");
        t15.number1 = 5;
        t15.number2 = 6;
        board.tokenList.add(t15);
    }

        for (Token t : board.tokenList){
            Random random = new Random();
            t.specificValue = random.nextInt(10) + 1;
        }
        Player player1 = new Player("Marius", board);
        Player player2 = new Player("Daniel", board);
        Player player3 = new Player("George", board);

        Thread th1 = new Thread(player1);
        Thread th2 = new Thread(player2);
        Thread th3 = new Thread(player3);

        th1.start();
        th2.start();
        th3.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            System.out.println("Wait...");
        }

        Win win = new Win();
        win.players.add(player1);
        win.players.add(player2);
        win.players.add(player3);
        win.Winner();
    }
}
