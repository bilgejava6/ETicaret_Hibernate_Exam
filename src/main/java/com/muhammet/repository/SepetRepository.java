package com.muhammet.repository;

import com.muhammet.repository.entity.Sepet;
import com.muhammet.utility.MyFactoryRepository;

public class SepetRepository extends MyFactoryRepository<Sepet,Long> {
    public SepetRepository(){
        super(new Sepet());
    }
}
