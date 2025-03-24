package org.example.deeprice.controller;


import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.example.deeprice.view.View;
import org.example.deeprice.view.ViewClient;
import org.example.deeprice.view.Webpage;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Maurice Amon
 */

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/")
public class RestController {

    @GetMapping("/")
    public String start() {
        GraphDBConnector graphDBConnector = new GraphDBConnector();
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.ETERNAL_PREF_PAGE);
        return view.getViewContent();
    }

    @GetMapping("/ephemeral")
    public String emphemeral() {
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.EPHEMERAL_PREF_PAGE);
        return view.getViewContent();
    }
}
