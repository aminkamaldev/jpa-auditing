package akl.auditing.auditing;

import akl.auditing.model.Article;
import akl.auditing.model.ArticleHistory;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import static akl.auditing.auditing.Action.DELETED;
import static akl.auditing.auditing.Action.INSERTED;
import static akl.auditing.auditing.Action.UPDATED;

public class ArticleEntityListener {

    @PrePersist
    public void prePersist(Article article){
        perform(article,INSERTED);
    }

    @PreUpdate
    public void preUpdate(Article article){
        perform(article,UPDATED);
    }

    @PreRemove
    public void preRemove(Article article){
        perform(article,DELETED);
    }

    @Transactional(Transactional.TxType.MANDATORY)
    private void perform(Article article, Action action){
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        entityManager.persist(new ArticleHistory(article.getTitre(),action));
    }
}
