package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Board board = new Board();
	    Scanner scan = new Scanner(System.in);
	    boolean stop = false;
	    boolean mod = false;
        System.out.println(board.printOpen());
        System.out.println("Would you like the modified board?(y/n)");
        if(MessageControl.is_y(scan.next())){
            mod = true;
        }
        System.out.println("Would you like a random board? (y,n)");
	    if(MessageControl.is_y(scan.next())){
            board.randomize();
        }
        else{
	        System.out.println("Please enter all coordinates in the form x,y.");
	        System.out.println("The board will print when special value -1,-1 given.");
            do{
                int[] co = MessageControl.coord(scan.next());
                if(co[0] < 1 || co[1] < 1){
                    stop = true;
                }
                else {
                    board.makeLife(co[0], co[1]);
                }
            }while(!stop);
        }
        System.out.println("Initial board state : ");
        System.out.println(board.toString());
        boolean kill = true;
        do {
            System.out.println("Run simulation for _____ turns. -1 is kill");
            int turns = scan.nextInt();
            if(turns < 1){
                kill = false;
            }
            else{
                board.updateBoardMany(turns, mod);
                System.out.println(board.toString());
            }
        }while(kill);
        System.out.println("Final board : ");
        System.out.println(board.toString());
    }
}
