package com.valdir.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.os.domain.Cliente;
import com.valdir.os.domain.OS;
import com.valdir.os.domain.Tecnico;
import com.valdir.os.domain.enuns.Prioridade;
import com.valdir.os.domain.enuns.Status;
import com.valdir.os.repositories.ClienteRepository;
import com.valdir.os.repositories.OSRepository;
import com.valdir.os.repositories.TecnicoRepository;


@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "527.285.910-32", "Joao", "32211233");
		Cliente c1 = new Cliente(null, "796.247.770-98", "Carlos", "12332123");
		OS os1 = new OS(null, Prioridade.BAIXA, Status.ABERTO, "Nova oredem de serviço", t1, c1);
		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
