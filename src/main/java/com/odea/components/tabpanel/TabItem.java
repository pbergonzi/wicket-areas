package com.odea.components.tabpanel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public interface TabItem {
    public Label getTitle(String id);
    public Panel getContent(String id);
}
