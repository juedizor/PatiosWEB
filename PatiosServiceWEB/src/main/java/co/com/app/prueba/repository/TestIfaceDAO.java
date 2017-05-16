package co.com.app.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.app.prueba.domain.Test;

@Repository
public interface TestIfaceDAO extends JpaRepository<Test, Integer> {

}
