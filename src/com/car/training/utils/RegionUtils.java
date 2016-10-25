package com.car.training.utils;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.service.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by I309994 on 10/25/2016.
 */
@Component
public class RegionUtils {
    @Autowired
    private transient EntityManager<Region> entityManager;


    public List<Region> getSubCities(long parentId) {
        entityManager.setEntityClass(Region.class);
        if(parentId > 0){
            return  (List<Region>) entityManager.get(parentId).getChildren();
        }else{
            DetachedCriteria dc = entityManager.detachedCriteria();
            dc.add(Restrictions.isNull("parent"));
            dc.addOrder(Order.asc("displayOrder"));
            dc.addOrder(Order.asc("name"));
            return entityManager.findListByCriteria(dc);

        }
    }

    public Region getRegionById(long id){
        entityManager.setEntityClass(Region.class);
        return entityManager.get(id);
    }

}
