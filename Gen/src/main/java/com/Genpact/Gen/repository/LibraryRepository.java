package com.Genpact.Gen.repository;

import com.Genpact.Gen.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

}