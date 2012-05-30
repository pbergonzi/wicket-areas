package com.odea.components.jqueryTab;

import com.odea.components.menu.Menu;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

public class JQueryTap extends Panel implements IHeaderContributor {
    public JQueryTap(String id) {
        super(id);
        List<IJQueryTab> tabs = this.getTabs();
        add(new TabPanelTabs("titles", tabs));
        add(new TabPanelContent("panels", tabs));
    }


    class TabPanelTabs extends ListView<IJQueryTab> {

        public TabPanelTabs(String id, List<? extends IJQueryTab> jQueryTabs) {
            super(id, jQueryTabs);
        }

        @Override
        protected void populateItem(ListItem<IJQueryTab> components) {
            IJQueryTab tab = components.getModelObject();
            components.add(tab.getLink("link").add(tab.getLabel("nombre")));
        }
    }

    class TabPanelContent extends ListView<IJQueryTab> {

        public TabPanelContent(String id, List<? extends IJQueryTab> jQueryTabs) {
            super(id, jQueryTabs);
        }

        @Override
        protected void populateItem(ListItem<IJQueryTab> components) {
            IJQueryTab tab = components.getModelObject();
            components.add(tab.getContent("content"));
        }
    }

    //TODO check que sea unico el nombre de la tab
    private List<IJQueryTab> getTabs() {
        List<IJQueryTab> tabs = new ArrayList<IJQueryTab>();
        tabs.add(new MenuTab("Menu1"));
        tabs.add(new MenuTab("Menu2"));
        tabs.add(new MenuTab("Menu3"));
        return tabs;
    }

    class MenuTab implements IJQueryTab {
        private String tabName;

        public MenuTab(String tabName) {
            this.tabName = tabName;
        }

        public ExternalLink getLink(String headerWicketId) {
            return new ExternalLink(headerWicketId, new Model<String>("#" + tabName));
        }

        public Label getLabel(String titleWicketId) {
            return new Label(titleWicketId, tabName);
        }

        public Panel getContent(String contentWicketId) {
            Menu menu = new Menu(contentWicketId);
            menu.setMarkupId(tabName);
            menu.setOutputMarkupId(true);
            return menu;
        }
    }
}
