package pl.coderslab.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    @NotEmpty
    @Size(max = 200,message = "maksimum 200 znaków")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "minimum 10 znaków")
    private String content;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;


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

