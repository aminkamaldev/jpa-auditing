package akl.auditing.auditing;

import akl.auditing.model.ArticleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleHistoryRepository extends JpaRepository<ArticleHistory,Long> {
}
