package uz.jl.lunch_order_rest.service.order;

import org.springframework.stereotype.Service;
import uz.jl.lunch_order_rest.dto.order.OrderCreateDto;
import uz.jl.lunch_order_rest.dto.order.OrderDetailDto;
import uz.jl.lunch_order_rest.dto.order.OrderGetDto;
import uz.jl.lunch_order_rest.dto.order.OrderUpdateDto;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.entity.order.OrderEntity;
import uz.jl.lunch_order_rest.entity.user.UserEntity;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.order.OrderMapper;
import uz.jl.lunch_order_rest.repository.order.OrderRepository;
import uz.jl.lunch_order_rest.service.AbstractService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends AbstractService<OrderMapper, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderMapper mapper, OrderRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(OrderCreateDto dto) {
        UserEntity user = new UserEntity();
        MealEntity meal = new MealEntity();

        OrderEntity entity = mapper.fromCreateDto(dto);
        entity.setCreatedAt(LocalDateTime.now());

        user.setId(dto.getUserId());
        meal.setId(dto.getMealId());

        entity.setUser(user);
        entity.setMeal(meal);
        entity.setReceive(entity.getReceive());
        entity.setToTake(entity.getToTake());

        repository.save(entity);
    }

    @Override
    public void update(OrderUpdateDto dto) {
        repository.updateById(dto.getId(), dto.getDate(), dto.getReceive(), dto.getToTake(), dto.getUserId(), dto.getMealId());
    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public OrderGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("Order not found");
        }));
    }

    @Override
    public OrderDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<OrderGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }

    public List<OrderGetDto> history(Long userId) {
        List<OrderGetDto> dtoList = new ArrayList<>();
        List<OrderEntity> entityList = repository.findAllByUserId(userId);
        for (OrderEntity order : entityList) {
            OrderGetDto dto = new OrderGetDto();
            dto.setId(order.getId());
            dto.setDate(order.getDate());
            dto.setReceive(order.getReceive());
            dto.setToTake(order.getToTake());
            dto.setMealId(order.getMeal().getId());
            dto.setUserId(order.getUser().getId());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
