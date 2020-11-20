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
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Endereco getById(@PathVariable String id) {
        Optional<Endereco> entidadeOptional = enderecoRepository.findById(id);
        if(!entidadeOptional.isPresent()) {
        	throw new RegistroNaoEncontradoException();
        }
        return entidadeOptional.get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
    	enderecoRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
	public void put(@PathVariable String id, @RequestBody Endereco EnderecoUpdate) {
		Optional<Endereco> EnderecoBuscado = enderecoRepository.findById(id);
    	if(!EnderecoBuscado.isPresent()) {
    		throw new RegistroNaoEncontradoException();
    	}
    	enderecoRepository.save(EnderecoUpdate);
	}
    
    @PostMapping
    public Endereco post(@RequestBody Endereco Endereco) {
    	if(enderecoRepository.findById(Endereco.getId()).isPresent()) {
    		throw new RegistroDuplicadoException();
    	}
        return enderecoRepository.save(Endereco);
    }
}
