package com.biblioteka.Biblioteka.gradovi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradService {
    @Autowired
    private GradRepository gradRepository;

    public List<Grad> prikaziSvePodatke(){
        if(!gradRepository.showAllCities().isEmpty()){
            return gradRepository.showAllCities();
        }
        return null;
    }
    public List<String> prikaziNaziveGradova(){
        if(!gradRepository.showNameCities().isEmpty()){
            return gradRepository.showNameCities();
        }
        return null;
    }
    public void gradCreate(Grad gradCreate){
        gradRepository.save(gradCreate);
    }
    public void gradUpdate(Grad gradUpdate){
        gradRepository.save(gradUpdate);
    }
    public void gradDelete(Integer idGrada){
        gradRepository.izbrisiGrad(idGrada);
    }
}
