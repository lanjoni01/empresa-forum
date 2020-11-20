package leonado.empresas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filial")
public class FilialController {
	
	@Autowired 
	private FilialRepository filialRepository;

	@GetMapping
    public List<Filial> getAll() {
        return filialRepository.findAll();
    }

    @GetMapping("/{id}")
    public Filial getById(@PathVariable String id) {
        Optional<Filial> entidadeOptional = filialRepository.findById(id);
        if(!entidadeOptional.isPresent()) {
        	throw new RegistroNaoEncontradoException();
        }
        return entidadeOptional.get();
    }
    
    @GetMapping("/obter-pelo-cnpj-empresa/{cnpj}")
    public List<Filial> obterFiliaisPorCnpjEmpresa(@PathVariable String cnpj) {
    	if(cnpj == null || cnpj == "") {
    		throw new CnpjObrigatorioException();
    	}
    	List<Filial> filiais = filialRepository.obterTodasFiliaisPelaEmpresa(cnpj);
    	return filiais;
    }
    
    @GetMapping("/obter-total-filial-cnpj-empresa/{cnpj}")
    public Integer obterTotalFiliaisPorCnpjEmpresa(@PathVariable String cnpj) {
    	if(cnpj == null || cnpj == "") {
    		throw new CnpjObrigatorioException();
    	}
    	List<Filial> filiais = filialRepository.obterTodasFiliaisPelaEmpresa(cnpj);
    	return filiais.size();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
    	filialRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
	public void put(@PathVariable String id, @RequestBody Filial FilialUpdate) {
		Optional<Filial> FilialBuscado = filialRepository.findById(id);
    	if(!FilialBuscado.isPresent()) {
    		throw new RegistroNaoEncontradoException();
    	}
    	filialRepository.save(FilialUpdate);
	}
    
    @PostMapping
    public Filial post(@RequestBody Filial Filial) {
    	if(filialRepository.findById(Filial.getId()).isPresent()) {
    		throw new RegistroDuplicadoException();
    	}
        return filialRepository.save(Filial);
    }
    
    
}
