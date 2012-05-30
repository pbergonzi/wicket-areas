package com.odea.components.jqueryTab;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;

import java.io.Serializable;

public interface IJQueryTab extends Serializable {
    public ExternalLink getLink(String headerWicketId);

    public Label getLabel(String titleWicketId);

    public Panel getContent(String contentWicketId);
}
