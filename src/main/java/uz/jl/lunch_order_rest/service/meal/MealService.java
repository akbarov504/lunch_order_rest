package uz.jl.lunch_order_rest.service.meal;

import uz.jl.lunch_order_rest.dto.meal.MealCreateDto;
import uz.jl.lunch_order_rest.dto.meal.MealDetailDto;
import uz.jl.lunch_order_rest.dto.meal.MealGetDto;
import uz.jl.lunch_order_rest.dto.meal.MealUpdateDto;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

public interface MealService extends GenericCRUDService<MealCreateDto, MealUpdateDto, MealGetDto, Long>, GenericService<MealGetDto, MealDetailDto, Long> {
}
