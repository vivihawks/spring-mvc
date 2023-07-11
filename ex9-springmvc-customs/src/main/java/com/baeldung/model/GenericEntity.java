package com.baeldung.model;

public class GenericEntity {
    private Long id;
    private String value;

    public GenericEntity() {
    }

    public GenericEntity(String value) {
        this.value = value;
    }

    public GenericEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
