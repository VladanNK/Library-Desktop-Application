package com.biblioteka.Biblioteka.izdavackeKuce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzdavackaKucaService {
    @Autowired
    private IzdavackaKucaRepository izdavackaKucaRepository;

    public List<IzdavackaKuca> sviPodaciIzdavackihKuca(){
        if(!izdavackaKucaRepository.findAll().isEmpty()){
            return izdavackaKucaRepository.podaciIzdavackihKuca();
        }
        return null;
    }
    public List<String> sviPodaciIKBezID(){
        if(!izdavackaKucaRepository.findAll().isEmpty()){
            return izdavackaKucaRepository.podaciBezId();
        }
        return null;
    }
    public void createIzdavackaKuca(IzdavackaKuca izdavackaKucaCreate){
        izdavackaKucaRepository.save(izdavackaKucaCreate);
    }
    public void updateIzdavackaKuca(IzdavackaKuca izdavackaKucaUpdate){
        izdavackaKucaRepository.save(izdavackaKucaUpdate);
    }
    public void deleteIzdavackaKuca(Integer id_IzdavackeKuce){
        izdavackaKucaRepository.izbrisiIK(id_IzdavackeKuce);
    }
}
