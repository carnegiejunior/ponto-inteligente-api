package tech.metamaker.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import tech.metamaker.pontointeligente.api.entities.Empresa;
import tech.metamaker.pontointeligente.api.entities.Funcionario;
import tech.metamaker.pontointeligente.api.entities.Lancamento;
import tech.metamaker.pontointeligente.api.enums.PerfilEnum;
import tech.metamaker.pontointeligente.api.enums.TipoEnum;
import tech.metamaker.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

	static final String EMAIL = "carnegiejunior@gmail.com";
	static final String CPF = "70609039334";

	
	@Autowired 
	private LancamentoRepository lancamentoRepository;
	
	@Autowired 
	private FuncionarioRepository funcionarioRepository;

	@Autowired 
	private EmpresaRepository empresaRepository;

	private Long funcionarioId;
	
	@Before
	public void setUp() throws Exception{
		
		Empresa empresa = this.empresaRepository.save(this.obterDadosEmpresa());
		
		Funcionario funcionario = this.funcionarioRepository.save(this.obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
	
	}


	@After
	public void tearDown() {
		this.empresaRepository.deleteAll();
	}


	@Test
	public void testBucarLancamentosPorFuncionarioId() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(this.funcionarioId);
		assertEquals(2, lancamentos.size());
	}

	@Test
	public void testBucarLancamentosPorFuncionarioIdPaginado() {
		PageRequest page = new PageRequest(0,10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(this.funcionarioId,page );
		assertEquals(2, lancamentos.getTotalElements());
	}
	
	
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("01057487000101");
		return empresa;
	}

	private Lancamento obterDadosLancamentos(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		lancamento.setDescricao("Teste");
		lancamento.setLocalizacao("Localização");
		return lancamento;
	}
}
