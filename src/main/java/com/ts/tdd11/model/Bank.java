package com.ts.tdd11.model;

public class Bank {
    private Long id;
    private String name;

    public Bank() {
    }
    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



