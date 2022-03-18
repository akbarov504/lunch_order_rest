package uz.jl.lunch_order_rest.controller.user;

import org.springframework.web.bind.annotation.*;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.user.*;
import uz.jl.lunch_order_rest.service.user.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user/*")
public class UserController extends AbstractController<UserServiceImpl> {
    public UserController(UserServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public void create(@RequestBody UserCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public void update(@RequestBody UserUpdateDto dto) {
        service.update(dto);
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "get/{id}/", method = RequestMethod.GET)
    public UserGetDto get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "get-by-phone/{phone}/", method = RequestMethod.GET)
    public UserGetDto getByPhoneNumber(@PathVariable(name = "phone") String phone) {
        return service.getByPhoneNumber(phone);
    }

    @RequestMapping(value = "get-by-chatId/{chatId}/", method = RequestMethod.GET)
    public UserGetDto getByChatId(@PathVariable(name = "chatId") Integer chatId) {
        return service.getByChatId(chatId);
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public UserDetailDto detail(@PathVariable(name = "id") Long id) {
        return service.detail(id);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public List<UserGetDto> list() {
        return service.list();
    }

    @RequestMapping(value = "accept-department/", method = RequestMethod.POST)
    public void acceptDepartment(@RequestBody UserAcceptDepartmentDto dto) {
        service.acceptDepartment(dto);
    }
}
