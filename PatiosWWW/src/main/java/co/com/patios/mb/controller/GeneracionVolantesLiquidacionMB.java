package co.com.patios.mb.controller;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;
import co.com.patios.ejb.controller.ConsecutivoVolanteEJB;
import co.com.patios.ejb.controller.DetalleVolantePatioEJB;
import co.com.patios.ejb.controller.EntradaVehiculoPatioEJB;
import co.com.patios.ejb.controller.MarcaVehiculoEJB;
import co.com.patios.ejb.controller.ModeloVehiculoEJB;
import co.com.patios.ejb.controller.PatioEJB;
import co.com.patios.ejb.controller.UsuarioEJB;
import co.com.patios.ejb.controller.UsuarioPatioEJB;
import co.com.patios.ejb.controller.UtilidadesEJB;
import co.com.patios.ejb.controller.ValorPatioEJB;
import co.com.patios.ejb.controller.VehiculoEJB;
import co.com.patios.ejb.controller.VolantePatioEJB;
import co.com.patios.entity.ConsecutivoVolante;
import co.com.patios.entity.DetalleVolantePatio;
import co.com.patios.entity.EntradaVehiculoPatio;
import co.com.patios.entity.Usuario;
import co.com.patios.entity.UsuarioPatio;
import co.com.patios.entity.ValorPatio;
import co.com.patios.entity.Vehiculo;
import co.com.patios.entity.VolantePatio;
import co.com.patios.mb.beanUtil.*;
import co.com.patios.mb.util.*;


@ManagedBean (name="generacionVolantesLiquidacionMB")
@ViewScoped
public class GeneracionVolantesLiquidacionMB {

	
	private String placa;
	private String marcaVehiculo;
	private String modeloVehiculo;
	private String nombrePatio;
	private String fechaEntrada;
	private boolean mostrarTable = false;
	private boolean mostrarVolante = false;
	private boolean mostrarBotonVolante = false;
	
	
	private Vehiculo vehiculo;
	private EntradaVehiculoPatio entradaVehiculoPatio;
	private ValorPatio valorPatio;
	private ConsecutivoVolante consecutivoVolante;
	private VolantePatio volantePatio;
	private DetalleVolantePatio detalleVolantePatio;
	
	
	private static List<VolantePagoLiquidacion> listVolantePagoLiquidacion;
	private List<DetalleVolantePatio> listDetalleVolantePatio;
	
	private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
	private static final int yearActual = Utilidades.obtenerFechaActual().get(Calendar.YEAR);
	private static int mesInicio;
	private static int yearInicio;
	private static int diaInicio;
	private static int mesFinal;
	private static int yearFinal;
	private static int diaFinal;
	private static Calendar calendarInicio;
	private static Calendar calendarFinal;
	private static java.sql.Date fechaInicio;
	private static java.sql.Date fechaFinal;
	private static long numeroDias = 0;
	private static long valorPagar = 0;
	private String deudaTotal;
	private boolean liquidacionYearActual = false;
	private static final String NOMBRE_VOLANTE_LIQUIDACION = "volanteLiquidacionPatios";
	private String volante;
	private static final String RUTA_GENERACION_VOLANTES_PATIOS = "resources/pdf/";
	

	private HttpServletRequest httpServletRequestLogin;
	private final FacesContext context;
	
	
	@EJB
	VehiculoEJB vehiculoEJB;
	@EJB
	EntradaVehiculoPatioEJB entradaVehiculoPatioEJB;
	@EJB
	PatioEJB patioEJB;
	@EJB
	MarcaVehiculoEJB marcaVehiculoEJB;
	@EJB
	ModeloVehiculoEJB modeloVehiculoEJB;
	@EJB
	ValorPatioEJB valorPatioEJB;
	@EJB
	ConsecutivoVolanteEJB consecutivoVolanteEJB;
	@EJB
	UsuarioEJB usuarioEJB;
	@EJB
	UtilidadesEJB utilidadesEJB;
	@EJB
	VolantePatioEJB volantePatioEJB;
	@EJB
	DetalleVolantePatioEJB detalleVolantePatioEJB;
	@EJB
	UsuarioPatioEJB usuarioPatioEJB;
	
	
	
	private Integer progress = 0;
	 
   
    
    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
    }
	
	public GeneracionVolantesLiquidacionMB() {
		vehiculo = new Vehiculo();
		valorPatio = new ValorPatio();
		consecutivoVolante = new ConsecutivoVolante();
		volantePatio = new VolantePatio();
		context = FacesContext.getCurrentInstance();
		httpServletRequestLogin  = (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
	
	public void mayuscula(){
		String textPlaca = placa;
		placa = textPlaca.toUpperCase();
		vehiculo.setPlacaVehiculo(textPlaca.toUpperCase());
	}
	
	public Vehiculo obtenerDatosVehiculo(){
		vehiculo = new Vehiculo();
		mayuscula();
		if(vehiculo != null){
			if(vehiculo.getPlacaVehiculo() != null){
				vehiculo = vehiculoEJB.consultarVehiculo(vehiculo.getPlacaVehiculo());
			}
		}
		return vehiculo;
		
	}
	
	
	public EntradaVehiculoPatio obtenerEntradaVehiculo(int idPatio){
		if(this.vehiculo != null){
			int idVehiculo = this.vehiculo.getIdVehiculo();
			entradaVehiculoPatio =  entradaVehiculoPatioEJB.consultarEntradaVehiculoPorIdVehiculo(idVehiculo, "I", idPatio);
		}
		
		return entradaVehiculoPatio;
	}
	
	/**
	 * obtiene lo datos de la liquidacion
	 */
	public void obtenerDatosLiquidacion(){
		vehiculo = new Vehiculo();
		FacesContext context = FacesContext.getCurrentInstance();
		httpServletRequestLogin  = (HttpServletRequest) context.getExternalContext().getRequest();
		FacesMessage message = new FacesMessage();
		//se captura la session del usuario
		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		int idUsuario = usuarioEJB.buscarUsuario(usuarioSession.getLoginUsuario()).getIdUsuario(); 
		Date fechaActual = utilidadesEJB.getFechaActual();
		List<UsuarioPatio> listUsuarioPatio =  usuarioPatioEJB.consultarPatioUsuario(idUsuario, fechaActual);
		vehiculo = obtenerDatosVehiculo();
		if(vehiculo == null){
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setDetail("La placa: "+placa+" no existe como vehículo");
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage(null, message);
			mostrarTable = false;
			deudaTotal = "";
			mostrarBotonVolante = false;
			mostrarVolante = false;
			return;
		}
		
		
		if(listUsuarioPatio != null && !listUsuarioPatio.isEmpty()){
			for (UsuarioPatio usuarioPatio : listUsuarioPatio) {
				entradaVehiculoPatio = obtenerEntradaVehiculo(usuarioPatio.getPatio().getIdPatio());
				if(entradaVehiculoPatio != null){
					break;
				}
			}
			
		}
		
		if(entradaVehiculoPatio == null){
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			String mensaje = String.format(MessagesEstaticos.getMensajeUsuarioNoAutorizado(), usuarioSession.getLoginUsuario() ,  placa);
			message.setDetail(mensaje);
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage(null, message);
			mostrarTable = false;
			deudaTotal = "";
			mostrarBotonVolante = false;
			mostrarVolante = false;
			return;
		}
		
		mostrarVolante = false;
		if(vehiculo == null || entradaVehiculoPatio == null){
			vehiculo = new Vehiculo();
			entradaVehiculoPatio = new EntradaVehiculoPatio();
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			String mensaje = String.format(MessagesEstaticos.getMensajeEntradaVehiculosNoExiste(), placa);
			message.setDetail(mensaje);
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage(null, message);
			mostrarTable = false;
			deudaTotal = "";
		}else{
			volantePatio = volantePatioEJB.consultarVolantePorEntrada(entradaVehiculoPatio.getIdEntradaVehiculoPatio());
			if(volantePatio != null){
				listDetalleVolantePatio = detalleVolantePatioEJB.consultarDetallePorIdVolante(volantePatio.getIdVolantePatio());
				deudaTotal = Utilidades.formatearNumero(""+sumarSaldosDetalleVolantePatios());
				setListaVolanteLiquidacionPatios();
				volante = "";// mostrarVolantePago();
				mostrarBotonVolante = false;
				mostrarVolante = true;
				mostrarTable = true;
			}else{
				obtenerDiasLiquidacionPatio();
			}
		}
	}
	
	
	/**
	 * set de la lista de detalle para ser mostrada en el volante de liquidacion historico
	 * 
	 */
	private void setListaVolanteLiquidacionPatios(){
		listVolantePagoLiquidacion = new ArrayList<VolantePagoLiquidacion>();
		VolantePagoLiquidacion volantePagoLiquidacion;
		for (DetalleVolantePatio detalleVolantePatio : listDetalleVolantePatio) {
			volantePagoLiquidacion = new VolantePagoLiquidacion();
			volantePagoLiquidacion.setNumeroDias(detalleVolantePatio.getDiasLiquidacion());
			volantePagoLiquidacion.setYearEntrada(Integer.parseInt(detalleVolantePatio.getAnioLiquidacion()));
			volantePagoLiquidacion.setValorYear("$"+Utilidades.formatearNumero(""+detalleVolantePatio.getValorLiquidacionAnio()));
			volantePagoLiquidacion.setYearValor("$"+Utilidades.formatearNumero(""+detalleVolantePatio.getValorLiquidacion()));
			listVolantePagoLiquidacion.add(volantePagoLiquidacion);
			
		}
	}
	
	/**
	 * suma los saldos del detalle de un volante de pago de patios
	 * @return
	 */
	private long sumarSaldosDetalleVolantePatios(){
		long sumaSaldos = 0;
		if(listDetalleVolantePatio != null && !listDetalleVolantePatio.isEmpty()){
			for (DetalleVolantePatio detalleVolantePatio : listDetalleVolantePatio) {
				sumaSaldos += detalleVolantePatio.getValorLiquidacion().longValue();
			}
		}
		
		return sumaSaldos;
	}
	
	
	/**
	 * realiza liquidacion de patios
	 */
	public void obtenerDiasLiquidacionPatio(){
		String mensaje = "";
		listVolantePagoLiquidacion = new ArrayList<VolantePagoLiquidacion>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(entradaVehiculoPatio.getFechaEntradaVehiculo());
		int year =  calendar.get(Calendar.YEAR);
		int mes = 0;
		int dia = 0;
		
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		mes = calendar.get(Calendar.MONTH)+1;
		if(year == yearActual){
			liquidacionYearActual = true;
			mensaje = liquidarAñoActual(year, mes, dia, liquidacionYearActual);
			validarMensajeTarifa(mensaje);
		}
		
		if(year!= yearActual){
			mensaje = liquidarAñosAnteriores(year, mes, dia);
			validarMensajeTarifa(mensaje);
		}
		
		deudaTotal = Utilidades.formatearNumero(""+obtenerDeudaTotal());
	}
	
	/**
	 * valida el mensaje arrojado por la validacion de tarifas
	 * @param mensaje
	 */
	private void validarMensajeTarifa(String mensaje){
		if(!mensaje.equals("")){
			mostrarMensajeTarifa(mensaje);
		}else{
			mostrarTable = true;
			mostrarBotonVolante = true;
		}
	}
	
	/**
	 * agrega mensaje de error de no existencia de valor de patios
	 * @param mensaje
	 */
	private void mostrarMensajeTarifa(String mensaje){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setDetail(mensaje);
		message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
		context.addMessage(null, message);
	}
	
	/**
	 * realiza la liquidacion de años anteriores
	 * @param year
	 * @param mes
	 * @param dia
	 */
	private String liquidarAñosAnteriores(int year, int mes, int dia){
		String mensajeTarifa = "";
			for (int i  = year; i <= yearActual; i++){
				if((yearActual-i)>=1){
					if(i == year){
						valorPatio = valorPatioEJB.consultarValorPatio(entradaVehiculoPatio.getFechaEntradaVehiculo(), 
	   						entradaVehiculoPatio.getPatio().getIdPatio(),  vehiculo.getClaseVehiculo().getIdClaseVehiculo());
						mensajeTarifa = validarValorPatios(""+entradaVehiculoPatio.getFechaEntradaVehiculo(), entradaVehiculoPatio.getPatio().getNombrePatio());
						if(!mensajeTarifa.equals("")){
							return mensajeTarifa;
						}
						
						Long tarifaPatio = valorPatio.getValorTarifa().longValue();
						yearInicio = year;
						mesInicio = mes;
						diaInicio = dia;
						yearFinal = year;
						mesFinal = 12;
						diaFinal = 31;
						
						
						calendarInicio = new GregorianCalendar(yearInicio, mesInicio-1, diaInicio);
						calendarFinal = new GregorianCalendar(yearFinal, mesFinal-1, diaFinal);
						fechaInicio =  new java.sql.Date(calendarInicio.getTimeInMillis());
						fechaFinal = new java.sql.Date(calendarFinal.getTimeInMillis());
						numeroDias = (fechaFinal.getTime() - fechaInicio.getTime())/MILLSECS_PER_DAY;
						numeroDias+=1;
						valorPagar = (numeroDias * tarifaPatio);
						
						VolantePagoLiquidacion volantePago = setVolantePagoLiquidacion(entradaVehiculoPatio.getPatio().getCodigoPatio(), 
								this.entradaVehiculoPatio.getPatio().getNombrePatio(), 
								i,
								valorPagar, 
								(int) numeroDias, tarifaPatio);
						listVolantePagoLiquidacion.add(volantePago);
					
					}else{
						yearInicio = i;
						mesInicio = 1;
						diaInicio = 1;
						yearFinal = i;
						mesFinal = 12;
						diaFinal = 31;
						
						
						calendarInicio = new GregorianCalendar(yearInicio, mesInicio-1, diaInicio);
						calendarFinal = new GregorianCalendar(yearFinal, mesFinal-1, diaFinal);
						fechaInicio =  new java.sql.Date(calendarInicio.getTimeInMillis());
						fechaFinal = new java.sql.Date(calendarFinal.getTimeInMillis());
						numeroDias = (fechaFinal.getTime() - fechaInicio.getTime())/MILLSECS_PER_DAY;
						numeroDias+=1;
						valorPatio = valorPatioEJB.consultarValorPatio(fechaInicio, 
		   						entradaVehiculoPatio.getPatio().getIdPatio(), vehiculo.getClaseVehiculo().getIdClaseVehiculo());
						
						mensajeTarifa = validarValorPatios(""+entradaVehiculoPatio.getFechaEntradaVehiculo(), entradaVehiculoPatio.getPatio().getNombrePatio());
						if(!mensajeTarifa.equals("")){
							return mensajeTarifa;
						}
						
						Long tarifaPatio = valorPatio.getValorTarifa().longValue();
						valorPagar = (numeroDias * tarifaPatio);
						
						VolantePagoLiquidacion volantePago = setVolantePagoLiquidacion(entradaVehiculoPatio.getPatio().getCodigoPatio(), 
								entradaVehiculoPatio.getPatio().getNombrePatio(), 
								i,
								valorPagar, 
								(int) numeroDias, tarifaPatio);
						listVolantePagoLiquidacion.add(volantePago);
					}
				}else{
					yearInicio = i;
					mesInicio = 1;
					diaInicio = 1;
					yearFinal = i;
					Calendar calendar = Utilidades.obtenerFechaActual();
					mesFinal = calendar.get(Calendar.MONTH)+1;
					diaFinal = calendar.get(Calendar.DAY_OF_MONTH);
					liquidacionYearActual = false;
					mensajeTarifa = liquidarAñoActual(i, mesFinal, diaFinal, liquidacionYearActual);
				}
			}
		
			return mensajeTarifa;
	}
	
	/**
	 * realiza la liquidacion de una año actual
	 * @param year, año actual
	 * @param mes
	 * @param dia
	 * @param liquidarYearActual
	 */
	private String liquidarAñoActual(int year, int mes, int dia, boolean liquidarYearActual){
		
		java.sql.Date fechaActual = null;
		
		if((yearActual - year) >= 1){
			calendarInicio = new GregorianCalendar(year, mes-1, dia);
			fechaActual=  new java.sql.Date(calendarInicio.getTimeInMillis());
		}else{
			calendarInicio = new GregorianCalendar(year, Utilidades.obtenerFechaActual().get(Calendar.MONTH), 
					Utilidades.obtenerFechaActual().get(Calendar.DAY_OF_MONTH));
			fechaActual=  new java.sql.Date(calendarInicio.getTimeInMillis());
		}
		
		
		//consulta la tarifa del patio
		valorPatio = valorPatioEJB.consultarValorPatio(fechaActual, 
				entradaVehiculoPatio.getPatio().getIdPatio(), vehiculo.getClaseVehiculo().getIdClaseVehiculo());
		String mensajeTarifa = validarValorPatios(""+fechaActual, entradaVehiculoPatio.getPatio().getNombrePatio());
		if(!mensajeTarifa.equals("")){
			return mensajeTarifa;
		}
		
		
		//asigna la tarifa del patio a la variable tarifaPatio
		Long tarifaPatio = valorPatio.getValorTarifa().longValue();
		
		
		numeroDias = 0;
		valorPagar = 0;
		
		Calendar calendar = new GregorianCalendar(year,0, 1); 
		fechaInicio = new java.sql.Date(calendar.getTimeInMillis());
		
		
		
		Calendar actual = Calendar.getInstance();
		actual.setTime(entradaVehiculoPatio.getFechaEntradaVehiculo());

		
		if(liquidarYearActual){
			numeroDias = (fechaActual.getTime() - entradaVehiculoPatio.getFechaEntradaVehiculo().getTime()  )/MILLSECS_PER_DAY;
		}else{
			numeroDias = (fechaActual.getTime() - fechaInicio.getTime() )/MILLSECS_PER_DAY;
		}
				
		numeroDias += 1;
		valorPagar = numeroDias * tarifaPatio;
		VolantePagoLiquidacion volantePago = setVolantePagoLiquidacion(entradaVehiculoPatio.getPatio().getCodigoPatio(), 
				entradaVehiculoPatio.getPatio().getNombrePatio(), 
				year,
				valorPagar, 
				(int) numeroDias, 
				tarifaPatio);
		listVolantePagoLiquidacion.add(volantePago);
		return mensajeTarifa;
	}
	
	
	/**
	 * valida los valores de patios nullos y manda mensaje indicando el error
	 * @param fecha
	 * @param nombrePatio
	 */
	private String validarValorPatios(String fecha, String nombrePatio){
		String mensaje = "";
		if(valorPatio == null){
			mensaje = String.format(MessagesEstaticos.getMensajeValorPatioNoExiste(), nombrePatio, fecha);
			return mensaje;
		}
		
		return mensaje;
	}
	
	/**
	 * set del volante de patios
	 * @param codigoPatio
	 * @param nombrePatio
	 * @param year
	 * @param valorPagar
	 * @param numeroDias
	 * @param valorYear
	 * @return
	 */
	private VolantePagoLiquidacion setVolantePagoLiquidacion(String codigoPatio, String nombrePatio, 
			int year, long valorPagar, 
			int numeroDias, long valorYear){
		VolantePagoLiquidacion volantePagoLiquidacion = new VolantePagoLiquidacion();
		volantePagoLiquidacion.setCodigoPatio(entradaVehiculoPatio.getPatio().getCodigoPatio());
		volantePagoLiquidacion.setNombrePatio(entradaVehiculoPatio.getPatio().getNombrePatio());
		volantePagoLiquidacion.setYearEntrada(year);
		volantePagoLiquidacion.setYearValor("$ "+Utilidades.formatearNumero(""+valorPagar));
		volantePagoLiquidacion.setNumeroDias(numeroDias);
		volantePagoLiquidacion.setValorYear("$ "+Utilidades.formatearNumero(""+valorYear));
		volantePagoLiquidacion.setDeudaTotal(valorPagar);
		volantePagoLiquidacion.setTarifaPatio(valorYear);
		return volantePagoLiquidacion;
	}
	
	
	/**
	 * obtiene la deuda total de la liquidacion
	 * @return
	 */
	private long obtenerDeudaTotal(){
		long total = 0;
		for (VolantePagoLiquidacion volantePagoLiquidacion : listVolantePagoLiquidacion) {
			total += volantePagoLiquidacion.getDeudaTotal();
		}
		return total;
	}
	
	
	/**
	 * genera el volante de pago para la liquidacion de dias del patio
	 */
	private void generarConsecutivoVolante(){
		//se captura la session del usuario
		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		progress = progress + 5;
		if(usuarioSession == null){
			try {
				context.getExternalContext().redirect("../../index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			consecutivoVolante = consecutivoVolanteEJB.generarConsecutivoVolante(usuarioSession.getLoginUsuario());
			progress = progress + 5;
		}	
		
	}
	
	
	/**
	 * realiza la generacion globlal del volante de liquidacion de patios 
	 */
	public void generarVolanteLiquidacionPatios(){
		progress = new Integer(0);
		progress = progress + 5;
		volantePatio = new VolantePatio();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		generarConsecutivoVolante();
		if(consecutivoVolante.getIdConsecutivoVolante() != null){
			setVolantePatio();
			volantePatioEJB.insertarVolantePatios(volantePatio);
			setDetalleVolantePatios();
			volante = null;//mostrarVolantePago();
			if(volante.equals("")){
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setDetail(MessagesEstaticos.getMensajeErrorGeneracionPdf());
				message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
				context.addMessage("", message);
			}else{
				mostrarVolante = true;
				mostrarBotonVolante = false;
				progress = 100;
			}
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail(MessagesEstaticos.getMensajeErrorGeneracionLiquidacion());
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage("", message);
		}	
	}
	
	
	/**
	 * set de detalle de volante de liquidacion
	 */
	private void setDetalleVolantePatios(){
		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		usuarioSession = usuarioEJB.buscarUsuario(usuarioSession.getLoginUsuario());
		for (VolantePagoLiquidacion volantePagoLiquidacion : listVolantePagoLiquidacion) {
			detalleVolantePatio = new DetalleVolantePatio();
			detalleVolantePatio.setAnioLiquidacion(""+volantePagoLiquidacion.getYearEntrada());
			detalleVolantePatio.setDiasLiquidacion(volantePagoLiquidacion.getNumeroDias());
			detalleVolantePatio.setValorLiquidacionAnio(new BigDecimal(volantePagoLiquidacion.getTarifaPatio()));
			detalleVolantePatio.setValorLiquidacion(new BigDecimal(volantePagoLiquidacion.getDeudaTotal()));
			detalleVolantePatio.setVolantePatio(volantePatio);
			detalleVolantePatio.setUsuario(usuarioSession);
			detalleVolantePatioEJB.insertarDetalleVolantePatio(detalleVolantePatio);
		}
	}
	
	/**
	 * set de valores del volante de liquidacion patios
	 */
	private void setVolantePatio(){
		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		usuarioSession = usuarioEJB.buscarUsuario(usuarioSession.getLoginUsuario());
		volantePatio.setNumeroVolante(consecutivoVolante.getNumeroVolante());
		volantePatio.setEntradaVehiculoPatio(entradaVehiculoPatio);
		volantePatio.setFechaVolante(consecutivoVolante.getFechaConsecutivoVolante());
		volantePatio.setUsuario(usuarioSession);
	}
	
	
	/**
	 * genera el pdf del volante de pago de liquidacion de patios
	 * @return
	 */
//	private String mostrarVolantePago(){
//		JasperPrint jPrint = null;
//		java.io.InputStream plantilla = this.getClass().getResourceAsStream("/co/com/patios/mb/resource/volanteLiquidacionPatios.jasper");
//        JasperReport reporte = null;
//        Map<String, Object> parameters = new HashMap<String, Object>();
//        String nombreArchivo = "";
//        try {
//        	reporte = null;// (JasperReport) JRLoader.loadObject(plantilla);
//        	parameters.put("numeroVolante", volantePatio.getNumeroVolante());
//        	parameters.put("fechaVolante", volantePatio.getFechaVolante());
//        	parameters.put("placaVehiculo", placa);
//        	parameters.put("marcaVehiculo", vehiculo.getModeloVehiculo().getMarcaVehiculo().getDescripcionMarcaVehiculo());
//        	parameters.put("modeloVehiculo", vehiculo.getModeloVehiculo().getModeloVehiculo());
//        	parameters.put("codigoPatio", entradaVehiculoPatio.getPatio().getCodigoPatio());
//        	parameters.put("nombrePatio", entradaVehiculoPatio.getPatio().getNombrePatio());
//        	parameters.put("fechaEntrada",entradaVehiculoPatio.getFechaEntradaVehiculo());
//        	parameters.put("deudaTotal", deudaTotal);
//        	
//        	String rutaAbsoluta = Utilidades.obtenerRutaAbsolutaServidor();
//        	String nombreArchivoVolante = RUTA_GENERACION_VOLANTES_PATIOS+NOMBRE_VOLANTE_LIQUIDACION+Utilidades.obtenerHora()+".pdf";
//        	nombreArchivo = rutaAbsoluta+nombreArchivoVolante;
//        	jPrint = JasperFillManager.fillReport(reporte, parameters, new JRBeanCollectionDataSource(listVolantePagoLiquidacion));
//        	JasperExportManager.exportReportToPdfFile(jPrint, nombreArchivo);
//			return nombreArchivoVolante+"?pfdrid_c=true";
//        }catch (JRException e){
//        	return "";
//        }
//		
//	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the marcaVehiculo
	 */
	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}

	/**
	 * @param marcaVehiculo the marcaVehiculo to set
	 */
	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	/**
	 * @return the modeloVehiculo
	 */
	public String getModeloVehiculo() {
		return modeloVehiculo;
	}

	/**
	 * @param modeloVehiculo the modeloVehiculo to set
	 */
	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	/**
	 * @return the nombrePatio
	 */
	public String getNombrePatio() {
		return nombrePatio;
	}

	/**
	 * @param nombrePatio the nombrePatio to set
	 */
	public void setNombrePatio(String nombrePatio) {
		this.nombrePatio = nombrePatio;
	}

	/**
	 * @return the fechaEntrada
	 */
	public String getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	/**
	 * @return the entradaVehiculoPatio
	 */
	public EntradaVehiculoPatio getEntradaVehiculoPatio() {
		return entradaVehiculoPatio;
	}


	/**
	 * @param entradaVehiculoPatio the entradaVehiculoPatio to set
	 */
	public void setEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		this.entradaVehiculoPatio = entradaVehiculoPatio;
	}


	/**
	 * @return the valorPatio
	 */
	public ValorPatio getValorPatio() {
		return valorPatio;
	}


	/**
	 * @param valorPatio the valorPatio to set
	 */
	public void setValorPatio(ValorPatio valorPatio) {
		this.valorPatio = valorPatio;
	}


	/**
	 * @return the listVolantePagoLiquidacion
	 */
	public List<VolantePagoLiquidacion> getListVolantePagoLiquidacion() {
		return listVolantePagoLiquidacion;
	}


	/**
	 * @param listVolantePagoLiquidacion the listVolantePagoLiquidacion to set
	 */
	public void setListVolantePagoLiquidacion(
			List<VolantePagoLiquidacion> listVolantePagoLiquidacion) {
		GeneracionVolantesLiquidacionMB.listVolantePagoLiquidacion = listVolantePagoLiquidacion;
	}


	/**
	 * @return the mostrarTable
	 */
	public boolean isMostrarTable() {
		return mostrarTable;
	}


	/**
	 * @param mostrarTable the mostrarTable to set
	 */
	public void setMostrarTable(boolean mostrarTable) {
		this.mostrarTable = mostrarTable;
	}


	/**
	 * @return the deudaTotal
	 */
	public String getDeudaTotal() {
		return deudaTotal;
	}


	/**
	 * @param deudaTotal the deudaTotal to set
	 */
	public void setDeudaTotal(String deudaTotal) {
		this.deudaTotal = deudaTotal;
	}


	/**
	 * @return the consecutivoVolante
	 */
	public ConsecutivoVolante getConsecutivoVolante() {
		return consecutivoVolante;
	}


	/**
	 * @param consecutivoVolante the consecutivoVolante to set
	 */
	public void setConsecutivoVolante(ConsecutivoVolante consecutivoVolante) {
		this.consecutivoVolante = consecutivoVolante;
	}


	/**
	 * @return the volantePatio
	 */
	public VolantePatio getVolantePatio() {
		return volantePatio;
	}


	/**
	 * @param volantePatio the volantePatio to set
	 */
	public void setVolantePatio(VolantePatio volantePatio) {
		this.volantePatio = volantePatio;
	}


	/**
	 * @return the detalleVolantePatio
	 */
	public DetalleVolantePatio getDetalleVolantePatio() {
		return detalleVolantePatio;
	}


	/**
	 * @param detalleVolantePatio the detalleVolantePatio to set
	 */
	public void setDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio) {
		this.detalleVolantePatio = detalleVolantePatio;
	}


	/**
	 * @return the volante
	 */
	public String getVolante() {
		return volante;
	}


	/**
	 * @param volante the volante to set
	 */
	public void setVolante(String volante) {
		this.volante = volante;
	}


	/**
	 * @return the mostrarVolante
	 */
	public boolean isMostrarVolante() {
		return mostrarVolante;
	}


	/**
	 * @param mostrarVolante the mostrarVolante to set
	 */
	public void setMostrarVolante(boolean mostrarVolante) {
		this.mostrarVolante = mostrarVolante;
	}


	/**
	 * @return the mostrarBotonVolante
	 */
	public boolean isMostrarBotonVolante() {
		return mostrarBotonVolante;
	}


	/**
	 * @param mostrarBotonVolante the mostrarBotonVolante to set
	 */
	public void setMostrarBotonVolante(boolean mostrarBotonVolante) {
		this.mostrarBotonVolante = mostrarBotonVolante;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	/**
	 * @return the progress
	 */
	public Integer getProgress() {
		return progress + 1;
	}





	
	
	
	
	
	
}
