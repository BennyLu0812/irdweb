package com.ird.portal.util;

import com.ird.portal.data.BaseDTO;
import com.ird.portal.datatable.Columns;
import com.ird.portal.datatable.Order;
import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Tim
 * @version 1.0
 * @date 27/10/2021 14:29
 */
public class OrderUtil {

    private OrderUtil() {}

    public static <T extends BaseDTO> T order(T baseDTO, String column, String dir) {

        Columns columns = new Columns();
        columns.setData(column);
        List<Columns> columnsList = CollectionUtils.isEmpty(baseDTO.getColumns())? new LinkedList<>(): baseDTO.getColumns();
        columnsList.add(columns);
        baseDTO.setColumns(columnsList);

        List<Order> orderList = CollectionUtils.isEmpty(baseDTO.getOrder())? new LinkedList<>(): baseDTO.getOrder();
        Order order = new Order();
        order.setColumn(columnsList.size() - 1);
        order.setDir(dir);
        orderList.add(order);
        baseDTO.setOrder(orderList);
        return baseDTO;
    }

}
