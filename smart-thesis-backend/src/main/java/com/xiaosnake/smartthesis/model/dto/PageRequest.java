package com.xiaosnake.smartthesis.model.dto;

import com.xiaosnake.smartthesis.constant.CommonConstant;
import com.xiaosnake.smartthesis.exception.BusinessException;
import com.xiaosnake.smartthesis.exception.CodeBindMessageEnums;
import com.xiaosnake.smartthesis.utils.SqlUtils;
import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private int current = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序(默认升序)
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;

    public String getSortOrder() {
        if (!SqlUtils.validSortOrder(sortOrder)) {
            throw new BusinessException(CodeBindMessageEnums.PARAMS_ERROR, "排序顺序仅支持 ascend 或 descend");
        }
        return sortOrder;
    }

}
