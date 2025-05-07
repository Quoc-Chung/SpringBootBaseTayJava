package com.quocchung.SPRINGBOOT_BASE.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseRedisService<K, F, V> {

     /**
      * Lưu giá trị vào Redis với key tương ứng.
      * @param key   Khóa Redis
      * @param value Giá trị cần lưu
      */
     void set(K key, V value);

     /**
      * Đặt thời gian sống (TTL) cho key. Sau thời gian này key sẽ bị xóa tự động.
      * @param key Khóa Redis
      * @param ttl Thời gian sống (tính bằng giây)
      */
     void setTimeToLive(K key, int ttl);

     /**
      * Lấy giá trị từ Redis theo key.
      * @param key Khóa Redis
      * @return Giá trị tương ứng, hoặc null nếu không tồn tại
      */
     V get(K key);

     /**
      * Lưu giá trị vào Redis dạng HASH (tương tự Map), với key là tên Hash, field là thuộc tính.
      * @param key   Tên HASH
      * @param field Trường trong HASH
      * @param value Giá trị ứng với field
      */
     void hashSet(K key, F field, V value);

     /**
      * Kiểm tra một field có tồn tại trong HASH hay không.
      * @param key   Tên HASH
      * @param field Trường cần kiểm tra
      * @return true nếu tồn tại, ngược lại false
      */
     boolean hashExists(K key, F field);

     /**
      * Lấy toàn bộ nội dung (field, value) trong HASH.
      * @param key Tên HASH
      * @return Map gồm các cặp field -> value
      */
     Map<F, V> hashGet(K key);

     /**
      * Giống với hashGet - Lấy toàn bộ field và giá trị của một HASH.
      * @param key Tên HASH
      * @return Map gồm các field và giá trị
      */
     Map<F, V> getField(K key);

     /**
      * Lọc các giá trị trong HASH theo tiền tố (prefix) của field.
      * @param key          Tên HASH
      * @param fieldPrefix  Tiền tố field muốn lọc
      * @return Danh sách giá trị (value) ứng với các field bắt đầu bằng fieldPrefix
      */
     List<V> hashGetByFieldPrefix(K key, String fieldPrefix);

     /**
      * Lấy ra tất cả tên field có trong HASH.
      * @param key Tên HASH
      * @return Tập hợp các tên field
      */
     Set<F> getFieldPrefixes(K key);

     /**
      * Xóa toàn bộ một key trong Redis.
      * @param key Khóa Redis cần xóa
      */
     void delete(K key);

     /**
      * Xóa một field cụ thể trong một HASH.
      * @param key   Tên HASH
      * @param field Field cần xóa
      */
     void delete(K key, F field);

     /**
      * Xóa nhiều field cùng lúc trong một HASH.
      * @param key    Tên HASH
      * @param fields Danh sách field cần xóa
      */
     void delete(K key, List<F> fields);
}
