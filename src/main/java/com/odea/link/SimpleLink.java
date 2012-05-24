package com.odea.link;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.panel.Panel;

public class SimpleLink extends Panel implements IHeaderContributor {
    public SimpleLink(String id) {
        super(id);
        Link link = new Link("url") {
            @Override
            public void onClick() {
                System.out.println("epa epa epa");
            }
        };


        
    }

}

