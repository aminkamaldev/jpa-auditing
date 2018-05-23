package akl.auditing.model;

import akl.auditing.auditing.ArticleEntityListener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@EntityListeners(ArticleEntityListener.class)
@Data@NoArgsConstructor@ToString
public class Article extends Auditable<String> {
    @Id
    @GeneratedValue
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;
    private String titre;
    private String contenu;

    public Article(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }
}
