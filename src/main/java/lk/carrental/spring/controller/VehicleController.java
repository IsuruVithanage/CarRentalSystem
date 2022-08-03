package lk.carrental.spring.controller;

import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.dto.VehicleDTO;
import lk.carrental.spring.service.UserService;
import lk.carrental.spring.service.VehicleService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle() {
        return new ResponseUtil(200,"Ok",vehicleService.getAllVehicle());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.saveVehicle(vehicleDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String id) {
        vehicleService.deleteVehicle(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicle(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",vehicleService.searchVehicle(id));
    }

    @GetMapping(path = "/GenerateVehicleID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateVehicleID() {
        return new ResponseUtil(200,"Ok",vehicleService.generateVehicleID());
    }


    @GetMapping(path = "select/{status}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSelectedVehicles(@PathVariable String status) {
        return new ResponseUtil(200,"Ok",vehicleService.getSelectedVehicles(status));
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil setVehicleAvailable(@PathVariable String id) {
        vehicleService.setVehicleAvailable(id);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(path = "maintain/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addToMaintain(@PathVariable String id) {
        vehicleService.addTomaintain(id);
        return new ResponseUtil(200,"Save",null);
    }
}

