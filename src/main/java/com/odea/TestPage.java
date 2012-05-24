package com.odea;

import com.odea.components.composed.tabbedmenu.TabbedMenu;
import com.odea.components.menu.Menu;
import com.odea.components.tabpanel.TabPanel;
import com.odea.service.ServicioFalso;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class TestPage extends WebPage {
    private static final long serialVersionUID = 1L;

    Model<String> model = new Model<String>() {
        private int counter = 0;
        String msg = " aver";

        @Override
        public void setObject(String object) {
            this.msg = object;
        }

        public String getObject() {

            return msg + counter++;
        }
    };

    @SpringBean
    private ServicioFalso servicioFalso;

    public TestPage(final PageParameters parameters) {



        
        //add(new Menu("menu-odea"));
        add(new TabPanel("tab-panel"));

                //spring bean
                System.out.println("ServicioFalso dice que : " + servicioFalso.getMsg());

        final Label contador = new Label("contador",model);

        contador.setOutputMarkupId(true);
        add(contador);

        Form form = new Form("form");
        add(form);
        form.setOutputMarkupId(true);

        final FormComponent fc = new RequiredTextField<String>("ajax-msg",new Model<String>());
        form.add(fc);

        form.add(new AjaxButton("ajax-button", form)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                if(fc.getInput() != null){
                    model.setObject(fc.getInput());
                }
                
                target.add(contador);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form)
            {
                // repaint the feedback panel so errors are shown
                target.add(contador);
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
