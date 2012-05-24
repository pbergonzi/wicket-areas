package com.odea.components.menu;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import java.io.Serializable;

public interface MenuItem extends Serializable{
    public Link getLink(String headerWicketId);
    public Label getLabel(String contentWicketId);
}
