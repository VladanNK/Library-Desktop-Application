package com.biblioteka.Biblioteka.izdavackeKuce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Ovde sve radi
@RestController
public class IzdavackaKucaController {
    @Autowired
    private IzdavackaKucaService izdavackaKucaService;

    @GetMapping("/allIzdavackeKuce")
    public List<IzdavackaKuca> allIzdavackeKuce(){
        return izdavackaKucaService.sviPodaciIzdavackihKuca();
    }
    @GetMapping("/nameIzdavackihKuca")
    public List<String> nameIzdavackihKuca(){
        return izdavackaKucaService.sviPodaciIKBezID();
    }
    @PostMapping("/createIzdavackaKuca")
    public void createIzdavackaKuca(@RequestBody IzdavackaKuca izdavackaKucaCreate){
        izdavackaKucaService.createIzdavackaKuca(izdavackaKucaCreate);
    }
    @PutMapping("/updateIzdavackaKuca/{id}")
    public String updateIzdavackaKuca(@PathVariable Integer id, @RequestBody IzdavackaKuca izdavackaKucaUpdate){
        if(id != null && id.equals(izdavackaKucaUpdate.getIzdavacka_kuca_id())){
            izdavackaKucaService.updateIzdavackaKuca(izdavackaKucaUpdate);
            return "Uspesno azurirana Izdavacka Kuca!";
        }
        return "Nije pronadjena izdavacka kuca sa datim ID-jem!";
    }
    @DeleteMapping("/deleteIzdavackaKuca/{id}")
    public String deleteIzdavackaKuca(@PathVariable Integer id){
        if(id != null){
            izdavackaKucaService.deleteIzdavackaKuca(id);
            return "Uspesno izbrisana izdavacka kuca!";
        }
        return "Nije pronadjena izdavacka kuca sa datim ID-jem!";
    }
}