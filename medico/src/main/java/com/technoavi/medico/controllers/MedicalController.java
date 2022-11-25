package com.technoavi.medico.controllers;


import com.technoavi.medico.model.Medicine;
import com.technoavi.medico.services.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/medico")
public class MedicalController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping("/msg")
    public String msg() {
        return "ready to place order!!";
    }

     @PostMapping("/save")
    public String saveMedicine(@RequestBody Medicine order) {
        String result = medicalService.saveMedicine(order);
        return result;
    }
    @GetMapping("/getAll")
    public List< Medicine> getAllOrder() {
        return
                medicalService.getAllOrder();
    }

    @GetMapping("/getorder/{id}")
    public ResponseEntity<Medicine>  getMedicineById(@PathVariable("id") int id) {

        Medicine med= medicalService.getMedicineById(id);
        if(med==null){
            return new ResponseEntity<>(med, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(med, HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<Medicine> getMedicineByName(@PathVariable("name") String  name) {

        Medicine response= medicalService.getMedicineByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public Medicine updateOrder(@RequestBody Medicine order) {
        return medicalService.updateOrder(order);
    }

    @DeleteMapping("/delete/{oderId}")
    public String deleteOrder(@PathVariable("oderId") int id) {
        return medicalService.deleteOrder(id);
    }
}


