package gov.ifms.edp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The Class EDPMsBankBranchDto.
 */
public class EDPMsBankBranchDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bank branch id. */
	@NotNull
	private Long bankBranchId;

	/** The branch name. */
	@NotNull
	private String branchName;

	/** The branch name guj. */
	private String branchNameGuj;

	/** The branch desc. */
	private String branchDesc;

	/** The branch desc guj. */
	private String branchDescGuj;

	/** The branch code. */
	private String branchCode;

	/** The branch code guj. */
	private String branchCodeGuj;

	/** The branch type id. */
	private Long branchTypeId;

	/** The parent branch id. */
	private Long parentBranchId;

	/** The bank id. */
	private Long bankId;

	/** The district id. */
	private Long districtId;

	/** The taluka id. */
	private Long talukaId;

	/** The ifsc code. */
	private String ifscCode;

	/** The micr code. */
	private String micrCode;

	/** The branch address. */
	private String branchAddress;

	/** The branch email. */
	private String branchEmail;

	/** The branch phone. */
	private String branchPhone;

	/** The is merged branch. */
	private Integer isMergedBranch;

	/** The is enabled branch. */
	private Integer isEnabledBranch;

	/**
	 * Instantiates a new EDP ms bank branch dto.
	 */
	public EDPMsBankBranchDto() {
		super();
	}

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch name guj.
	 *
	 * @return the branchNameGuj
	 */
	public String getBranchNameGuj() {
		return branchNameGuj;
	}

	/**
	 * Sets the branch name guj.
	 *
	 * @param branchNameGuj the branchNameGuj to set
	 */
	public void setBranchNameGuj(String branchNameGuj) {
		this.branchNameGuj = branchNameGuj;
	}

	/**
	 * Gets the branch desc.
	 *
	 * @return the branchDesc
	 */
	public String getBranchDesc() {
		return branchDesc;
	}

	/**
	 * Sets the branch desc.
	 *
	 * @param branchDesc the branchDesc to set
	 */
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	/**
	 * Gets the branch desc guj.
	 *
	 * @return the branchDescGuj
	 */
	public String getBranchDescGuj() {
		return branchDescGuj;
	}

	/**
	 * Sets the branch desc guj.
	 *
	 * @param branchDescGuj the branchDescGuj to set
	 */
	public void setBranchDescGuj(String branchDescGuj) {
		this.branchDescGuj = branchDescGuj;
	}

	/**
	 * Gets the branch code.
	 *
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Sets the branch code.
	 *
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Gets the branch code guj.
	 *
	 * @return the branchCodeGuj
	 */
	public String getBranchCodeGuj() {
		return branchCodeGuj;
	}

	/**
	 * Sets the branch code guj.
	 *
	 * @param branchCodeGuj the branchCodeGuj to set
	 */
	public void setBranchCodeGuj(String branchCodeGuj) {
		this.branchCodeGuj = branchCodeGuj;
	}

	/**
	 * Gets the branch type id.
	 *
	 * @return the branchTypeId
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * Gets the parent branch id.
	 *
	 * @return the parentBranchId
	 */
	public Long getParentBranchId() {
		return parentBranchId;
	}

	/**
	 * Sets the parent branch id.
	 *
	 * @param parentBranchId the parentBranchId to set
	 */
	public void setParentBranchId(Long parentBranchId) {
		this.parentBranchId = parentBranchId;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the taluka id.
	 *
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * Gets the micr code.
	 *
	 * @return the micrCode
	 */
	public String getMicrCode() {
		return micrCode;
	}

	/**
	 * Sets the micr code.
	 *
	 * @param micrCode the micrCode to set
	 */
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	/**
	 * Gets the branch address.
	 *
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * Sets the branch address.
	 *
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/**
	 * Gets the branch email.
	 *
	 * @return the branchEmail
	 */
	public String getBranchEmail() {
		return branchEmail;
	}

	/**
	 * Sets the branch email.
	 *
	 * @param branchEmail the branchEmail to set
	 */
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	/**
	 * Gets the branch phone.
	 *
	 * @return the branchPhone
	 */
	public String getBranchPhone() {
		return branchPhone;
	}

	/**
	 * Sets the branch phone.
	 *
	 * @param branchPhone the branchPhone to set
	 */
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	/**
	 * Gets the checks if is merged branch.
	 *
	 * @return the isMergedBranch
	 */
	public Integer getIsMergedBranch() {
		return isMergedBranch;
	}

	/**
	 * Sets the checks if is merged branch.
	 *
	 * @param isMergedBranch the isMergedBranch to set
	 */
	public void setIsMergedBranch(Integer isMergedBranch) {
		this.isMergedBranch = isMergedBranch;
	}

	/**
	 * Gets the checks if is enabled branch.
	 *
	 * @return the isEnabledBranch
	 */
	public Integer getIsEnabledBranch() {
		return isEnabledBranch;
	}

	/**
	 * Sets the checks if is enabled branch.
	 *
	 * @param isEnabledBranch the isEnabledBranch to set
	 */
	public void setIsEnabledBranch(Integer isEnabledBranch) {
		this.isEnabledBranch = isEnabledBranch;
	}

}
