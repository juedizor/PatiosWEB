//package co.com.app.patios.repository;
//
//import java.math.BigDecimal;
//
//import javax.persistence.PersistenceException;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import co.com.app.patios.domain.Persona;
//
//public interface PersonaIfaceDAO extends JpaRepository<Persona, Integer> {
//
//	/**
//	 * realiza la consulta de la persona teniendo en cuenta su numero de
//	 * identificacion
//	 * 
//	 * @param numeroIdentificacion
//	 * @return
//	 */
//	public Persona consultarPersona(BigDecimal numeroIdentificacion) throws PersistenceException;
//
//}
