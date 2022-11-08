package com.technoavi.fisheriz.controllers;

import com.technoavi.fisheriz.DTO.APIResponse;
import com.technoavi.fisheriz.models.FisherMan;
import com.technoavi.fisheriz.services.FishermanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/fm")
@ApiOperation("Fisherman API")
public class FishermanController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FishermanController.class);

    @Autowired
    private FishermanService fishermanService;

   @GetMapping("/msg")
   public String message(){
       return "Success!!";
   }

   @GetMapping("/getAllfm")
    public ResponseEntity<List<FisherMan>> getAllfm(){
       LOGGER.info("GET getAllfm");
        return new ResponseEntity<>(fishermanService.getAllfm(), HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createFM(@RequestBody FisherMan fisherMan){
        APIResponse a= new APIResponse();
       FisherMan m= fishermanService.createFM(fisherMan);
       a.setData(m);
       a.setResponseMessage("Fisher Man Created Suuccessfully");
        a.setResponseCode(1110);
       return new ResponseEntity<>(a,HttpStatus.OK);

    }
    @ApiOperation(value = "Get a FisherMan by id", notes = "Returns a fisherMan as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The FisherMan was not found")
    })
    @GetMapping("/getfmbyId/{id}")
    public ResponseEntity<?> getfmbyId( @PathVariable int id
//            @ApiParam(
//            name =  "fisher Id",
//            type = "int",
//            value = "Id of the fisher man",
//            example = "1",
//            required = true)
           ){
        LOGGER.info("GET getfmbyId/{} - OK");
        try {
            Optional<FisherMan> fm = fishermanService.getfmbyId(id);

            if (fm.isPresent()) {
                LOGGER.info("GET getfmbyId/{} - OK", id);
                return new ResponseEntity<FisherMan>(fm.get(), HttpStatus.OK);
            } else {
                LOGGER.warn("GET getfmbyId/{} - NOT FOUND", id);
                return new ResponseEntity<>("No record with this id " ,HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            LOGGER.error("GET getfmbyId/{} - ERROR: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Optional<FisherMan>> updateFM(@PathVariable(value="id") int id,
                                              @RequestBody FisherMan fisherMan){
        return new ResponseEntity<>(fishermanService.updateFM(id,fisherMan), HttpStatus.ACCEPTED);

    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteFM(@PathVariable(value="id") int id){

        try {
           if( fishermanService.deleteFM(id));
                return new ResponseEntity<>("Deleted !!",HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>("No Data Found!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
