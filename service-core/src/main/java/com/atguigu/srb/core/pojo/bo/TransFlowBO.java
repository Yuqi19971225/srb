package com.atguigu.srb.core.pojo.bo;

import com.atguigu.srb.core.enums.TransTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/9/24 21:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransFlowBO {

    private String agentBillNo;
    private String bindCode;
    private BigDecimal amount;
    private TransTypeEnum transTypeEnum;
    private String memo;
}