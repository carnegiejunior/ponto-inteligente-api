package tech.metamaker.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tech.metamaker.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	/**
	 * Retorna uma lista paginada de lancamentos de um determinado funcionário.
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> buscaPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lancamento por ID.
	 * 
	 * @param id
	 * @return
	 */
	Optional <Lancamento> buscarPorId(Long id);
	
	/**
	 * Persiste um lançamento no banco de dados.
	 * 
	 * @param lancamento
	 * @return
	 */
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remove um Lancamento do banco de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);

}
