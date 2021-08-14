package com.naj.bet.api.service;

import com.naj.bet.api.data.BetCompKeyRepository;
import com.naj.bet.api.data.OddsDOA;
import com.naj.bet.api.models.Odds;
import com.naj.bet.api.models.OddsCompKey;
import com.naj.bet.api.models.OddsUpdateObj;
import jdk.dynalink.linker.LinkerServices;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class OddsService {
    OddsDOA oddsDOA;
    BetCompKeyRepository betCompKeyRepository;
    public OddsService(OddsDOA oddsDOA, BetCompKeyRepository betCompKeyRepository) {

        this.oddsDOA = oddsDOA;
        this.betCompKeyRepository = betCompKeyRepository;
    }

    public List<Odds> getAllOdds(){
        return oddsDOA.findAll();
    }

    @Transactional
    public List<Odds> findBtsById(long betId){
        return oddsDOA.getOddsAllByID(betId);

    }

    @Transactional
    public String addOdds(Odds odd){
        Odds odds1 = new Odds();
        BeanUtils.copyProperties(odd,odds1);
        oddsDOA.save(odds1);
        return "odds created for bet id";
    }

    @Transactional
    public String updateOdds(OddsUpdateObj odd){
        OddsUpdateObj odds1 = new OddsUpdateObj();
        BeanUtils.copyProperties(odd,odds1);
        if (oddsDOA.findOddByComp(odds1.getBetId(),odds1.getOdds(),odds1.getUserId()) == null){
            return "Odd does not exist";
        }
        oddsDOA.updateOdd(odds1.getBetId(),odds1.getOdds(),odds1.getUserId(),odds1.getNewOdd());
        return  "odd updated";
    }

    @Transactional
    public String deleteOdds(Odds odd){
        Odds odds1 = new Odds();
        BeanUtils.copyProperties(odd,odds1);
        if (oddsDOA.findOddByComp(odds1.getBetId(),odds1.getOdds(),odds1.getUserId()) == null){
            return "Odd does not exist";
        }

        oddsDOA.deleteOdd(odds1.getBetId(),odds1.getOdds(),odds1.getUserId());
        return  "odd deleted";
    }
}
