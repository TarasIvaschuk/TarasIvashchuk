package model;

import builder.StoreBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class StoreModel {
        StoreModel(){};
        @JsonProperty("id")
        private long id;

        @JsonProperty("petId")
        private long petId;

        @JsonProperty("quantity")
        private long quantity;

        @JsonProperty("shipDate")
        private String shipDate;

        @JsonProperty("statusEnum")
        private StatusEnum statusEnum;

        @JsonProperty("complete")
        private boolean complete=false;


        // Getter Methods

        public long getId() {
            return id;
        }

        public long getPetId() {
            return petId;
        }

        public long getQuantity() {
            return quantity;
        }

        public String getShipDate() {
            return shipDate;
        }

        public StatusEnum getStatusEnum() {
            return statusEnum;
        }

        public boolean getComplete() {
            return complete;
        }

        // Setter Methods

        public void setId(long id) {
            this.id = id;
        }

        public void setPetId(long petId) {
            this.petId = petId;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public void setShipDate(String shipDate) {
            this.shipDate = shipDate;
        }

        public void setStatusEnum(StatusEnum statusEnum) {
            this.statusEnum = statusEnum;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public StoreModel(StoreBuilder builder) {
            this.id = builder.id;
            this.petId = builder.petId;
            this.quantity = builder.quantity;
            this.shipDate = builder.shipDate;
            this.statusEnum = builder.statusEnum;
            this.complete = builder.complete;

        }
    }






