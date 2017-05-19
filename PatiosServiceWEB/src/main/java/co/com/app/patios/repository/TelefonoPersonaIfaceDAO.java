//package co.com.app.patios.repository;
//
//import java.util.List;
//
//import javax.persistence.PersistenceException;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import co.com.app.patios.domain.TelefonoPersona;
//
//public interface TelefonoPersonaIfaceDAO extends JpaRepository<TelefonoPersona, Integer> {
//
//	/**
//	 * realiza la consulta de los telefonos asociados a una persoan
//	 * 
//	 * @param idPersona
//	 * @return
//	 */
//	public List<TelefonoPersona> consultarTelefonoPersona(int idPersona) throws PersistenceException;
//}
