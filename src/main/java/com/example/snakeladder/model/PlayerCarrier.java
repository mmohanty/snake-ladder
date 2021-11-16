package com.example.snakeladder.model;

import lombok.Data;

@Data
public class PlayerCarrier {

    public PlayerCarrier(){

    }

    public PlayerCarrier(int offset, CarrierType carrierType){
        this.carrierType = carrierType;
        this.offset = offset;
    }
    private int offset;
    private CarrierType carrierType;
}
