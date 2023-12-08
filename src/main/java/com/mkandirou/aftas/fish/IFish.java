package com.mkandirou.aftas.fish;

import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface IFish extends IData<FishDTOreq,FishDTOres,String> {
    List<FishDTOres> findAll();
}
