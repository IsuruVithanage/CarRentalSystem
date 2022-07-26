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

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRentReq(@ModelAttribute RentReqDTO rentReqDTO) {
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

}
