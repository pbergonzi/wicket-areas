package com.odea.components.menu;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.ArrayList;
import java.util.List;

public class Menu extends Panel implements IHeaderContributor {
    public Menu(String id) {
        super(id);
        WebMarkupContainer outerDiv = new WebMarkupContainer("menu");
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        for(int i=0;i<10;i++){
            menuItems.add(new MenuItem() {
                public Label getLabel(String headerWicketId) {
                    return new Label(headerWicketId, "link");
                }

                public Link getLink(String contentWicketId) {
                    return new Link(contentWicketId) {
                        @Override
                        public void onClick() {
                            System.out.println("no tokeeeeee que tokaaaaaaaaaaaa gato ");
                        }
                    };
                }
            });
        }
        outerDiv.add(new MenuItems("items", menuItems));
        add(outerDiv);
    }

    class MenuItems extends ListView<MenuItem> {

        public MenuItems(String id, List<MenuItem> list) {
            super(id, list);
        }

        @Override
        protected void populateItem(final ListItem<MenuItem> item) {
            MenuItem menuItem = item.getModelObject();
            item.add(menuItem.getLink("url").add(menuItem.getLabel("nombre")));
        }

    }

}

