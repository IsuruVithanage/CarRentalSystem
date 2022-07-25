package lk.carrental.spring.controller;

import lk.carrental.spring.dto.AdminDTO;
import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.service.AdminService;
import lk.carrental.spring.service.CustomerService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;


    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO admin) {
        adminService.saveAdmin(admin);
        return new ResponseUtil(200,"Save",null);
    }

}
