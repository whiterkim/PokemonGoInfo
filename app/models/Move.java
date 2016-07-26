package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by whiterkim on 2016/7/26.
 */

@Entity
public class Move extends Model{
    @Id
    public int id;
    public String name;
    public String move_type;

    public int power;
    public int critical_hit_rate;
    public int cooldown;
    public int energy_inc;

    public static Model.Find<Long, Move> find = new Model.Find<Long, Move>(){};

    public static List<Move> allMoves(int type) {
        try {
            if (type == 0)
                return find.findList();
            else if (type == 1)
                return find.where().gt("energy_inc", 0).findList();
            else
                return find.where().lt("energy_inc", 0).findList();
        } catch (Exception e) {
            return null;
        }
    }
}
