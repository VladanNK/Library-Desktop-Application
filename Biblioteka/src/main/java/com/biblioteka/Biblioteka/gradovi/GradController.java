package com.biblioteka.Biblioteka.gradovi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ovde sve radi
@RestController
public class GradController {
    @Autowired
    private GradService gradService;

    @GetMapping("/allGradovi")
    public List<Grad> allGradovi(){
        return gradService.prikaziSvePodatke();
    }
    @GetMapping("/nameGradovi")
    public List<String> nameGradovi(){
        return gradService.prikaziNaziveGradova();
    }
    @PostMapping("/createGrad")
    public void createGrad(@RequestBody Grad gradCreate){
        gradService.gradCreate(gradCreate);
    }
    @PutMapping("/updateGrad/{id}")
    public String updateGrad(@PathVariable Integer id, @RequestBody Grad gradUpdate){
        if(id != null && id.equals(gradUpdate.getId_grada())){
            gradService.gradUpdate(gradUpdate);
            return "Uspesno azuriran grad!";
        }
        return "Nije pronadjen grad sa datim ID-jem!";
    }
    @DeleteMapping("/deleteGrad/{id}")
    public String deleteGrad(@PathVariable Integer id){
        gradService.gradDelete(id);
        return "Uspesno obrisan grad!";
    }
}
