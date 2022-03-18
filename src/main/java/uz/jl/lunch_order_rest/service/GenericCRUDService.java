package uz.jl.lunch_order_rest.service;

import uz.jl.lunch_order_rest.dto.BaseDto;
import uz.jl.lunch_order_rest.dto.GenericDto;

import java.io.Serializable;

public interface GenericCRUDService<CD extends BaseDto, UD extends GenericDto, GD extends GenericDto, K extends Serializable> {
    void create(CD dto);

    void update(UD dto);

    void delete(K key);

    GD get(K key);
}
