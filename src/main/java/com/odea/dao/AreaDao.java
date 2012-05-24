package com.odea.dao;


import com.odea.model.Area;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaDao {
    private static List<Area> AREAS = new ArrayList<Area>();

    public AreaDao() {
        for(int i=0; i<10 ; i++){
            AREAS.add(new Area(i,"alias" + i,"nombre" + i, "pais" + i));
        }
    }
    
    public void saveArea(Area area){
        AREAS.add(area);
    }
    
    public Area getAreaById(long idArea){
        for(Area area : AREAS){
            if(area.getId() == idArea){
                return area;
            }
        }
        return null;
    }
    
    public List<Area> getAreas(int index,int offset){
        return AREAS.subList(index,index + offset);        
    }

    private static final class AreaMapper implements RowMapper<Area> {
        public Area mapRow(ResultSet resultSet, int i) throws SQLException {
            Area area = new Area();

            area.setId(resultSet.getLong("id_area"));
            area.setAlias(resultSet.getString("alias"));
            area.setNombre(resultSet.getString("nombre"));
            area.setPais(resultSet.getString("pais"));

            return area;
        }
    }
}
