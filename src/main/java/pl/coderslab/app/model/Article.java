package pl.coderslab.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@GroupSequence({ArticleValid.class, DraftValid.class,Article.class})
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    @NotEmpty(groups = {ArticleValid.class, DraftValid.class})
    @Size(max = 200,message = "maksimum 200 znaków",groups = {ArticleValid.class, DraftValid.class})
    private String title;

    @NotEmpty(groups = {ArticleValid.class, DraftValid.class})
    @Size(min = 10, message = "minimum 10 znaków",groups = {ArticleValid.class, DraftValid.class})
    private String content;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @Size(min=1, groups = {ArticleValid.class})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList = new ArrayList<>();


    @Transient
    private boolean draft;

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

