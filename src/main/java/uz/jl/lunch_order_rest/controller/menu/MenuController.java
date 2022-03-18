package uz.jl.lunch_order_rest.controller.menu;

import org.springframework.web.bind.annotation.*;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.menu.MenuCreateDto;
import uz.jl.lunch_order_rest.dto.menu.MenuDetailDto;
import uz.jl.lunch_order_rest.dto.menu.MenuGetDto;
import uz.jl.lunch_order_rest.dto.menu.MenuUpdateDto;
import uz.jl.lunch_order_rest.service.menu.MenuServiceImpl;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/menu/*")
public class MenuController extends AbstractController<MenuServiceImpl> {
    public MenuController(MenuServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public void create(@RequestBody MenuCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public void update(@RequestBody MenuUpdateDto dto) {
        service.update(dto);
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "get/{id}/", method = RequestMethod.GET)
    public MenuGetDto get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "get-today/", method = RequestMethod.GET)
    public MenuGetDto getToday() {
        return service.getToday();
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public MenuDetailDto detail(@PathVariable(name = "id") Long id) {
        return service.detail(id);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public List<MenuGetDto> list() {
        return service.list();
    }

    @RequestMapping(value = "list/{date}/", method = RequestMethod.GET)
    public List<MenuGetDto> listDate(@PathVariable(name = "date") Date date) {
        return service.listDate(date);
    }

    @RequestMapping(value = "list/{to}/{from}/", method = RequestMethod.GET)
    public List<MenuGetDto> listToFrom(@PathVariable(name = "to") Date to, @PathVariable(name = "from") Date from) {
        return service.listToFrom(to, from);
    }

    @RequestMapping(value = "{id}/add-meal/{mealId}/", method = RequestMethod.GET)
    public void addMeal(@PathVariable(name = "id") Long id, @PathVariable(name = "mealId") Long mealId) {
        service.addMeal(id, mealId);
    }

    @RequestMapping(value = "{id}/delete-meal/{mealId}/", method = RequestMethod.GET)
    public void deleteMeal(@PathVariable(name = "id") Long id, @PathVariable(name = "mealId") Long mealId) {
        service.deleteMeal(id, mealId);
    }
}
