package com.naj.bet.api.data;

import com.naj.bet.api.models.Odds;
import com.naj.bet.api.models.OddsCompKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetCompKeyRepository extends JpaRepository<Odds, OddsCompKey> {

}
