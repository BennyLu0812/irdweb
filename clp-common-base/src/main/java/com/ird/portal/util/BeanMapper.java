package com.ird.portal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;

/**
 * 讲类转换为其他的类型的工具类.
 *
 * @author dowler
 * @since 19/12/2016 下午5:24
 */
public class BeanMapper {

    private Mapper mapper;

    public BeanMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void map(Object source, Object destination) {
        mapper.map(source, destination);
    }

    public <T> T map(Object source, Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }


    public <T> T map(Object source, Class<T> destinationClass, String mapId) {
        return mapper.map(source, destinationClass, mapId);
    }

    public void map(Object source, Object destination, String mapId) {
        mapper.map(source, destination, mapId);
    }

    public <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
    
    public <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass, String mapId) {
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, destinationClass, mapId);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public <T> T mapTo(Object sourceObject, Class<T> destinationClass) {
        T destinationObject = mapper.map(sourceObject, destinationClass);
        return destinationObject;
    }

    public Map<String, Object> map2HashMap(Object source) {
        Map<String, Object> destination = new HashMap<>();
        mapper.map(source, destination);
        return destination;
    }

}
