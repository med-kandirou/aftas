package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface ICompetition extends IData<CompetitionDTOreq,CompetitionDTOres,String> {
    List<CompetitionDTOres> findAll();
}
