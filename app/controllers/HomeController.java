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

/**
 * Manage a database of computers
 */
public class HomeController  extends Controller {

    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }
    
    /**
     * Handle default path requests, redirect to computers list
     */
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
        return redirect(routes.HomeController.index());
    }

    public Result getEggs(int km) {
        return ok(views.html.eggs.render(km, Egg.allEggs(km)));
    }
}
            
