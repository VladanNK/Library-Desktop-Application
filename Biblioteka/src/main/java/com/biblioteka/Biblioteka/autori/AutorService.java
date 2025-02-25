package com.biblioteka.Biblioteka.autori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> prikaziPodatkeAutora(){
        return autorRepository.prikaziSveAutore();
    }
    public List<Integer> uzmiIDAutora(){
        return autorRepository.prikaziSveAutoreId();
    }
    public List<String> uzmiSvePodatkeOsimID(){
        return autorRepository.prikaziSveAutoreOsimID();
    }
    public void createAutor(Autor autorCreate){
        autorRepository.save(autorCreate);
    }
    public void updateAutor(Autor autorUpdate){
        autorRepository.save(autorUpdate);
    }
    public void deleteAutor(Integer idAutora){
        autorRepository.deleteById(idAutora);
    }
}
