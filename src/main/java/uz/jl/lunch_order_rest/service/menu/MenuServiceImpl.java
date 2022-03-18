package uz.jl.lunch_order_rest.service.menu;

import org.springframework.stereotype.Service;
import uz.jl.lunch_order_rest.dto.menu.MenuCreateDto;
import uz.jl.lunch_order_rest.dto.menu.MenuDetailDto;
import uz.jl.lunch_order_rest.dto.menu.MenuGetDto;
import uz.jl.lunch_order_rest.dto.menu.MenuUpdateDto;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.entity.menu.MenuEntity;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.menu.MenuMapper;
import uz.jl.lunch_order_rest.repository.menu.MenuRepository;
import uz.jl.lunch_order_rest.service.AbstractService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends AbstractService<MenuMapper, MenuRepository> implements MenuService {
    public MenuServiceImpl(MenuMapper mapper, MenuRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(MenuCreateDto dto) {
        MenuEntity entity = mapper.fromCreateDto(dto);
        List<MealEntity> list = new ArrayList<>();
        for (Long meal : dto.getMeals()) {
            MealEntity mealEntity = new MealEntity();
            mealEntity.setId(meal);
            list.add(mealEntity);
        }
        entity.setMeals(list);
        entity.setCreatedAt(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void update(MenuUpdateDto dto) {
        repository.updateById(dto.getId(), dto.getDate());
    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public MenuGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("Menu not found");
        }));
    }

    @Override
    public MenuDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<MenuGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }

    public List<MenuGetDto> listDate(Date date) {
        return mapper.toGetListDto(repository.findAllByDate(date.toLocalDate()));
    }

    public List<MenuGetDto> listToFrom(Date to, Date from) {
        return mapper.toGetListDto(repository.findAllByToAndFrom(to.toLocalDate(), from.toLocalDate()));
    }

    public void addMeal(Long id, Long mealId) {
        repository.addMealById(id, mealId);
    }

    public void deleteMeal(Long id, Long mealId) {
        repository.deleteMealById(id, mealId);
    }

    public MenuGetDto getToday() {
        LocalDate days = LocalDate.now().minusDays(1);
        return mapper.toGetDto(repository.getToday(days));
    }
}
