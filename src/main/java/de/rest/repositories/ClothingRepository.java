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
}
