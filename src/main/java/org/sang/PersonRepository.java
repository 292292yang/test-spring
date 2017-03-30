package org.sang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by sang on 2017/1/5.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

    @Modifying
    @Query("update Person a set a.name = ?1 where a.id = ?2")
    void updatePerson(String name,Long id);
}
