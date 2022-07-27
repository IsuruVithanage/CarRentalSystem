package lk.carrental.spring.controller;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.service.DriverService;
import lk.carrental.spring.service.UserService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers() {
        return new ResponseUtil(200,"Ok",userService.getAllUsers());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUsers(@ModelAttribute UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/GenerateUserID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateUserID() {
        return new ResponseUtil(200,"Ok",userService.generateUserID());
    }

}
