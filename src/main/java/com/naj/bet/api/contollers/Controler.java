package com.naj.bet.api.contollers;


import com.naj.bet.api.data.OddsDOA;
import com.naj.bet.api.models.Bet;
import com.naj.bet.api.models.Odds;
import com.naj.bet.api.service.OddsService;
import com.naj.bet.api.service.ValidateInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class Controler {


    @Autowired
    OddsService oddsDOA;
    ValidateInput validateInput = new ValidateInput();


    @GetMapping(path = "/all")
    public @ResponseBody List<Odds> getbyId(){
        return  oddsDOA.getAllOdds();
    }

    @GetMapping(path = "/odds/{id}")
    @ResponseBody
    public Iterable<Odds> getAllById(@PathVariable long id){
        if (oddsDOA.findBtsById(id).size() != 0){
            System.out.println("odd od "+ oddsDOA.findBtsById(id) );
            return oddsDOA.findBtsById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.resolve(402), "No record with this ID found");
        }
    }

    @PostMapping(path = "/odds",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public String saveToDb(@RequestBody Odds odd) {
        if (validateInput.validator(odd.getOdds())) {
            try {
                return oddsDOA.addOdds(odd);
            } catch (Exception exception) {

                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "server error");
            }
         }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid format of data");
            }

    }

}
