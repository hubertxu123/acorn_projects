package com.chinadrtv.model.oms;

import java.util.Date;

/**
 * Created with (TC).
 * User: 徐志凯
 * Date: 13-11-20
 * 橡果国际-系统集成部
 * Copyright (c) 2012-2013 ACORN, Inc. All rights reserved.
 */
public class ShipmentChangeHis {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_REF_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private Long shipmentRefId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String shipmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_MAIL_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeMailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_MAIL_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterMailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ENTITY_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeEntityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ENTITY_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterEntityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_WAREHOUSE_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeWarehouseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_WAREHOUSE_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterWarehouseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeAccountStatusId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterAccountStatusId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeAccountStatusRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterAccountStatusRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeLogisticsStatusId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterLogisticsStatusId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String beforeLogisticsStatusRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String afterLogisticsStatusRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.USER_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String userStamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.PROCESS_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private String processStamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.DATE_TIME_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    private Date dateTimeStamp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.ID
     *
     * @param id the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_REF_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_REF_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public Long getShipmentRefId() {
        return shipmentRefId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_REF_ID
     *
     * @param shipmentRefId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_REF_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setShipmentRefId(Long shipmentRefId) {
        this.shipmentRefId = shipmentRefId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getShipmentId() {
        return shipmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_ID
     *
     * @param shipmentId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.SHIPMENT_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId == null ? null : shipmentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_MAIL_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_MAIL_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeMailId() {
        return beforeMailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_MAIL_ID
     *
     * @param beforeMailId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_MAIL_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeMailId(String beforeMailId) {
        this.beforeMailId = beforeMailId == null ? null : beforeMailId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_MAIL_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_MAIL_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterMailId() {
        return afterMailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_MAIL_ID
     *
     * @param afterMailId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_MAIL_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterMailId(String afterMailId) {
        this.afterMailId = afterMailId == null ? null : afterMailId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ENTITY_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ENTITY_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeEntityId() {
        return beforeEntityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ENTITY_ID
     *
     * @param beforeEntityId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ENTITY_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeEntityId(String beforeEntityId) {
        this.beforeEntityId = beforeEntityId == null ? null : beforeEntityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ENTITY_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ENTITY_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterEntityId() {
        return afterEntityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ENTITY_ID
     *
     * @param afterEntityId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ENTITY_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterEntityId(String afterEntityId) {
        this.afterEntityId = afterEntityId == null ? null : afterEntityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_WAREHOUSE_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_WAREHOUSE_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeWarehouseId() {
        return beforeWarehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_WAREHOUSE_ID
     *
     * @param beforeWarehouseId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_WAREHOUSE_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeWarehouseId(String beforeWarehouseId) {
        this.beforeWarehouseId = beforeWarehouseId == null ? null : beforeWarehouseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_WAREHOUSE_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_WAREHOUSE_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterWarehouseId() {
        return afterWarehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_WAREHOUSE_ID
     *
     * @param afterWarehouseId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_WAREHOUSE_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterWarehouseId(String afterWarehouseId) {
        this.afterWarehouseId = afterWarehouseId == null ? null : afterWarehouseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeAccountStatusId() {
        return beforeAccountStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_ID
     *
     * @param beforeAccountStatusId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeAccountStatusId(String beforeAccountStatusId) {
        this.beforeAccountStatusId = beforeAccountStatusId == null ? null : beforeAccountStatusId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterAccountStatusId() {
        return afterAccountStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_ID
     *
     * @param afterAccountStatusId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterAccountStatusId(String afterAccountStatusId) {
        this.afterAccountStatusId = afterAccountStatusId == null ? null : afterAccountStatusId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_REMARK
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeAccountStatusRemark() {
        return beforeAccountStatusRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_REMARK
     *
     * @param beforeAccountStatusRemark the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_ACCOUNT_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeAccountStatusRemark(String beforeAccountStatusRemark) {
        this.beforeAccountStatusRemark = beforeAccountStatusRemark == null ? null : beforeAccountStatusRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_REMARK
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterAccountStatusRemark() {
        return afterAccountStatusRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_REMARK
     *
     * @param afterAccountStatusRemark the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_ACCOUNT_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterAccountStatusRemark(String afterAccountStatusRemark) {
        this.afterAccountStatusRemark = afterAccountStatusRemark == null ? null : afterAccountStatusRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeLogisticsStatusId() {
        return beforeLogisticsStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_ID
     *
     * @param beforeLogisticsStatusId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeLogisticsStatusId(String beforeLogisticsStatusId) {
        this.beforeLogisticsStatusId = beforeLogisticsStatusId == null ? null : beforeLogisticsStatusId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_ID
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterLogisticsStatusId() {
        return afterLogisticsStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_ID
     *
     * @param afterLogisticsStatusId the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_ID
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterLogisticsStatusId(String afterLogisticsStatusId) {
        this.afterLogisticsStatusId = afterLogisticsStatusId == null ? null : afterLogisticsStatusId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_REMARK
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getBeforeLogisticsStatusRemark() {
        return beforeLogisticsStatusRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_REMARK
     *
     * @param beforeLogisticsStatusRemark the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.BEFORE_LOGISTICS_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setBeforeLogisticsStatusRemark(String beforeLogisticsStatusRemark) {
        this.beforeLogisticsStatusRemark = beforeLogisticsStatusRemark == null ? null : beforeLogisticsStatusRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_REMARK
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getAfterLogisticsStatusRemark() {
        return afterLogisticsStatusRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_REMARK
     *
     * @param afterLogisticsStatusRemark the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.AFTER_LOGISTICS_STATUS_REMARK
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setAfterLogisticsStatusRemark(String afterLogisticsStatusRemark) {
        this.afterLogisticsStatusRemark = afterLogisticsStatusRemark == null ? null : afterLogisticsStatusRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.USER_STAMP
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.USER_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getUserStamp() {
        return userStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.USER_STAMP
     *
     * @param userStamp the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.USER_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp == null ? null : userStamp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.PROCESS_STAMP
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.PROCESS_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public String getProcessStamp() {
        return processStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.PROCESS_STAMP
     *
     * @param processStamp the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.PROCESS_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp == null ? null : processStamp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.DATE_TIME_STAMP
     *
     * @return the value of ACOAPP_OMS.SHIPMENT_CHANGE_HIS.DATE_TIME_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public Date getDateTimeStamp() {
        return dateTimeStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACOAPP_OMS.SHIPMENT_CHANGE_HIS.DATE_TIME_STAMP
     *
     * @param dateTimeStamp the value for ACOAPP_OMS.SHIPMENT_CHANGE_HIS.DATE_TIME_STAMP
     *
     * @mbggenerated Wed Nov 20 21:42:21 CST 2013
     */
    public void setDateTimeStamp(Date dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }
}