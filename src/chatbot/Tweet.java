package chatbot;

import java.util.ArrayList;

/*
 * This is a type definition for Tweet that implements Comparable.
 */

public class Tweet implements Comparable<Tweet> {

    /*instance variables*/
    String hashtag;
    ArrayList yorum;
    Double kutupDegeri;

    /*constructor*/
    public Tweet(String hashtag, ArrayList yorum, Double kutupDegeri) {
        this.hashtag = hashtag;
        this.yorum = yorum;
        this.kutupDegeri = kutupDegeri;
    }

    /*setters and getters*/
    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public ArrayList getYorum() {
        return yorum;
    }

    public void setYorum(ArrayList yorum) {
        this.yorum = yorum;
    }

    public Double getKutupDegeri() {
        return kutupDegeri;
    }

    public void setKutupDegeri(Double kutupDegeri) {
        this.kutupDegeri = kutupDegeri;
    }
//compareTo(Tweet o)

    @Override
    public int compareTo(Tweet o) {

        return new Double(this.kutupDegeri).compareTo(o.kutupDegeri);

    }

}
