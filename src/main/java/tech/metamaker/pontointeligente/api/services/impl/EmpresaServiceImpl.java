package tech.metamaker.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.metamaker.pontointeligente.api.entities.Empresa;
import tech.metamaker.pontointeligente.api.repositories.EmpresaRepository;
import tech.metamaker.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscarPorCNPJ(String cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(this.empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo {}", empresa);
		return this.empresaRepository.save(empresa);
	}

}
