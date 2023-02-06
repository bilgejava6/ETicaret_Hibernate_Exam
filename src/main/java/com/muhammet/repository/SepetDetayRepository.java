package com.muhammet.repository;

import com.muhammet.repository.entity.SepetDetay;
import com.muhammet.utility.MyFactoryRepository;

public class SepetDetayRepository extends MyFactoryRepository<SepetDetay,Long> {
    public SepetDetayRepository(){
        super(new SepetDetay());
    }
}
