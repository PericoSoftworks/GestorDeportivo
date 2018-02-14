package com.grupob.practicafinal.backend.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.EquipoRepository;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;

@Controller
@RequestMapping(value = "grupob/api/")
public class PartidoControllerAPI {

	@Autowired
	PartidoRepository partidoRepository;
	
	@Autowired
	EquipoRepository equipoRepository;

	// GetAllPartidos
	@RequestMapping(value = "/partidos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> getAllEquipos() {

		List<Partido> partido = partidoRepository.findAll();

		return partido;
	}

	// GetPartido
	@RequestMapping(value = "/partidos/{ID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Partido getPartido(@PathVariable("ID") int ID) {
		Partido partido = partidoRepository.findOne(ID);

		return partido;
	}

	// GetByJornada

	@RequestMapping(value = "/partidos/jornada/{jornada}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> getPartidosByJornada(@PathVariable("jornada") String jornada) {

		List<Partido> partidos = partidoRepository.getByJornada(jornada);

		return partidos;
	}

	// GetByEstado
	@RequestMapping(value = "/partidos/estado/{estado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> getPartidosByEstado(@PathVariable("estado") String estado) {

		List<Partido> partidos = partidoRepository.getByEstado(estado);

		return partidos;
	}

	
	//GetClasificacion
	
	List<Partido> partidos = partidoRepository.getByEstado("PENDIENTE");
	
	//SumaGolesvisitante
	
	private Map<Equipo,Integer> sumaGolesVisitante(List<Partido> partidos){
		
		List<Equipo> equipos = equipoRepository.findAll();
		Map<Equipo,Integer> golesVisitantes = new HashMap<Equipo,Integer>();
		Equipo equipovisitante;
		
				for (Equipo equipo : equipos) {
					golesVisitantes.put(equipo, 0);
				}
				for (Partido partido : partidos) {
					equipovisitante = partido.getVisitante();
					
					
					golesVisitantes.put(equipovisitante,partido.getGolesVisitante());
					
				}
		
		return golesVisitantes;
	}
	
	
	
	
}