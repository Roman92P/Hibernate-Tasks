package pl.coderslab.app.model;
//    Utwórz encję Article,
//    Encja ma zawierać następujące pola:
//
//    id
//    title (max. 200 znaków),
//    author - (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora
//    categories - (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii
//    content
//    created (wartość ma być automatycznie dodawana podczas zapisu)
//    updated (wartość ma być automatycznie zmieniana podczas edycji).

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
//@ArticleAnotation

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    private String title;

    private String content;

    @OneToOne()
    @JoinColumn(name = "author_id")
    private Author author;


    @ValidateCategory
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList = new ArrayList<>();


    //    private boolean draft;

    public Article() {
    }

    private LocalDateTime created;

    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

}

