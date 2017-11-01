package de.rest.repositories;

import de.rest.entity.Put;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PutRepository extends JpaRepository<Put, Integer> {

//    @Query(value = "INSERT INTO put (element, stump) VALUES (?1, strftime('%s','now'));", nativeQuery = true)
//    String nueObjeckt(String element);
}
