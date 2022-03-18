package uz.jl.lunch_order_rest.mapper.department;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.department.DepartmentCreateDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentGetDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentUpdateDto;
import uz.jl.lunch_order_rest.entity.department.DepartmentEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper extends GenericMapper<DepartmentCreateDto, DepartmentUpdateDto, DepartmentGetDto, DepartmentEntity> {
}
