package com.muhammet;

import com.muhammet.ornekcriteriakullanimi.CriteriaUsing;
import com.muhammet.repository.MusteriRepository;
import com.muhammet.repository.entity.ECinsiyet;
import com.muhammet.repository.entity.Musteri;
import com.muhammet.repository.entity.Urun;
import com.muhammet.service.MusteriService;
import com.muhammet.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EticaretApplication {
    public static void main(String[] args) {
        MusteriService service = new MusteriService();
        MusteriRepository musteriRepository = new MusteriRepository();
        service.findByEntity(Musteri.builder().ad("a").soyad("A").build()).forEach(x->{
            System.out.println("Müşteri...: "+ x.getAd()+" "+ x.getSoyad());
        });

//        musteriRepository.findAllByColumnNameAndValue("soyad","TEKİR").forEach(x->{
//           System.out.println("Müşteri...: "+ x.getAd()+" "+ x.getSoyad());
//        });

//        musteriRepository.save(Musteri.builder()
//                        .ad("Kenan")
//                        .soyad("TEKİR")
//                        .cinsiyet(ECinsiyet.ERKEK)
//                .build());
//        musteriRepository.findAll().forEach(x->{
//            System.out.println("Müşteri...: "+ x.getAd()+" "+ x.getSoyad());
//        });

    }

    private static void testmain(){

        CriteriaUsing cr = new CriteriaUsing();
        //cr.findAll();
        //cr.selectOneColumn();
        //cr.selectManyColumn();
        //cr.usingTuple();
//        cr.multipleRoot().forEach(x->{
//            System.out.println(((Musteri)x.get(0)).toString());
//            System.out.println(((Urun)x.get(1)).toString());
//            System.out.println("****************************************");
//        });
        //cr.usingParameter("Bahar");
        //cr.usingPredicate();
        //cr.groupBy();
        //cr.findAllNativeQuery();
        //cr.namedQueryFindAll();
        //cr.namedQueryFindByAd("m%");
        //cr.namedQueryFindById(3l);
        //cr.namedQueryFindById(1000l);
        //cr.namedQueryGetCount();
        //  cr.typedQuerySetProperties(1,3);
        Musteri musteri = Musteri.builder()
                .ad("Muhammet Ali")
                .soyad("HOCA")
                .adres("Ankara")
                .cinsiyet(ECinsiyet.ERKEK)
                .build();
        MusteriRepository musteriRepository = new MusteriRepository();
        musteriRepository.save(musteri);
        musteriRepository.findAllByColumnNameAndValue("ad","Muhammet");

    }
    private static void criteriaList(){
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //Session ss = HibernateUtility.getSessionFactory().openSession();
        /**
         * Tüm datayı çekmek
         * criteriaQuery aslında bizim, Select * from tblmusteri sorgusunu ve bu sorgu neticesinde
         * dönecek alanların neler olduğunu çözebilmesi için hazırlanıyor.
         * select id,ad,soyad,cinsiyet, .... from tblmusteri
         */
        CriteriaQuery<Musteri> criretia = builder.createQuery(Musteri.class);
        Root<Musteri> root = criretia.from(Musteri.class);
        criretia.select(root);
        List<Musteri> listem = entityManager.createQuery(criretia).getResultList();
        listem.forEach(x->{
            System.out.println("ad.......: "+ x.getAd());
        });
    }
    private static void list(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Musteri.class);
        List<Musteri> musteriList = cr.list();
        session.close();
        musteriList.forEach(x->{
            System.out.println("Müşteri Ad Soyad...: "+ x.getAd()+" "+x.getSoyad());
        });

    }
    private static void saveMusteri(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> telList = Arrays.asList("0 555 874 4114", "0 999 012 0214");
        Musteri musteri = Musteri.builder()
                .ad("Gülşen")
                .adres("Samsun")
                .soyad("HOCA")
                .cinsiyet(ECinsiyet.KADIN)
                .telefonlistesi(telList)
                .build();
        session.save(musteri);
        transaction.commit();
        session.close();
    }
    private static void saveUrun(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Urun urun = Urun.builder()
                .kdv(18)
                .model("B Model")
                .marka("C Marka")
                .fiyat(24d)
                .ad("Un")
                .build();
        session.save(urun);
        transaction.commit();
        session.close();
    }
}