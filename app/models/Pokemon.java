package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by whiterkim on 2016/7/26.
 */

@Entity
public class Pokemon extends Model{

    @Id
    public int id;
    public String name;
    public String type1;
    public String type2;

    public int hp;
    public int attack;
    public int defence;

    public int capture_rate;
    public int escape_rate;
    public int max_cp;

    public int move_interval;
    public int attack_interval;

    public int evolve_candy;
    public int distance;

    public static Model.Find<Long, Pokemon> find = new Model.Find<Long, Pokemon>(){};

    public static List<Pokemon> allPokemon(String type) {
        try {
            if (type.equals("All"))
                return find.findList();
            else
                return find.where().or(
                        com.avaje.ebean.Expr.eq("type1", type),
                        com.avaje.ebean.Expr.eq("type2", type)
                ).findList();
        } catch (Exception e) {
            return null;
        }
    }

    private  static final ArrayList<String> list = new ArrayList<>(Arrays.asList("Normal","Fighting","Flying","Poison","Ground","Rock","Bug","Ghost","Steel","Fire","Water","Grass","Electric","Psychic","Ice","Dragon","Dark","Fairy"));
    public static List<String> typeList() {
        return list;
    }

    public static List<Pokemon> needsCandy(Integer num) {
        try {
            if (num == 0)
                return find.findList();
            else
                return find.where().eq("evolve_candy", num).findList();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Pokemon> allEggs(Integer km) {
        try {
            return find.where().eq("distance", km).findList();
        } catch (Exception e) {
            return null;
        }
    }

}
