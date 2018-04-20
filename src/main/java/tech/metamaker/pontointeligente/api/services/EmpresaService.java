package tech.metamaker.pontointeligente.api.services;

import java.util.Optional;

import tech.metamaker.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	/**
	 * Retorna uma empresa dado um CNPJ
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCNPJ(String cnpj);
	
	
	/**
	 * Cadastra uma empresa na base de dados
	 * @param empresa
	 * @return Empresa
	 */
	
	Empresa persistir(Empresa empresa);
	
	
	
}
