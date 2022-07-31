package lk.carrental.spring.controller;

import lk.carrental.spring.dto.RentReqDTO;
import lk.carrental.spring.dto.RequestDeniedDetailsDTO;
import lk.carrental.spring.service.RentReqService;
import lk.carrental.spring.service.RequestDeniedDetailsService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reqdeny")
@CrossOrigin
public class RequestDeniedDetailsController {
    @Autowired
    RequestDeniedDetailsService requestDeniedDetailsService;

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRentReq() {
        return new ResponseUtil(200,"Ok",requestDeniedDetailsService.getAllRentReq());
    }*/


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDeniedReq(@RequestBody RequestDeniedDetailsDTO requestDeniedDetailsDTO) {
        requestDeniedDetailsService.saveDeniedReq(requestDeniedDetailsDTO);
        return new ResponseUtil(200,"Save",null);
    }
}
