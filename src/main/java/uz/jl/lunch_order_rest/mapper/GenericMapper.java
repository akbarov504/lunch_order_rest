package uz.jl.lunch_order_rest.mapper;

import uz.jl.lunch_order_rest.dto.BaseDto;
import uz.jl.lunch_order_rest.dto.GenericDto;
import uz.jl.lunch_order_rest.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDto, UD extends GenericDto, GD extends GenericDto, E extends BaseEntity> extends BaseMapper {
    CD toCreateDto(E entity);

    E fromCreateDto(CD dto);

    UD toUpdateDto(E entity);

    E fromUpdateDto(UD dto);

    GD toGetDto(E entity);

    E fromGetDto(GD dto);

    List<GD> toGetListDto(List<E> entity);

    List<E> fromGetListDto(List<GD> dto);
}
