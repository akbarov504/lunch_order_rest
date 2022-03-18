package uz.jl.lunch_order_rest.service.order;

import uz.jl.lunch_order_rest.dto.order.OrderCreateDto;
import uz.jl.lunch_order_rest.dto.order.OrderDetailDto;
import uz.jl.lunch_order_rest.dto.order.OrderGetDto;
import uz.jl.lunch_order_rest.dto.order.OrderUpdateDto;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

public interface OrderService extends GenericCRUDService<OrderCreateDto, OrderUpdateDto, OrderGetDto, Long>, GenericService<OrderGetDto, OrderDetailDto, Long> {
}
