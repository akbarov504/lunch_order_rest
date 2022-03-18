package uz.jl.lunch_order_rest.mapper.menu;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.menu.MenuCreateDto;
import uz.jl.lunch_order_rest.dto.menu.MenuGetDto;
import uz.jl.lunch_order_rest.dto.menu.MenuUpdateDto;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.entity.menu.MenuEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MenuMapper extends GenericMapper<MenuCreateDto, MenuUpdateDto, MenuGetDto, MenuEntity> {
    @Override
    default MenuCreateDto toCreateDto(MenuEntity entity) {
        List<Long> list = new ArrayList<>(7);
        MenuCreateDto dto = new MenuCreateDto();
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setDate(entity.getDate());

        for (MealEntity meal : entity.getMeals()) {
            list.add(meal.getId());
        }

        dto.setMeals(list);
        return dto;
    }

    @Override
    default MenuEntity fromCreateDto(MenuCreateDto dto) {
        MenuEntity entity = new MenuEntity();
        entity.setDate(dto.getDate());
        entity.setMeals(null);
        entity.setCreatedBy(dto.getCreatedBy());
        return entity;
    }

    @Override
    default MenuUpdateDto toUpdateDto(MenuEntity entity) {
        MenuUpdateDto dto = new MenuUpdateDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        return dto;
    }

    @Override
    default MenuEntity fromUpdateDto(MenuUpdateDto dto) {
        MenuEntity entity = new MenuEntity();
        entity.setDate(dto.getDate());
        entity.setMeals(null);
        return entity;
    }

    @Override
    default MenuGetDto toGetDto(MenuEntity entity) {
        List<Long> list = new ArrayList<>(7);
        MenuGetDto dto = new MenuGetDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());

        for (MealEntity meal : entity.getMeals()) {
            list.add(meal.getId());
        }

        dto.setMeals(list);
        return dto;
    }

    @Override
    default MenuEntity fromGetDto(MenuGetDto dto) {
        MenuEntity entity = new MenuEntity();
        entity.setDate(dto.getDate());
        entity.setMeals(null);
        return entity;
    }

    @Override
    default List<MenuGetDto> toGetListDto(List<MenuEntity> entity) {
        List<MenuGetDto> list = new ArrayList<>();
        for (MenuEntity menuEntity : entity) {
            MenuGetDto dto = toGetDto(menuEntity);
            list.add(dto);
        }
        return list;
    }

    @Override
    default List<MenuEntity> fromGetListDto(List<MenuGetDto> dto) {
        List<MenuEntity> entities = new ArrayList<>();
        for (MenuGetDto menuGetDto : dto) {
            MenuEntity entity = fromGetDto(menuGetDto);
            entities.add(entity);
        }
        return entities;
    }
}
