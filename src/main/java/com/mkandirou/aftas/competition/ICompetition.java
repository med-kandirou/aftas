package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.helpers.IData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICompetition extends IData<CompetitionDTOreq,CompetitionDTOres,String> {
    Page<CompetitionDTOres> findAll(String status,Pageable pageable);
}
