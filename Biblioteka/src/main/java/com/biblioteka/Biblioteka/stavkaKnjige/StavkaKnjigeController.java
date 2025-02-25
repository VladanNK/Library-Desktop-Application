package com.biblioteka.Biblioteka.stavkaKnjige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StavkaKnjigeController {
    @Autowired
    private StavkaKnjigeService stavkaKnjigeService;

    @GetMapping("/allStavkaKnjige")
    public List<StavkaKnjige> allStavkaKnjige(){
        return stavkaKnjigeService.sviPodaciSK();
    }
    @PostMapping("/createStavkaKnjige")
    public void createStavkaKnjige(@RequestBody StavkaKnjige stavkaKnjigeCreate){
        stavkaKnjigeService.createSK(stavkaKnjigeCreate);
    }
    @PutMapping("/updateStavkaKnjige/{id}")
    public String updateStavkaKnjige(@PathVariable Integer id, @RequestBody StavkaKnjige stavkaKnjigeUpdate){
        if(id != null && id.equals(stavkaKnjigeUpdate.getId_stavka_knjiga())){
            stavkaKnjigeService.updateSK(stavkaKnjigeUpdate);
            return "Uspesno azurirana stavka Knjiga!";
        }
        return "Nije pronadjena knjiga sa tim ID-jem!";
    }
    @DeleteMapping("/deleteStavkaKnjige/{id}")
    public String deleteStavkaKnjige(@PathVariable Integer id){
        if(id != null){
            stavkaKnjigeService.deleteSK(id);
            return "Uspesno obrisana knjiga iz biblioteke!";
        }
        return "Nije pronadjena knjiga sa tim ID-jem!";
    }
}
