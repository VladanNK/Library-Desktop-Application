package com.biblioteka.Biblioteka.drzave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

//Ovde sve radi

@RestController
public class DrzavaController {
    @Autowired
    private DrzavaService drzavaService;

    @GetMapping("/allDrzave")
    public List<Drzava> allCountries(){
        return drzavaService.showCountries();
    }
    @GetMapping("/nameCountries")
    public List<String> nameCountries(){
        return drzavaService.showNameCountries();
    }
    @PostMapping("/createDrzava")
    public void createDrzava(@RequestBody Drzava createDrzava){
        drzavaService.drzavaCreate(createDrzava);
    }
    @PutMapping("/updateDrzava/{id}")
    public String updateDrzava(@PathVariable Integer id, @RequestBody Drzava updateDrzava){
        if(id != null && id.equals(updateDrzava.getId_drzave())){
            drzavaService.drzavaUpdate(updateDrzava);
            return "Uspesno azurirana drzava!";
        }
        return "Nije pronadjena drzava sa datim ID-jem!";
    }
    @DeleteMapping("/deleteDrzava/{id}")
    public String deleteDrzava(@PathVariable Integer id){
        drzavaService.drzavaDelete(id);
        return "Uspesno obrisana drzava!";
    }
}