package com.biblioteka.Biblioteka.biblioteke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotekaService {
    @Autowired
    private BibliotekaRepository bibliotekaRepository;

    public List<Biblioteka> sveBiblioteke(){
        if(!bibliotekaRepository.findAll().isEmpty()){
            return bibliotekaRepository.prikaziSve();
        }
        return null;
    }
    public List<Integer> sveIDBiblioteka(){
        if(!bibliotekaRepository.findAll().isEmpty()){
            return bibliotekaRepository.sveIdBiblioteke();
        }
        return null;
    }
    public List<String> sveBibliotekeOsimID(){
        return bibliotekaRepository.sveBibliotekeOsimID();
    }
    public void createBiblioteka(Biblioteka bibliotekaCreate){
        bibliotekaRepository.save(bibliotekaCreate);
    }
    public void updateBiblioteka(Biblioteka bibliotekaUpdate){
        bibliotekaRepository.save(bibliotekaUpdate);
    }
    /*public void deleteBiblioteka(Integer idBiblioteke){
        bibliotekaRepository.deleteById(idBiblioteke);
    }*/
    public void deleteBiblioteka(int idBiblioteke){
        bibliotekaRepository.obrisiBiblioteku(idBiblioteke);
    }
}
