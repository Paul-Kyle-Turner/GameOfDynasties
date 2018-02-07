package com.company;

public class MessageControl {

    public MessageControl(){}

    public static boolean is_y(String y){
        if(y.equals("y") || y.equals("Y")){
            return true;
        }
        else{
            return false;
        }
    }

    public static int[] coord(String co){
        String[] spl = co.split(",");
        int [] splint = {Integer.parseInt(spl[0]),Integer.parseInt(spl[1])};
        return splint;
    }
}
