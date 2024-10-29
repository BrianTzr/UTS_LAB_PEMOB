package com.example.uts;

public class Post {

    private String name;
    private String desc;

    public Post(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
