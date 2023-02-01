package com.muhammet.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Builder // Builder, bir sınıftan nesne türetmek için özel olşuturulmuş bir method
@Data // Data, get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1...n kadar olan tüm parametreli contructorları tanımlar
@ToString // sınıf için toString methodunu tanımlar
public class Iletisim {
    String telefon;
    String email;
    String web;
    String instagram;
}
