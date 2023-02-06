package com.muhammet.service;

import com.muhammet.repository.MusteriRepository;
import com.muhammet.repository.entity.Musteri;
import com.muhammet.utility.MyFactoryService;

public class MusteriService extends MyFactoryService<MusteriRepository, Musteri,Long> {
    public MusteriService(){
        super(new MusteriRepository());
    }
}
