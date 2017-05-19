package co.com.app.patios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.Patio;

public interface PatioIfaceDAO extends JpaRepository<Patio, Integer> {

public List<Patio> findByIdPatioNotIn(int idPatio) ;

	public List<Patio> findAll();

	public Patio findByCodigoPatio(String codigoPatio) ;

}
