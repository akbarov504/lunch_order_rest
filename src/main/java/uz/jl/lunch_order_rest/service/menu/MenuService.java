package uz.jl.lunch_order_rest.service.menu;

import uz.jl.lunch_order_rest.dto.menu.MenuCreateDto;
import uz.jl.lunch_order_rest.dto.menu.MenuDetailDto;
import uz.jl.lunch_order_rest.dto.menu.MenuGetDto;
import uz.jl.lunch_order_rest.dto.menu.MenuUpdateDto;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

public interface MenuService extends GenericCRUDService<MenuCreateDto, MenuUpdateDto, MenuGetDto, Long>, GenericService<MenuGetDto, MenuDetailDto, Long> {
}
