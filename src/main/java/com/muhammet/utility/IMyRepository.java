package com.muhammet.utility;

/**
 * İlişkilsel ya da ilişkisel olamayan tüm DB yapılarında
 * kullanılmak üzere genişletilebilir entegre edilebilir bir sistem
 * kullanmak için bu interface kullanılacaktır.
 * @param <T>  Entity için type belirtir. (Muster,Product v.s.)
 * @param <ID> Entity içindedi @Id ile belirlenmiş id yi temsil eder
 *             bu id nin type girilmelidir. (Long, String)
 */
public interface IMyRepository<T,ID> {
}
