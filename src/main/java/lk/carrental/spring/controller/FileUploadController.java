package lk.carrental.spring.controller;

import lk.carrental.spring.service.DriverService;
import lk.carrental.spring.service.VehicleService;
import lk.carrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class FileUploadController {
    @Autowired
    VehicleService vehiservice;
    private static final ArrayList<String> allImages = new ArrayList<>();

    //Formalized end-point to upload files using Spring
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadFileWithSpringWay(@RequestPart("myFile") MultipartFile myFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            //save the path of the uploaded image in the temporary database
            allImages.add("uploads/" + myFile.getOriginalFilename());
            System.out.println("uploads/"+myFile.getOriginalFilename());


            return  ResponseEntity.ok(HttpStatus.OK);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllImagesFromDatabase() {
        return new ResponseEntity(allImages, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveimg(@PathVariable String id) {
        vehiservice.saveImgOne(allImages.get(0),allImages.get(1),allImages.get(2),allImages.get(3),allImages.get(4),id);
        allImages.clear();
        return new ResponseUtil(200,"Save",null);
    }
}
