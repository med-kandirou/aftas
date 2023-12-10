package com.mkandirou.aftas.hunting;


import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface IHunting extends IData<HuntingDTOreq,HuntingDTOres,Integer> {
    List<HuntingDTOres> findAll();
}
