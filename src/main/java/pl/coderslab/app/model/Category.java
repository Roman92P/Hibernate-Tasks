package pl.coderslab.app.model;
//    Encja ma zawierać następujące pola:
//
//    id
//    name (max 100 znaków)
//    description (może przyjmować wartość null)

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@Setter
@Getter
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    @Size(min = 5)
    @NotEmpty
    private String name;
    @Column(nullable = true)
    private String description;
    @ManyToMany(mappedBy = "categoryList", fetch = FetchType.EAGER)
    private Set<Article> articles = new HashSet<>();
    public Category() {
    }

}
