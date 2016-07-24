package controllers;

import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        //ArrayList<Integer> arrayList = new ArrayList<>(10);
        int[] arrayList = new int[10];
        for (int i = 0; i < 10; i++)
            //arrayList.add(i);
            arrayList[i] = i;
        return ok(index.render("String", arrayList));
    }

}
