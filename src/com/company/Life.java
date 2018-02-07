package com.company;

public class Life {

    private int x,y;

    private int value;

    public Life(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int[] get_x_y(){
        int [] co = {x,y};
        return co;
    }

    public boolean is_alive(){
        if(value >= 1){
            return true;
        }
        return false;
    }

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String toString() {
       return Integer.toString( this.value );
    }
}
