package builder;

import model.CategoryPet;
import model.PetModel;
import model.TagModel;

import java.util.ArrayList;

 public class PetBuilder {

        public PetBuilder(){};

        public long id;
        public String name;
        public String status;
        public CategoryPet categoryPet;
        public ArrayList<String> photoUrls;
        public ArrayList<TagModel> tags;

        public PetBuilder name (String name){
        this.name = name;
        return this;
    }

        public PetBuilder id (int id){
        this.id = id;
        return this;
    }

        public PetBuilder status (String status){
        this.status = status;
        return this;
    }

        public PetBuilder category (CategoryPet categoryPet){
        this.categoryPet = categoryPet;
        return this;
    }

        public PetBuilder photoUrls (ArrayList < String > photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

        public PetBuilder tags (ArrayList < TagModel > tags) {
        this.tags = tags;
        return this;
    }

        public PetModel build () {
        return new PetModel(this);
    }

    }
