package com.odea.components.tabpanel;

import com.odea.components.menu.Menu;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TabPanel extends Panel implements IHeaderContributor {

    public TabPanel(String id) {
        super(id);
        WebMarkupContainer outerDiv = new WebMarkupContainer("outerDiv");

        List<TabItem> tabs = new ArrayList<TabItem>();
        for(int i=0;i<2;i++){
            tabs.add(new TabItem() {
                public Label getTitle(String id) {
                    return new Label(id,"titulo");
                }

                public Panel getContent(String id) {
                    return new Menu(id);
                }
            });    
        }

        outerDiv.add(new MenuItems("tabs", tabs));
        add(outerDiv);
    }

    class MenuItems extends ListView<TabItem>{

        public MenuItems(String id, List<TabItem> list) {
            super(id, list);
        }

        @Override
        protected void populateItem(final ListItem<TabItem> item) {
            TabItem panel = item.getModelObject();
            item.add(panel.getTitle("tab-name"));
            item.add(panel.getContent("tab-content"));
        }
    }

}
