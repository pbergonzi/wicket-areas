package com.odea.components.composed.tabbedmenu;


import com.odea.components.menu.Menu;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

public class TabbedMenu extends Panel implements IHeaderContributor {

    public TabbedMenu(String id) {
        super(id);
        List<ITab> tabs = new ArrayList<ITab>();
        for(int i = 0 ; i<4 ; i++){
            Model<String> model = new Model<String>("Menu" + i);
            Tab tab = new Tab(model);
            if(i==1){
                tab.setVisible(true);
            }
            tabs.add(tab);
        }
        TabbedPanel tabbedPanel = new TabbedPanel("tabs",tabs);
        add(tabbedPanel);
                
    }
    
    private class Tab implements ITab{
        private boolean isVisible = true;
        private IModel<String> title;
        
        public Tab(IModel<String> title){
            this.title = title;
        }

        public IModel<String> getTitle() {
            return this.title;
        }

        public WebMarkupContainer getPanel(String s) {
            return new Menu(s);
        }

        public boolean isVisible() {
            return this.isVisible;
        }

        public void setVisible(boolean visible){
            this.isVisible = visible;
        }
} 
}
