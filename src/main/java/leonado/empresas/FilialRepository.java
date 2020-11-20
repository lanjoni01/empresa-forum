package leonado.empresas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilialRepository extends JpaRepository<Filial, String> {
	@Query(value = "select fi.* from FILIAL AS fi " + 
			"join EMPRESA as em on em.id = fi.empresa_id " +
			"where em.cnpj = :cnpjEmpresa", nativeQuery = true)
	public List<Filial> obterTodasFiliaisPelaEmpresa(@Param(value = "cnpjEmpresa") String cnpjEmpresa);
	
}
