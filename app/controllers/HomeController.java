package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;


public class HomeController  extends Controller {

    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result index()
    {
        //return GO_HOME;
        return ok(views.html.index.render(Article.allArticles()));
    }

    public Result add() {
        Form<Article> articleForm = formFactory.form(Article.class).bindFromRequest();
        Article article = articleForm.get();
        article.save();
        //return ok(views.html.add.render(article));
        return redirect(routes.HomeController.comment());
    }

    public Result comment() {
        return ok(views.html.comment.render(Article.allArticles()));
    }

    public Result pokemonList(String type) {
        return ok(views.html.pokemon.render(Pokemon.allPokemon(type), Pokemon.typeList()));
    }

    public Result evolveCandy(int num) {
        return ok(views.html.candy.render(Pokemon.needsCandy(num)));
    }

    public Result moveList(int type) {
        return ok(views.html.moves.render(Move.allMoves(type)));
    }
    public Result getEggs(int km) {
        return ok(views.html.eggs.render(km, Pokemon.allEggs(km)));
    }
}
            
