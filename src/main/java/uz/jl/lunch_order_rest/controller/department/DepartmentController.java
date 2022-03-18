package uz.jl.lunch_order_rest.controller.department;

import org.springframework.web.bind.annotation.*;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.department.DepartmentCreateDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentDetailDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentGetDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentUpdateDto;
import uz.jl.lunch_order_rest.service.department.DepartmentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/department/*")
public class DepartmentController extends AbstractController<DepartmentServiceImpl> {
    public DepartmentController(DepartmentServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public void create(@RequestBody DepartmentCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public void update(@RequestBody DepartmentUpdateDto dto) {
        service.update(dto);
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "get/{id}/", method = RequestMethod.GET)
    public DepartmentGetDto get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "get-by-name/{name}/", method = RequestMethod.GET)
    public DepartmentGetDto getByName(@PathVariable(name = "name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public DepartmentDetailDto detail(@PathVariable(name = "id") Long id) {
        return service.detail(id);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public List<DepartmentGetDto> list() {
        return service.list();
    }
}
