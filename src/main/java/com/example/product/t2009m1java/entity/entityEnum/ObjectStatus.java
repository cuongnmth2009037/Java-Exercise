package com.example.product.t2009m1java.entity.entityEnum;

public enum ObjectStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1),
    UNDEFINED(-2);
    private int value;


    ObjectStatus(int value) {this.value = value;}

    public int getValue(){
        return value;
    }

    public static ObjectStatus of(int value){
        for (ObjectStatus objectStatus : ObjectStatus.values()){
            if (objectStatus.getValue() == value){
                return objectStatus;
            }
        }
        return ObjectStatus.UNDEFINED;
    }
}
