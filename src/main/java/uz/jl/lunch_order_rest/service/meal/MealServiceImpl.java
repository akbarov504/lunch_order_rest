package uz.jl.lunch_order_rest.service.meal;

import org.springframework.stereotype.Service;
import uz.jl.lunch_order_rest.dto.meal.MealCreateDto;
import uz.jl.lunch_order_rest.dto.meal.MealDetailDto;
import uz.jl.lunch_order_rest.dto.meal.MealGetDto;
import uz.jl.lunch_order_rest.dto.meal.MealUpdateDto;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.meal.MealMapper;
import uz.jl.lunch_order_rest.repository.meal.MealRepository;
import uz.jl.lunch_order_rest.service.AbstractService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MealServiceImpl extends AbstractService<MealMapper, MealRepository> implements MealService {
    public MealServiceImpl(MealMapper mapper, MealRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(MealCreateDto dto) {
        MealEntity entity = mapper.fromCreateDto(dto);
        entity.setCode(UUID.randomUUID());
        entity.setCreatedAt(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void update(MealUpdateDto dto) {
        repository.updateById(dto.getId(), dto.getName(), dto.getType(), dto.getImage());
    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public MealGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("Meal not found");
        }));
    }

    @Override
    public MealDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<MealGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }

    public MealGetDto getByName(String name) {
        return mapper.toGetDto(repository.findByName(name));
    }
}
