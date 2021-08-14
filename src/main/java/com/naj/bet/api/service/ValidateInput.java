package com.naj.bet.api.service;

import com.naj.bet.api.models.Odds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateInput {


    /**
     * method to validate the odd
     * @param odd
     * @return boolean
     */
    public boolean validator(String odd) {

        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);

        if(odd.contains("/")) {
            String[] fraction = odd.split("/");
            if(fraction.length == 2) {
                Matcher numerator = pattern.matcher(fraction[0]);
                Matcher denominator = pattern.matcher(fraction[1]);
                if(numerator.matches() && denominator.matches()) {

                    return true;
                }else {

                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}

