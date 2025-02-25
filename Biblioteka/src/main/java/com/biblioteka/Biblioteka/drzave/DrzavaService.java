package com.biblioteka.Biblioteka.drzave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrzavaService {
    @Autowired
    private DrzavaRepository drzavaRepository;

    public List<Drzava> showCountries(){
        if(!drzavaRepository.findAll().isEmpty()){
            return drzavaRepository.prikaziSveDrzave();
        }
        return null;
    }
    public List<String> showNameCountries(){
        if(!drzavaRepository.findAll().isEmpty()){
            return drzavaRepository.prikaziNaziveDrzava();
        }
        return null;
    }
    public void drzavaCreate(Drzava drzavaCreate){
        drzavaRepository.save(drzavaCreate);
    }
    public void drzavaUpdate(Drzava drzavaUpdate){
        drzavaRepository.save(drzavaUpdate);
    }
    public void drzavaDelete(Integer idDrzave){
        drzavaRepository.deleteById(idDrzave);
    }
}
