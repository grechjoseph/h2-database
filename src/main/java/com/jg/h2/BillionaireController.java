package com.jg.h2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillionaireController {

    private final BillionaireRepository billionaireRepository;

    @GetMapping("/billionaires")
    public List<Billionaire> getBillionaires() {
        return billionaireRepository.findAll();
    }

    @GetMapping("/billionaires/{id}")
    public Billionaire getBillionaireById(@PathVariable final Integer id) {
        return billionaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Billionaire not found."));
    }

    @PostMapping("/billionaires")
    public Billionaire addBillionaire(@RequestBody final Billionaire billionaire) {
        return billionaireRepository.save(billionaire);
    }

    @DeleteMapping("/billionaires/{id}")
    public void deleteBillionaire(@PathVariable final Integer id) {
        billionaireRepository.delete(getBillionaireById(id));
    }

    @PutMapping("/billionaires/{id}")
    public Billionaire updateBillionaire(@RequestBody final Billionaire billionaire, @PathVariable Integer id) {
        billionaire.setId(id);
        return billionaireRepository.save(billionaire);
    }


}
