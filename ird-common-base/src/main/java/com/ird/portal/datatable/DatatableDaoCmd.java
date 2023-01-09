package com.ird.portal.datatable;

import com.ird.portal.dao.PageDaoCmd;
import com.ird.portal.util.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Title: data table Dao Cmd.<br/>
 * Description: <br/>
 * Date: 2017年9月5日 下午6:02:40<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class DatatableDaoCmd extends PageDaoCmd {

	private AbstractDatatableDTO datatableDTO;

    public AbstractDatatableDTO getDatatableDTO() {
		return datatableDTO;
	}

	public void setDatatableDTO(AbstractDatatableDTO datatableDTO) {
		this.datatableDTO = datatableDTO;
	}

	public DatatableDaoCmd(String queryKey, AbstractDatatableDTO dto) {
        super(queryKey, dtoToMap(dto), new DataTablePage(dto));
        setOrderString(getOrderString(dto));
        setDatatableDTO(dto);
    }

    public DatatableDaoCmd(String queryKey, Map<String, Object> params, DataTablePage page) {
        super(queryKey, params, page);
    }

    private static Map<String, Object> dtoToMap(AbstractDatatableDTO dto) {
        Map<String, Object> map = BeanUtil.transBeanToMap(dto);

        List<Columns> columns = dto.getColumns();
        if (columns != null && !columns.isEmpty()) {
            for (Columns cls : columns) {
                if (cls.isSerachable()) {
                    Search search = cls.getSearch();
                    if (search != null && StringUtils.isNotBlank(search.getValue())) {
                        map.put(cls.getData(), search.getValue());
                    } else {
                        map.put(cls.getData(), dto.getSearch().getValue());
                    }
                }
            }
        }
        return map;
    }

    private static String getOrderString(AbstractDatatableDTO dto) {
        if (dto.getOrder() != null && !dto.getOrder().isEmpty()) {
            List<String> orderList = new ArrayList<String>();
            List<Order> orders = dto.getOrder();
            for (Order order : orders) {
                if (order.getColumn() != null) {
                    orderList.add(dto.getColumns().get(order.getColumn()).getData() + " " + order.getDir());
                }
            }
            return StringUtils.join(orderList, ",");
        }
        return null;
    }
}
