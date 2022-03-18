package uz.jl.lunch_order_rest.mapper.order;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.order.OrderCreateDto;
import uz.jl.lunch_order_rest.dto.order.OrderGetDto;
import uz.jl.lunch_order_rest.dto.order.OrderUpdateDto;
import uz.jl.lunch_order_rest.entity.order.OrderEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<OrderCreateDto, OrderUpdateDto, OrderGetDto, OrderEntity> {
}
