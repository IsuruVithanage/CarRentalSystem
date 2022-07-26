package lk.carrental.spring.controller;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.service.DriverService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rentreq")
@CrossOrigin
public class RentReqController {
    @Autowired
    DriverService driverService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil(200,"Ok",driverService.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driver) {
        driverService.saveDriver(driver);
        return new ResponseUtil(200,"Save",null);
    }

}
