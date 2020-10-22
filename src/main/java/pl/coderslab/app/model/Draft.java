package pl.coderslab.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Draft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "To pole musi być wypełnione")
    private String title;
    @NotEmpty(message = "O tym polu też nie zapomnij")
    private String content;

    public Draft() {
    }

    public Draft(@NotEmpty(message = "To pole musi być wypełnione") String title, @NotEmpty(message = "O tym polu też nie zapomnij") String content) {
        this.title = title;
        this.content = content;
    }
}
