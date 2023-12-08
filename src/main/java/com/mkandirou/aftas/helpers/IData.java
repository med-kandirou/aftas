package com.mkandirou.aftas.helpers;

import com.mkandirou.aftas.fish.FishDTOres;

public interface IData <DTOreq,DTOres,idType>{
    DTOres findById(idType primarykey);
    DTOres save(DTOreq DTOreq);
    DTOres deleteById(idType primarykey);
    DTOres update(DTOreq DTOreq);
}
