package com.ird.portal.common.sys.data;

/**
 * 
 * 檢測結果統計.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2021 09:58:05<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class TableTotalDTO {
   //类型
   private String type;
   //总数
   private Integer total;
   //合格数
   private Integer pass;
    //不合格
   private Integer noPass;
    //合格率
   private Double passRate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getNoPass() {
        return noPass;
    }

    public void setNoPass(Integer noPass) {
        this.noPass = noPass;
    }

    public Double getPassRate() {
        return passRate;
    }

    public void setPassRate(Double passRate) {
        this.passRate = passRate;
    }

    @Override
    public String toString() {
        return "TableTotalDTO{" +
                "type='" + type + '\'' +
                ", total=" + total +
                ", pass=" + pass +
                ", noPass=" + noPass +
                ", passRate=" + passRate +
                '}';
    }
}
