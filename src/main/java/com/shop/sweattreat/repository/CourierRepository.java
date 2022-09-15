package com.shop.sweattreat.repository;

import com.shop.sweattreat.model.Courier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
//there is no implementation, because spring boot provides us
//spring data jpa handles the rest for us
public interface CourierRepository extends CrudRepository<Courier,Long> {
    @Query("SELECT name FROM Courier")
    ArrayList<String> getCourierName();

}