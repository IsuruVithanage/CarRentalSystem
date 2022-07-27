package lk.carrental.spring.controller;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.PaymentDTO;
import lk.carrental.spring.service.DriverService;
import lk.carrental.spring.service.PaymentService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayments() {
        return new ResponseUtil(200, "Ok", paymentService.getAllPayments());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@ModelAttribute PaymentDTO paymentDTO) {
        paymentService.savePayment(paymentDTO);
        return new ResponseUtil(200, "Save", null);
    }

    @GetMapping(path = "/GeneratePaymentID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generatePaymentID() {
        return new ResponseUtil(200,"Ok",paymentService.generatePaymentID());
    }

}
