package org.itzxs.entity;

import java.io.Serializable;

/**
 * Created by Itzxs on 2018/7/3.
 */
public class PageRespository implements Serializable{

    private static final long serialVersionUID = -5244288298702801619L;

    private Integer rowIndex;
    private Integer pageSize;

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
