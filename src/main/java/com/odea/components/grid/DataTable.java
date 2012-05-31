package com.odea.components.grid;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.LoadableDetachableModel;

import java.util.ArrayList;
import java.util.List;

public class DataTable extends Panel {
    public DataTable(String id) {
        super(id);

        LoadableDetachableModel <List<String>> columnas = new LoadableDetachableModel<List<String>>() {
            @Override
            protected List<String> load() {
                List<String> columnas = new ArrayList<String>();
                columnas.add("Id");
                columnas.add("Nombre");
                columnas.add("Apellido");
                columnas.add("Estado");
                return columnas;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };


        ListView<String>  columnasLv = new ListView<String>("columnas", columnas){

            @Override
            protected void populateItem(final ListItem<String> components) {
                components.add(new Label("columna",new LoadableDetachableModel<String>() {
                    @Override
                    protected String load() {
                        return components.getModelObject();
                    }
                }));
            }
        };

        add(columnasLv);

            List<String[]> rows = new ArrayList<String[]>();

        for(int i = 0 ; i < 20 ; i++){
            rows.add(new String[]{ "" + i,"pepe " + i, "lopresto " + i});
        }

        ListView<String[]> lv = new ListView<String[]>("rows", rows) {
            @Override
            protected void populateItem(ListItem<String[]> item) {
                String[] row = item.getModelObject();

                item.add(new Label("col1", row[0]));
                item.add(new Label("col2", row[1]));
                item.add(new Label("col3", row[2]));
            }
        };
        lv.setOutputMarkupId(true);
        add(lv);

    }


}
