package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

	//What's here?

    private int id;
    private String note;
    private int stars;

    public Note(int id, String note, int stars) {
        this.id = id;
        this.note = note;
        this.stars = stars;
    }

    public int getId() { return id; }

    public String getNote() { return note; }

    public int getStars() { return stars;}

}
