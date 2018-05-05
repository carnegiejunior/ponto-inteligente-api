package tech.metamaker.pontointeligente.api.services;

import java.util.Optional;

import tech.metamaker.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persiste um usuário na base de dados
	 * 
	 * @param Funcionario funcionario
	 * @return Funcionario funcionario
	 */
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Busca e retorna um funcionario dado um cpf
	 * 
	 * @param String CPF
	 * @return Optional<Funcionario>  
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retorna um funcionario dado um email
	 * 
	 * @param String EMAIL
	 * @return Optional<Funcionario>  
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um funcionario dado um id
	 * 
	 * @param Long id
	 * @return Optional<Funcionario>  
	 */
	Optional<Funcionario> buscarPorId(Long id);
	
}
