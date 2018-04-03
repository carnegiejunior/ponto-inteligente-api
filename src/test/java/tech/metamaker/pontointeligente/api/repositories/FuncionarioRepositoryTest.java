package tech.metamaker.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import tech.metamaker.pontointeligente.api.entities.Funcionario;

@Transactional(readOnly=true)
public interface FuncionarioRepositoryTest extends JpaRepository<Funcionario, Long> {
	
	Funcionario findByCpf(String cpf);
	Funcionario findByEmail(String email);
	Funcionario findByCpfOrEmail(String cpf, String email);
	
}
