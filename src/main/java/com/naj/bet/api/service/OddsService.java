package com.naj.bet.api.service;

import com.naj.bet.api.data.OddsDOA;
import com.naj.bet.api.models.Odds;
import jdk.dynalink.linker.LinkerServices;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class OddsService {
    OddsDOA oddsDOA;

    public OddsService(OddsDOA oddsDOA) {
        this.oddsDOA = oddsDOA;
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
//        odds1.setBetId(betId);
//        odds1.setOdds(odds);
//        odds1.setUserId(userId);
        BeanUtils.copyProperties(odd,odds1);
        oddsDOA.save(odds1);
        return "odds created for bet id";
    }
}
