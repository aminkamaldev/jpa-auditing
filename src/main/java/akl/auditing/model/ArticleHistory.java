package akl.auditing.model;

import akl.auditing.auditing.Action;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class ArticleHistory {
    @Id
    @GeneratedValue
    private Long id;

    private String articleName;

    private String articleContent;

    @CreatedBy
    private String modifiedBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Enumerated(EnumType.STRING)
    private Action action;

    public ArticleHistory() {
    }

    public ArticleHistory(String article, Action action) {
        this.articleName = article;
        this.action = action;
        this.articleContent = article.toString();
    }
}
