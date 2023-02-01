package com.muhammet.repository.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblmusteri", schema = "public")
public class Musteri {
    /**
     * Tablolarda ID için benzersiz alan oluşturma yöntemleri;
     * 1- Otomatik SQ ile oluşturma; (IDENTITY,TABLE,SQUENCE,AUTO)
     * 2- Elle SQ oluşturarak atama
     * 3- UUID oluşturarak elle atama
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @SequenceGenerator(
            name = "sq_ozel_id",sequenceName = "sq_ozel_id",
            allocationSize = 5, initialValue = 1000
    )
    @GeneratedValue(generator = "sq_ozel_id")
    Long musteri_id;
    @GenericGenerator(name = "name_uuid",strategy = "uuid2")
    @GeneratedValue(generator = "name_uuid")
    UUID uuid;
    /**
     * Tablolarda alanların özelleştirilmesi;
     * insertable = true; insert into tlmusteri(id,ad) values(?,?)
     * insertable = false; insert into tlmusteri(id) values(?)
     */
    @Column(
            name = "musteriad",
            length = 100,
            nullable = false, // bu alan boş geçilemez demeketir.
            unique = false, // eğer true olur ise bu alanda tekrar eden kayıt olamaz
            insertable = true, // bunu false yapar iseniz ekleme yapamazsınız
            updatable = false // update edilebilirliğini false hale getirirseniz bu alan güncellenemez
    )
    String ad;
    /**
     * Bu alan müşterinin birinci soyad bilgisini tutar.
     */
    @Column(length = 100)
    String soyad;
    @Lob
    String adres;
    /**
     * TemporalType.DATE -> tarih belirtirken
     * TemporalType.TIME -> zamanı saati belirtirken
     * TemporalType.TIMESTAMP -> zaman damgası için (System.currentMilis())
     */
    @Temporal(TemporalType.DATE)
    Date dogumtarihi;
    /**
     * DİKKAT!!! üzerine özellikle belirtmedikçe tüm tanımlar HIBERNATE tarafından
     * tabloda kolon olarak oluşturulur.
     * Eğer bir alanı kolon olarak oluşturmak istemiyor iseniz bunu @Transient ekleyerek yapabilirsiniz
     */
    @Transient
    String adsoyad;
    /**
     * Tablolar içinde eğer liste şeklinde bilgi saklamak istiyor isek bunu belirtmeliyiz.
     * Hibernate liste şeklinde tutulacak alanlar için bağlam yapmak zorunda kalır. bunu belirmek için
     * @ElementCollection kullanmalısınız.
     */
    @ElementCollection
    List<String> telefonlistesi;
    /**
     * Başka sınıfları bir varlık içinde kullanmak için
     * @Embedded kullanırız.
     */
    @Embedded
    Iletisim iletisim;
    @Embedded
    BaseEntity baseentity;
    /**
     * Enum class ların hibernate tarafından işlenme şeklini
     * @Enumerated ile belirleriz.
     * EnumType.STRING -> Enum bilgisi DB de String olarak tutulur
     * EnumType.ORDINAL -> Enum bilgisini sayıyal olarak tutar.
     */
    @Enumerated(EnumType.STRING)
    ECinsiyet cinsiyet;
}
