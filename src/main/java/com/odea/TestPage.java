package com.odea;


import com.odea.components.autocompleteBox.JQueryAutoCompleteTextBox;
import com.odea.components.grid.DataTable;
import com.odea.components.jqueryTab.JQueryTap;
import com.odea.components.menu.Menu;
import com.odea.service.ServicioFalso;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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

    Form form1;
    TextField stateTextField;
    private String state = "";

    public TestPage(final PageParameters parameters) {


        add(form1 = new Form<HomePage>("form1") {

            @Override
            protected void onSubmit() {
                super.onSubmit();
                Logger logger = LoggerFactory.getLogger(this.getClass());
                logger.info("The user selected: " + state);
            }
        });

        form1.add(stateTextField = new JQueryAutoCompleteTextBox<String>("state", new PropertyModel<String>(this, "state"),"input.jqueryid_state") {
            @Override
            public List<?> getResultados(String parametro) {
                List<State> statesLike = StatesDb.getStatesLike(parametro.toString());
                return statesLike;
            }
        });


        //add(new DataTable("tabla"));
        //add(new JQueryTap("tab-panel"));

        //spring bean
        System.out.println("ServicioFalso dice que : " + servicioFalso.getMsg());

        final Label contador = new Label("contador", model);

        contador.setOutputMarkupId(true);
        //add(contador);

        Form form = new Form("form");
        //add(form);
        form.setOutputMarkupId(true);

        final FormComponent fc = new RequiredTextField<String>("ajax-msg", new Model<String>());
        form.add(fc);

        form.add(new AjaxButton("ajax-button", form) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                if (fc.getInput() != null) {
                    model.setObject(fc.getInput());
                }

                target.add(contador);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
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


    private class ETab implements ITab {
        public IModel<String> getTitle() {
            return new Model<String>("TabMia");
        }

        public WebMarkupContainer getPanel(String s) {
            return new Menu(s);
        }

        public boolean isVisible() {
            return true;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }


    /*
    * A State class jsonified into an array and returned to the client
    */
    static class State {

        State() {
        }

        State(String name) {
            this.name = name;
        }

        String name;
    }

    private static class StatesDb {

        private static final String[] states = new String[]{
                "Alabama",
                "Alaska",
                "Arizona",
                "Arkansas",
                "California",
                "Colorado",
                "Connecticut",
                "Delaware",
                "Florida",
                "Georgia",
                "Hawaii",
                "Idaho",
                "Illinois",
                "Indiana",
                "Iowa",
                "Kansas",
                "Kentucky",
                "Louisiana",
                "Maine",
                "Maryland",
                "Massachusetts",
                "Michigan",
                "Minnesota",
                "Mississippi",
                "Missouri",
                "Montana",
                "Nebraska",
                "Nevada",
                "New Hampshire",
                "New Jersey",
                "New Mexico",
                "New York",
                "North Carolina",
                "North Dakota",
                "Ohio",
                "Oklahoma",
                "Oregon",
                "Pennsylvania",
                "Rhode Island",
                "South Carolina",
                "South Dakota",
                "Tennessee",
                "Texas",
                "Utah",
                "Vermont",
                "Virginia",
                "Washington",
                "West Virginia",
                "Wisconsin",
                "Wyoming"
        };

        static List<State> getStatesLike(String target) {

            List<State> matches = new ArrayList<State>();
            for (String s : states) {
                if (s.toLowerCase().startsWith(target.toLowerCase())) {
                    State state = new State(s);
                    matches.add(state);
                }
            }
            return matches;
        }

    }

}
