package tech.metamaker.pontointeligente.api.repositories;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import tech.metamaker.pontointeligente.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public interface EmpresaRepositoryTest {
	
	@Transactional(readOnly=true)
	Empresa findByCnpj(String cnpj);
}
