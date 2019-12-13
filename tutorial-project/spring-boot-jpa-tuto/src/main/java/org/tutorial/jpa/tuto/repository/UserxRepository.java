package org.tutorial.jpa.tuto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.jpa.tuto.entity.Userx;

@Repository
public interface UserxRepository extends JpaRepository<Userx, Long>{

}
