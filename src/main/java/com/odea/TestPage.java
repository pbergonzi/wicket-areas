package com.odea;

import com.odea.components.menu.Menu;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class TestPage extends WebPage {
    private static final long serialVersionUID = 1L;
    private String msg = " aver";
    Model<String> model = new Model<String>() {
        private int counter = 0;

        public String getObject() {
            return msg + counter++;
        }
    };

    @SpringBean
    private ServicioFalso servicioFalso;

    public TestPage(final PageParameters parameters) {



        
        add(new Menu("menu-odea"));
        //spring bean
        System.out.println("ServicioFalso dice que : " + servicioFalso.getMsg());


        final Label feedback = new Label("feedback",model);
        feedback.setOutputMarkupId(true);
        add(feedback);

        Form form = new Form("form");
        add(form);
        form.setOutputMarkupId(true);
        FormComponent fc = new RequiredTextField<String>("ajax-msg");
        form.add(fc);

        form.add(new AjaxButton("ajax-button", form)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {

                // repaint the feedback panel so that it is hidden
                target.add(feedback);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form)
            {
                // repaint the feedback panel so errors are shown
                target.add(feedback);
            }
        });
         /*
        List<IColumn<Contact>> columns = new ArrayList<IColumn<Contact>>();

        columns.add(new PropertyColumn<Contact>(new Model<String>("ID"), "id"));
        columns.add(new PropertyColumn<Contact>(new Model<String>("First Name"), "firstName",
                "firstName"));
        columns.add(new PropertyColumn<Contact>(new Model<String>("Last Name"), "lastName",
                "lastName"));

        add(new AjaxFallbackDefaultDataTable<Contact>("table", columns,
                new SortableContactDataProvider(), 8));     */
    }
}
