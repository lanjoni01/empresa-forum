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
@RequestMapping("/api/empresa")
public class EmpresaController {
	@Autowired 
	private EmpresaRepository empresaRepository;

	@GetMapping
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable String id) {
        Optional<Empresa> entidadeOptional = empresaRepository.findById(id);
        if(!entidadeOptional.isPresent()) {
        	throw new RegistroNaoEncontradoException();
        }
        return entidadeOptional.get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
    	empresaRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
	public void put(@PathVariable String id, @RequestBody Empresa EmpresaUpdate) {
		Optional<Empresa> EmpresaBuscado = empresaRepository.findById(id);
    	if(!EmpresaBuscado.isPresent()) {
    		throw new RegistroNaoEncontradoException();
    	}
    	empresaRepository.save(EmpresaUpdate);
	}
    
    @PostMapping
    public Empresa post(@RequestBody Empresa Empresa) {
    	if(empresaRepository.findById(Empresa.getId()).isPresent()) {
    		throw new RegistroDuplicadoException();
    	}
        return empresaRepository.save(Empresa);
    }
}
