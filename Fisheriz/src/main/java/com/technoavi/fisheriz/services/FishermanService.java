package com.technoavi.fisheriz.services;

import com.technoavi.fisheriz.dao.FishermanRepository;
import com.technoavi.fisheriz.models.FisherMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FishermanService {
    @Autowired
    private FishermanRepository fishermanRepository;

    public FisherMan createFM(FisherMan fisherMan) {
       return fishermanRepository.save(fisherMan);

    }

    public Optional<FisherMan> getfmbyId(int id) {
        return fishermanRepository.findById(id);
    }

    public Optional<FisherMan> updateFM(int id, FisherMan fisherMan) {
        Optional<FisherMan> fmData=  fishermanRepository.findById(id);
    if(fmData!=null ) {
    FisherMan fm = fmData.get();
    fm.setAddress(fisherMan.getAddress());
    fm.setMobile(fisherMan.getMobile());

    return Optional.of(fishermanRepository.save(fm));
}

        return fmData;
    }

    public boolean deleteFM(int id) {
        Optional<FisherMan> fmData=  fishermanRepository.findById(id);
        if(fmData!=null ) {

fishermanRepository.delete(fmData.get());
           return true;
        }

        return false;
    }

    public List<FisherMan> getAllfm() {
        return  fishermanRepository.findAll();
    }
}
