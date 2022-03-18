package uz.jl.lunch_order_rest.controller.meal;

import org.springframework.web.bind.annotation.*;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.meal.MealCreateDto;
import uz.jl.lunch_order_rest.dto.meal.MealDetailDto;
import uz.jl.lunch_order_rest.dto.meal.MealGetDto;
import uz.jl.lunch_order_rest.dto.meal.MealUpdateDto;
import uz.jl.lunch_order_rest.service.meal.MealServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/meal/*")
public class MealController extends AbstractController<MealServiceImpl> {
    public MealController(MealServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public void create(@RequestBody MealCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public void update(@RequestBody MealUpdateDto dto) {
        service.update(dto);
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "get/{id}/", method = RequestMethod.GET)
    public MealGetDto get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "get-by-name/{name}/", method = RequestMethod.GET)
    public MealGetDto getByName(@PathVariable(name = "name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public MealDetailDto detail(@PathVariable(name = "id") Long id) {
        return service.detail(id);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public List<MealGetDto> list() {
        return service.list();
    }
}
