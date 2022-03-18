package uz.jl.lunch_order_rest.controller.complaint;

import org.springframework.web.bind.annotation.*;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintCreateDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintDetailDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintGetDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintUpdateDto;
import uz.jl.lunch_order_rest.service.complaint.ComplaintServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/complaint/*")
public class ComplaintController extends AbstractController<ComplaintServiceImpl> {
    public ComplaintController(ComplaintServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public void create(@RequestBody ComplaintCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public void update(@RequestBody ComplaintUpdateDto dto) {
        service.update(dto);
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "get/{id}/", method = RequestMethod.GET)
    public ComplaintGetDto get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public ComplaintDetailDto detail(@PathVariable(name = "id") Long id) {
        return service.detail(id);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public List<ComplaintGetDto> list() {
        return service.list();
    }

    @RequestMapping(value = "list/{userId}/", method = RequestMethod.GET)
    public List<ComplaintGetDto> listById(@PathVariable(name = "userId") Long userId) {
        return service.list(userId);
    }
}
