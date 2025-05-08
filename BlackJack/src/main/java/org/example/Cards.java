package org.example;

public class Cards {

    private String suits;
    private String value;

    public Cards(String suit, String value) {
        this.suits = suit;
        this.value = value;
    }

    public String getSuits(){
        return suits;
    }
    public String getValue(){
        return value;
    }
    public int getPointsTotal(){
        String value = getValue();
        switch (value) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11;
            default:
                return Integer.parseInt(value);
        }
    }


}
