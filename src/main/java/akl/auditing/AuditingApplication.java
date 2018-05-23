package akl.auditing;

import akl.auditing.auditing.ArticleRepository;
import akl.auditing.model.Article;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class AuditingApplication implements CommandLineRunner{

    @Resource ArticleRepository articleRepository;
	public static void main(String[] args) {
		SpringApplication.run(AuditingApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Article article = new Article("Article 1", "Contenu de l'article");
		articleRepository.save(article);
		article.setTitre("Mise a jour du titre");
		article.setContenu("Mise a jour du contenu");
		articleRepository.saveAndFlush(article);
		articleRepository.delete(1l);
	}
}
