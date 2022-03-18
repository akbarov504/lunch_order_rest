package uz.jl.lunch_order_rest.controller.auth;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.jl.lunch_order_rest.controller.AbstractController;
import uz.jl.lunch_order_rest.dto.user.UserCreateDto;
import uz.jl.lunch_order_rest.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/auth/*")
public class AuthController extends AbstractController<UserServiceImpl> {
    public AuthController(UserServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "register/", method = RequestMethod.POST)
    public void register(@RequestBody UserCreateDto dto) {
        service.create(dto);
    }

    @RequestMapping(value = "token/refresh/", method = RequestMethod.GET)
    public void tokenRefresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }
}
