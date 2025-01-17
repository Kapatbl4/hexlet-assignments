package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorMapper mapper;

    public List<AuthorDTO> index() {
        var authors = repository.findAll();
        var result = authors.stream()
                .map(mapper::map)
                .toList();
        return result;
    }

    public AuthorDTO getById(Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        var result = mapper.map(author);
        return result;
    }

    public AuthorDTO create(AuthorCreateDTO data) {
        var author = mapper.map(data);
        repository.save(author);
        var result = mapper.map(author);
        return result;
    }

    public AuthorDTO update(Long id, AuthorUpdateDTO data) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        mapper.update(data, author);
        repository.save(author);
        var result = mapper.map(author);
        return result;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
