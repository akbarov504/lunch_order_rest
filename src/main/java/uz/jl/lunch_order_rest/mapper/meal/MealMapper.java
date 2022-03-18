package uz.jl.lunch_order_rest.mapper.meal;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.meal.MealCreateDto;
import uz.jl.lunch_order_rest.dto.meal.MealGetDto;
import uz.jl.lunch_order_rest.dto.meal.MealUpdateDto;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface MealMapper extends GenericMapper<MealCreateDto, MealUpdateDto, MealGetDto, MealEntity> {
}
