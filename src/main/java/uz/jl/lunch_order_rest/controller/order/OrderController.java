package uz.jl.lunch_order_rest.controller.order;

import org.springframework.web.bind.annotation.*;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.order.OrderCreateDto;
import uz.jl.lunch_order_rest.dto.order.OrderDetailDto;
import uz.jl.lunch_order_rest.dto.order.OrderGetDto;
import uz.jl.lunch_order_rest.dto.order.OrderUpdateDto;
import uz.jl.lunch_order_rest.service.order.OrderServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/order/*")
public class OrderController extends AbstractController<OrderServiceImpl> {
    public OrderController(OrderServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public void create(@RequestBody OrderCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public void update(@RequestBody OrderUpdateDto dto) {
        service.update(dto);
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "get/{id}/", method = RequestMethod.GET)
    public OrderGetDto get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public OrderDetailDto detail(@PathVariable(name = "id") Long id) {
        return service.detail(id);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public List<OrderGetDto> list() {
        return service.list();
    }

    @RequestMapping(value = "history/{userId}/", method = RequestMethod.GET)
    public List<OrderGetDto> history(@PathVariable(name = "userId") Long userId) {
        return service.history(userId);
    }
}
