package com.example.softlearning.applicationcore.entity.order.mappers;

import com.example.softlearning.applicationcore.entity.order.dtos.OrderDTO;
import com.example.softlearning.applicationcore.entity.order.model.Order;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderMapper {
    public static Order orderFromDTO(OrderDTO orderDTO)throws BuildException{
        return Order.getInstanceOrder(
            orderDTO.getReference(),
            orderDTO.getDescription(),
            orderDTO.getInitDate(),
            orderDTO.getAddress(),
            orderDTO.getPhoneContact(),
            orderDTO.getIdClient(),
            orderDTO.getName(),
            orderDTO.getSurname(),
            orderDTO.getDNI(),
            orderDTO.getPaymentDate(),
            orderDTO.getDeliveryDate(),
            orderDTO.getFinishDate(),
            orderDTO.getHigh(),
            orderDTO.getWidth(),
            orderDTO.getDepth(),
            orderDTO.getWeight(),
            orderDTO.getisFragil(),
            orderDTO.getLength(),
            orderDTO.getShopCartDetails()
        );
    }

    public static OrderDTO dtoFromOrder(Order o){
        return new OrderDTO(
            o.getReference(),
            o.getDescription(),
            o.getInitDate(),
            o.getAddress(),
            o.getPhoneContact(),
            o.getIdClient(),
            o.getName(),
            o.getSurname(),
            o.getDNI(),
            o.getPaymentDate(),
            o.getDeliveryDate(),
            o.getFinishDate(),
            o.getHigh(),
            o.getWidth(),
            o.getDepth(),
            o.getWeight(),
            o.getFragil(),
            o.getLength(),
            o.getShopCartDetails()
        );
    }
}