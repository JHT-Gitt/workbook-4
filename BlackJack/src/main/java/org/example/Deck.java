package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

private ArrayList<Cards> cards;

public Deck(){
    cards = new ArrayList<>();
   // String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
    String[] suits = {"💓","♠️","♦️","♣️"};
    String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","Ace"};

    for(String suit : suits){
        for(String value : values){
            Cards card = new Cards(suit,value);
            cards.add(card);
        }
    }
}
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Cards deal(){

        if(cards.size() > 0){
            Cards card = cards.remove(0);
            return card;
        } else {
            return null;
        }
    }
    public int getSize(){
        return cards.size();
    }



}
