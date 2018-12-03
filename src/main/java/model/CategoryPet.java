package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryPet {
    public CategoryPet(){}
    private long id;
    private String name;

    // Getter Methods
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    // Setter Methods
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}