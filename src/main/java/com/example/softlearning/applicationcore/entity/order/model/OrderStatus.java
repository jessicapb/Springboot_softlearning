package com.example.softlearning.applicationcore.entity.order.model;

public enum OrderStatus {
    CREATED,
    CANCELLED,
    CONFIRMED,
    FORTHCOMMING,//paquete preparado y almacenado pendiente de envio
    DELIVERED,
    FINISHED
}
