package java.com.biblioteca.biblioteca.model;

import javax.annotation.processing.Generated;

@Entity
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String isbn;
}