package gov.ifms.pvu.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEventSelectionGradeView {
	
	   @NativeQueryResultColumn(index = 0)
	    private Long id;

	    @NativeQueryResultColumn(index = 1)
	    private String trnNo;

	    @NativeQueryResultColumn(index = 2)
	    private String eventName;

	    @NativeQueryResultColumn(index = 3)
	    private Long employeeNo;

	    @NativeQueryResultColumn(index = 4)
	    private String employeeName;

	    @NativeQueryResultColumn(index = 5)
	    private String designationName;

	    @NativeQueryResultColumn(index = 6)
	    private String className;

	    @NativeQueryResultColumn(index = 7)
	    private String empType;

	    @NativeQueryResultColumn(index = 8)
	    private String panNo;

	    @NativeQueryResultColumn(index = 9)
	    private String officeName;

	    @NativeQueryResultColumn(index = 10)
	    private String statusName;

	    @NativeQueryResultColumn(index = 11)
	    private LocalDateTime retirementDate;

	    @JsonIgnore
	    @NativeQueryResultColumn(index = 12)
	    private Long count;

	    @NativeQueryResultColumn(index = 13)
	    private String eventCode;

	    @NativeQueryResultColumn(index = 14)
	    private Long isEditable;

	    @NativeQueryResultColumn(index = 15)
	    private String wfStatus;

	    @NativeQueryResultColumn(index = 16)
	    private Long statusId;
	    
	    @SuppressWarnings("unused")
		private Long deleteFlag;
	    
	    @NativeQueryResultColumn(index = 17)
	    private String createrDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTrnNo() {
			return trnNo;
		}

		public void setTrnNo(String trnNo) {
			this.trnNo = trnNo;
		}

		public String getEventName() {
			return eventName;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public Long getEmployeeNo() {
			return employeeNo;
		}

		public void setEmployeeNo(Long employeeNo) {
			this.employeeNo = employeeNo;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getDesignationName() {
			return designationName;
		}

		public void setDesignationName(String designationName) {
			this.designationName = designationName;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public String getEmpType() {
			return empType;
		}

		public void setEmpType(String empType) {
			this.empType = empType;
		}

		public String getPanNo() {
			return panNo;
		}

		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}

		public String getOfficeName() {
			return officeName;
		}

		public void setOfficeName(String officeName) {
			this.officeName = officeName;
		}

		public String getStatusName() {
			return statusName;
		}

		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}

		public LocalDateTime getRetirementDate() {
			return retirementDate;
		}

		public void setRetirementDate(LocalDateTime retirementDate) {
			this.retirementDate = retirementDate;
		}

		public Long getCount() {
			return count;
		}

		public void setCount(Long count) {
			this.count = count;
		}

		public String getEventCode() {
			return eventCode;
		}

		public void setEventCode(String eventCode) {
			this.eventCode = eventCode;
		}

		public Long getIsEditable() {
			return isEditable;
		}

		public void setIsEditable(Long isEditable) {
			this.isEditable = isEditable;
		}

		public String getWfStatus() {
			return wfStatus;
		}

		public void setWfStatus(String wfStatus) {
			this.wfStatus = wfStatus;
		}

		public Long getStatusId() {
			return statusId;
		}

		public void setStatusId(Long statusId) {
			this.statusId = statusId;
		}

		public Long getDeleteFlag() {
			deleteFlag = statusId;
			return deleteFlag;
		}

		/**
		 * @return the createrDate
		 */
		public String getCreaterDate() {
			return createrDate;
		}

		/**
		 * @param createrDate the createrDate to set
		 */
		public void setCreaterDate(String createrDate) {
			this.createrDate = createrDate;
		}	
		
		
}