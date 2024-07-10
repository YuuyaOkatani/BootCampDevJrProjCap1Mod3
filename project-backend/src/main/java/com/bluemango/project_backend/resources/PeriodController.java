package com.bluemango.project_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bluemango.project_backend.models.Period;

import jakarta.annotation.PostConstruct;


@RestController
@CrossOrigin
public class PeriodController {
    

    private List<Period> periods = new ArrayList<>();

    @GetMapping("periods")
    public List<Period> getAllPeriods() {
        return periods;
    }

    @GetMapping("periods/{id}")
    public ResponseEntity<Period> getPeriods(@PathVariable int id){
        Period period = periods
        .stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such period"));

        return ResponseEntity.ok(period);

    }

    @PostConstruct
    public void main(){
        periods.add(new Period(1, "Manhã"));
        periods.add(new Period(2, "Tarde"));
        periods.add(new Period(3, "Noite"));
     
    }


    
}
