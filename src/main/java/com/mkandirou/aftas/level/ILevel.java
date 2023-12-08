package com.mkandirou.aftas.level;

import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface ILevel extends IData<LevelDTOreq,LevelDTOres,Integer> {
    List<LevelDTOres> findAll();
}
