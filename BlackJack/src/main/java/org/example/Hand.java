package org.example;

import java.util.ArrayList;

public class Hand extends Player {

    public Hand(String name) {
        super(name);
    }
     ArrayList<Cards> cards = new ArrayList<>();

    public void deal(Cards card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    public int getValue(){
        int value = 0;
        for (Cards c : cards){
            value += c.getPointsTotal();
        }
        return value;
    }

}
