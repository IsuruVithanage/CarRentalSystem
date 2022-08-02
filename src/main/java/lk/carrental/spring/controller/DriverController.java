package lk.carrental.spring.controller;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.service.CustomerService;
import lk.carrental.spring.service.DriverService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil(200,"Ok",driverService.getAllDrivers());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO driver) {
        driverService.saveDriver(driver);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driver) {
        driverService.updateDriver(driver);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/GenerateDriverID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateDriverID() {
        return new ResponseUtil(200,"Ok",driverService.generateDriverID());
    }

    @GetMapping(path = "/selectDriver",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil selectDriver() {
        return new ResponseUtil(200,"Ok",driverService.selectDriver());
    }

}
