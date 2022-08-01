package lk.carrental.spring.controller;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.RentReqDTO;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.service.DriverService;
import lk.carrental.spring.service.RentReqService;
import lk.carrental.spring.service.UserService;
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
    RentReqService rentReqService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRentReq() {
        return new ResponseUtil(200,"Ok",rentReqService.getAllRentReq());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRentReq(@RequestBody RentReqDTO rentReqDTO) {
        rentReqService.saveRentReq(rentReqDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRentReq(@RequestBody RentReqDTO rentReqDTO) {
        rentReqService.updateRentReq(rentReqDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRentReq(@RequestParam String id) {
        rentReqService.deleteRentReq(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/GenerateRentReqID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateRentReqID() {
        return new ResponseUtil(200,"Ok",rentReqService.generateRentReqID());
    }

    @PutMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil confirmReq(@RequestParam String id) {
        rentReqService.confirmReq(id);
        return new ResponseUtil(200,"Ok",null);
    }

    @PutMapping(path = "denyReq/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deniedReq(@PathVariable String id) {
        rentReqService.deniedmReq(id);
        return new ResponseUtil(200,"Ok",null);
    }

    @GetMapping(path = "pendingreq/{status}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getReq(@PathVariable String status) {
        return new ResponseUtil(200,"Ok",rentReqService.getReq(status));
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRentReq(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",rentReqService.searchReq(id));
    }


}
