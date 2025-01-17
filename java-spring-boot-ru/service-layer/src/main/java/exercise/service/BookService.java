package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Author;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO getById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        var result = bookMapper.map(book);
        return result;
    }

    public BookDTO create(BookCreateDTO data) {
        var author = authorRepository.findById(data.getAuthorId()).isEmpty() ? null :
                authorRepository.findById(data.getAuthorId()).get();
        var book = bookMapper.map(data);
        book.setAuthor(author);
        bookRepository.save(book);
        var result = bookMapper.map(book);
        return result;
    }

    public BookDTO update(BookUpdateDTO data, Long id) {
        var author = authorRepository.findById(data.getAuthorId().get()).isEmpty() ? null :
                authorRepository.findById(data.getAuthorId().get()).get();
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        bookMapper.update(data, book);
        book.setAuthor(author);
        bookRepository.save(book);
        var result = bookMapper.map(book);
        return result;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
