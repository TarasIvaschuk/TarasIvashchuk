package builder;

import model.StatusEnum;
import model.StoreModel;

public class StoreBuilder {
    public long id;
    public long petId;
    public long quantity;
    public String shipDate;
    public StatusEnum statusEnum;
    public boolean complete;

    public StoreBuilder id (long id){
        this.id=id;
        return this;
    }
    public StoreBuilder petId (long petId){
        this.petId=petId;
        return this;
    }
    public StoreBuilder quantity (long quantity){
        this.quantity=quantity;
        return this;
    }
    public StoreBuilder shipDate (String shipDate){
        this.shipDate=shipDate;
        return this;
    }
    public StoreBuilder status (StatusEnum statusEnum){
        this.statusEnum = statusEnum;
        return this;
    }
    public StoreBuilder complete (Boolean complete){
        this.complete=complete;
        return this;
    }
    public StoreModel build (){
          return new StoreModel(this);
    }
}
