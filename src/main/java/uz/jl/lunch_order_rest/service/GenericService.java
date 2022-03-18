package uz.jl.lunch_order_rest.service;

import uz.jl.lunch_order_rest.dto.GenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService<GD extends GenericDto, DD extends GenericDto, K extends Serializable> {
    DD detail(K key);

    List<GD> list();

    Long totalCount();
}
