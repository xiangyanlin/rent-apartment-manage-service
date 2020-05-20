package com.xyl.rental.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/5/18 10:35
 */
@Data
public class HouseQuery implements Serializable {
    private static final long serialVersionUID = 118094736832429414L;

    private Integer id;
    /**
     * 房源标题
     */
    private String title;
    /**
     * 房东编号
     */
    private Integer ownerId;
    /**
     * 楼盘id
     */
    private Integer estateId;
    /**
     * 楼号（栋）
     */
    private String buildingNum;
    /**
     * 单元号
     */
    private String buildingUnit;
    /**
     * 门牌号
     */
    private String buildingFloorNum;
    /**
     * 房屋用处1住宅，2商住两用
     */
    private String used;
    /**
     * 房屋状态0待审核，1待租，2租出,3停用
     */
    private List<String> status;
    /**
     * 最小租金
     */
    private Integer minRent;
    /**
     * 最大租金
     */
    private Integer maxRent;
    /**
     * 租赁方式，1-整租，2-合租
     */
    private Integer rentMethod;
    /**
     * 支付方式，1-付一押一，2-付三押一，3-付六押一，4-年付押一，5-其它
     */
    private List<Integer> paymentMethod;
    /**
     * 户型，如：2室1厅1卫
     */
    private List<String> houseType;
    /**
     * 建筑面积
     */
    private String coveredArea;
    /**
     * 使用面积
     */
    private String useArea;
    /**
     * 楼层，如：8/26
     */
    private String floor;
    /**
     * 朝向：东、南、西、北
     */
    private List<String> orientation;
    /**
     * 装修，1-精装，2-简装，3-毛坯
     */
    private Integer decoration;
    /**
     * 配套设施， 如：1,2,3
     */
    private String facilities;
    /**
     * 图片，最多5张
     */
    private String pic;
    /**
     * 描述
     */
    private String houseDesc;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 看房时间，1-上午，2-中午，3-下午，4-晚上，5-全天
     */
    private List<Integer> time;
    /**
     * 物业费
     */
    private String propertyCost;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 关键字
     */
    private String KeyWord;
}
