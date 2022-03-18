package uz.jl.lunch_order_rest.service.department;

import uz.jl.lunch_order_rest.dto.department.DepartmentCreateDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentDetailDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentGetDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentUpdateDto;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

public interface DepartmentService extends GenericCRUDService<DepartmentCreateDto, DepartmentUpdateDto, DepartmentGetDto, Long>, GenericService<DepartmentGetDto, DepartmentDetailDto, Long> {
}
