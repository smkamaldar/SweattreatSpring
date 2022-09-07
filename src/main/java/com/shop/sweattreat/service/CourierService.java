package com.shop.sweattreat.service;

import com.shop.sweattreat.model.Courier;

import java.util.List;

public interface CourierService {
    List<Courier> listCourier();

    Courier findCourier(long id) ;
    List<Courier> availableCouriers();
    Courier addCourier(Courier courier);
    Courier book(String time, int mileage, boolean needRefrigrator);
    void delete(Long id);


}
