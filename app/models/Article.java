package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by whiterkim on 2016/7/24.
 */

@Entity
public class Article extends Model{
    @Id
    public String title;
    public String content;

    public static Find<Long, Article> find = new Find<Long, Article>(){};

    public static List<Article> allArticles() {
        try {
            return find.findList();
        } catch (Exception e) {
            return null;
        }
    }
}
