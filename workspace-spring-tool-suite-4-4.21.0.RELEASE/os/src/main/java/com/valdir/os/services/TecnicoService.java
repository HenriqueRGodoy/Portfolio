package com.valdir.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.os.domain.Tecnico;
import com.valdir.os.dtos.TecnicoDTO;
import com.valdir.os.repositories.TecnicoRepository;
import com.valdir.os.services.exceptions.DataIntegratyViolationException;
import com.valdir.os.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	public Tecnico findById(Integer id) {
		
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Técnico não encontrado!  Id: " + id + " Tipo: " + Tecnico.class.getName()));
	}
	
	public List<Tecnico> getAll() {
		return tecnicoRepository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		
		if(findByCpf(objDTO) != null) {
			throw new DataIntegratyViolationException("Cpf já cadastrado!");
		}
		if(findByName(objDTO) != null) {
			throw new DataIntegratyViolationException("Nome ja cadastrado!");
		}
		Tecnico obj = new Tecnico(null, objDTO.getCpf(), objDTO.getNome(), objDTO.getTelefone());
		return tecnicoRepository.save(obj);
	}
	
	private Tecnico findByCpf(TecnicoDTO objDTO) {
		Tecnico obj = tecnicoRepository.findByCpf(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}
	
	private Tecnico findByName(TecnicoDTO objDTO) {
		Tecnico obj = tecnicoRepository.findByName(objDTO.getNome());
		if(obj != null) {
			return obj;
		}
		return null;
	}

//	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
//		Tecnico oldObj = findById(id)
//		return null;
//	}
}
