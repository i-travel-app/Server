package de.rest.repositories;


import de.rest.entity.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Integer> {

    @Query(value = "select id, dress from clothing union select id, hygienes from hygiene union select id, medicines from medicine union select id, technic from technics;", nativeQuery = true)
    List<?> allPrint();

    @Query(value = "select id, dress from clothing  where clothing.id_element=(SELECT id_d1 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or clothing.id_element=(SELECT id_d2 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or clothing.id_element=(SELECT id_d3 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3)\n" +
             "union select id, stuff from documents  where documents.id_element=(SELECT id_d1 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or documents.id_element=(SELECT id_d2 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or documents.id_element=(SELECT id_d3 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3)\n" +
             "union select id, hygienes from hygiene  where hygiene.id_element=(SELECT id_d1 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or hygiene.id_element=(SELECT id_d2 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or hygiene.id_element=(SELECT id_d3 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3)\n" +
             "union select id, medicines from medicine  where medicine.id_element=(SELECT id_d1 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or medicine.id_element=(SELECT id_d2 FROM summary WHERE id_weather = 2 AND id_sex = 2 AND id_tip = 1) or medicine.id_element=(SELECT id_d3 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3)\n" +
             "union select id, technic from technics  where technics.id_element=(SELECT id_d1 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or technics.id_element=(SELECT id_d2 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3) or technics.id_element=(SELECT id_d3 FROM summary WHERE id_weather = ?1 AND id_sex = ?2 AND id_tip = ?3);", nativeQuery = true)
    List<?> threeElement(int weather, int sex, int tip);


}
