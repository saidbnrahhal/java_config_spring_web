package com.springtuto.examples.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springtuto.examples.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long>{

}
