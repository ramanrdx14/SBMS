package org.example.repo;

import org.example.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactInfoRepositary extends JpaRepository<ContactInfo,Integer> {

        @Query(value = "select name,email from contact where id IN(:Id1)",nativeQuery = true)
        public List<Object[]> getContactInfo(String Id1);
}
