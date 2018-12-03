package model;

import builder.PetBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)

public class PetModel {
  //  @JsonProperty("id")
    private long id;

//    @JsonProperty("categoryPet")
    private CategoryPet categoryPet;

//    @JsonProperty("name")
    private String name;

//    @JsonProperty("statusEnum")
    public String status;

//    @JsonProperty("photoUrls")
    private ArrayList<String> photoUrls = new ArrayList();

//    @JsonProperty("tags")
    private ArrayList<TagModel> tags = new ArrayList();


    public PetModel () {};

    public PetModel(PetBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.status = builder.status;
        this.categoryPet = builder.categoryPet;
        this.tags = builder.tags;
    }

    // Getter Methods
    public long getId() {
        return this.id;
    }

    public CategoryPet getCategoryPet() {
        return categoryPet;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
    /*
    // Setter Methods
    public void setId(float id) {
        this.id = id;
    }
    public void setCategory(CategoryPet categoryObject) {
        this.CategoryObject = categoryObject;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatusEnum(String statusEnum) {
        this.statusEnum = statusEnum;


*/

}
