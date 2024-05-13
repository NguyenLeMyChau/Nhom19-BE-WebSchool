package vn.edu.iuh.fit.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.core.models.Response;
import vn.edu.iuh.fit.core.models.Student;
import vn.edu.iuh.fit.core.services.LoginServices;

import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginServices loginServices;

    @PostMapping("/")
    public Response login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        Student student = loginServices.checkLogin(username, password);

        Response response = new Response();
        if(student != null) {
            response.setStatus(200);
            response.setMessage("Login successful");
            response.setObject(student);
        } else {
            response.setStatus(400);
            response.setMessage("Invalid username or password");
            response.setObject(null);
        }
        return response;
    }
}
