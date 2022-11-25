package com.technoavi.medico.services;

import com.technoavi.medico.dao.MedicineRepository;
import com.technoavi.medico.model.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicalService {
    //List< Order> listOfOrders= new ArrayList();
    Map<Long, Medicine> listOfOrders = new HashMap();
    Random r = new Random();

    @Autowired
    private MedicineRepository medicineRepository;

    public String saveMedicine(Medicine medicine) {

        Medicine med = new Medicine();
        med.setComposition(medicine.getComposition());
        med.setExpiryDate(medicine.getExpiryDate());
        med.setName(medicine.getName());
        med.setQuantity(medicine.getQuantity());
        med.setDosage(medicine.getDosage());
        med.setPrice(medicine.getPrice());
        //    listOfOrders.add(newOrder);
       medicineRepository.save(med);
      //  listOfOrders.put(med.getId(), med);


        return " Your order of :" + med.getName() + " has been placed and order Id is :" + med.getId();
    }

    public List<Medicine> getAllOrder() {


        return medicineRepository.findAll();
    }

    public Medicine getMedicineById( long id) {
   Optional<Medicine> med= medicineRepository.findById(id);
if(med.get()==null){
    return null;
}
else
        return med.get();

    }

    public Medicine updateOrder( Medicine medicine) {

        long id = 0;
//        for(int i=0; i<listOfOrders.size();i++) {
//            if (listOfOrders.get(i).getOrderId() == (order.getOrderId())) {
//                id = order.getOrderId();
//                break;
//            }
//        }
        Iterator hmIterator = listOfOrders.entrySet().iterator();


        while (hmIterator.hasNext()) {
            if (listOfOrders.containsKey(medicine.getId())) {
                id = medicine.getId();
                break;

            }

        }

        //updated
        Medicine med = new Medicine();
        med.setComposition(medicine.getComposition());
        med.setExpiryDate(medicine.getExpiryDate());
        med.setName(medicine.getName());
        med.setQuantity(medicine.getQuantity());
        med.setDosage(medicine.getDosage());
        med.setPrice(medicine.getPrice());
        //  listOfOrders.add(id,upOrder);
        return med;

    }

    public String deleteOrder(int id) {
        // listOfOrders.remove(id);
        //  listOfOrders.removeIf(order-> order.getOrderId()==(id));
        listOfOrders.remove(id);
        return "Oder id" + id + " id cancelled!!";
    }

    public Medicine getMedicineByName(String name) {

        return medicineRepository.getMedicineByName(name);
    }
}
