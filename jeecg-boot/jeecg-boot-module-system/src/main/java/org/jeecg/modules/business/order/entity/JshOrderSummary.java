package org.jeecg.modules.business.order.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: jsh_order_summary
 * @Author: jeecg-boot
 * @Date: 2022-02-04
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JshOrderSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private Date time;

    /**
     * 客户
     */
    @Excel(name = "客户", width = 15, dictTable = "jsh_customer", dicText = "name", dicCode = "id")
    @Dict(dictTable = "jsh_customer", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "客户id")
    private Long customerId;

    /**
     * 总订单数
     */
    @Excel(name = "总订单数", width = 15)
    @ApiModelProperty(value = "总订单数")
    private Long totalNum;

    /**
     * 总面积
     */
    @Excel(name = "总面积(m²)", width = 15)
    @ApiModelProperty(value = "总面积(mm²)")
    private Long totalArea;

    /**
     * 订单总额
     */
    @Excel(name = "订单总额(元)", width = 15)
    @ApiModelProperty(value = "订单总额(分)")
    private Long totalPrice;

    /**
     * 租户id
     */
    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    /**
     * 删除状态（0，正常，1已删除）
     */
    @TableLogic
    private Integer delFlag;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public JshOrderSummary(Date time) {
        this.time = time;
        this.customerId = 0L;
        this.tenantId = 0L;
        this.totalNum = 0L;
        this.totalArea = 0L;
        this.totalPrice = 0L;
    }

    public JshOrderSummary(Long tenantId, Long customerId, Long totalNum, Long totalArea, Long totalPrice) {
        this.tenantId = tenantId;
        this.customerId = customerId;
        this.totalNum = totalNum;
        this.totalArea = totalArea;
        this.totalPrice = totalPrice;
    }

    public JshOrderSummary(JshOrderSummary jshOrderSummary, Date time) {
        jshOrderSummary.setTime(time);
        if (jshOrderSummary.getCustomerId() == null) jshOrderSummary.setCustomerId(0L);
    }
}