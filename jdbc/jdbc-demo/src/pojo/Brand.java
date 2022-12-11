package pojo;



import java.nio.charset.Charset;

/*
 * 品牌
 * alt+鼠标左键:整列编辑
 * ctrl+r:查找替换
 * 在实体类中，基本数据类型建议使用其对应包装类型
 * */
public class Brand {
    // id 主键
    private int id;
    // 品牌名称
    private String brandName;
    // 企业名称
    private String companyName;
    // 排序字段
    private int ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public java.lang.String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName=" + brandName +
                ", companyName=" + companyName +
                ", ordered=" + ordered +
                ", description=" + description +
                ", status=" + status +
                '}';
    }


}
