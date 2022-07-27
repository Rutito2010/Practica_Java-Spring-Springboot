package com.example.PracticaSpringBoot.Controller;

import com.example.PracticaSpringBoot.Entities.Books;
import com.example.PracticaSpringBoot.Respositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    private final Logger log = LoggerFactory.getLogger(BooksController.class);

    private BooksRepository bookrespository;

    public BooksController(BooksRepository bookrespository) {
        this.bookrespository = bookrespository
        ;
    }

    //Crud Books
    @GetMapping("/api/books")
   // public ResponseEntity<List<Books>> findAll() {
        public List<Books> findAll () {
            return bookrespository.findAll();
            /* List<Books>result= bookrespository.findAll();
       if(result.size()>0) {
        return ResponseEntity.ok(result);}
       else
           return ResponseEntity.notFound().build();*/
        }


    @GetMapping("/api/books/{id}")
    public ResponseEntity<Books> getfindById(@PathVariable Long id) {
        Optional<Books> result = bookrespository.findById(id);

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping("/api/books")

    public ResponseEntity<Books> createBook(@RequestBody Books book, @RequestHeader HttpHeaders headers) {
        if (book.getId() != null) {
            log.warn("The book id its created automatically, if you are trying to modify a book, please go to the modification section ");
            return ResponseEntity.badRequest().build();
        } else {
            Books result=bookrespository.save(book);
            return ResponseEntity.ok(result);
        }
    }

    @PutMapping("/api/books/")
    public ResponseEntity<Books> updateBook(@RequestBody Books book) {
        if (book.getId() == null) {
            log.warn("you need to specify a book id to update");
            return ResponseEntity.badRequest().build();
        } else {
            if (bookrespository.existsById(book.getId())) {
                return ResponseEntity.ok(bookrespository.save(book));}else{
                log.warn("The id you provided did not appear in our database");
            return ResponseEntity.notFound().build();}


        }
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if(!bookrespository.existsById(id)){
            log.warn("The id you provided did not appear in our database");
            return ResponseEntity.notFound().build();
        }else{
        bookrespository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Void> deleteAllBooks() {
        bookrespository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
