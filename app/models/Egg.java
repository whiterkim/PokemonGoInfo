package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by whiterkim on 2016/7/25.
 */

@Entity
public class Egg extends Model{
    @Id
    public Long id;
    public String name;
    public Long distance;

    public static Find<Long, Egg> find = new Find<Long, Egg>(){};

    public static List<Egg> allEggs(Integer km) {
        try {
            return find.where().eq("distance", km).findList();
        } catch (Exception e) {
            return null;
        }
    }
}
