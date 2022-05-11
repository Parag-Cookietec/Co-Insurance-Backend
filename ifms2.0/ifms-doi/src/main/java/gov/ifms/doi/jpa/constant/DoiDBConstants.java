package gov.ifms.doi.jpa.constant;

import gov.ifms.gst.util.GstDBConstants;

import java.util.LinkedHashMap;
import java.util.Map;

public class DoiDBConstants {

    /**
     * The Constant IS_SEARCH.
     */
    private static final String IS_SEARCH = "isSearch";

    /**
     * The Constant IN_IS_SEARCH.
     */
    public static final String IN_IS_SEARCH = "IN_IS_SEARCH";

    /**
     * The Constant POU_ID.
     */
    private static final String POU_ID = "pouId";

    /**
     * The Constant MENUID.
     */
    private static final String MENUID = "menuId";

    /**
     * The Constant IN_POU_ID.
     */
    private static final String IN_POU_ID = "IN_POU_ID";

    /**
     * The Constant IN_MENU_ID.
     */
    private static final String IN_MENU_ID = "IN_MENU_ID";

    /**
     * The Constant IN_POLICY_TYPE.
     */
    private static final String IN_POLICY_TYPE = "IN_POLICY_TYPE";

    /**
     * The Constant POLICYTYPE.
     */
    private static final String POLICYTYPE = "policyType";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_LEADER_NAME = "IN_LEADER_NAME";

    /**
     * The Constant MENUID.
     */
    private static final String LEADERNAME = "leaderName";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_INSURED_NAME = "IN_INSURED_NAME";

    /**
     * The Constant MENUID.
     */
    private static final String INSUREDNAME = "insuredName";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_POLICY_NO = "IN_POLICY_NO";

    /**
     * The Constant MENUID.
     */
    private static final String POLICYNO = "policyNo";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_RISK_TYPE = "IN_RISK_TYPE";

    /**
     * The Constant MENUID.
     */
    private static final String RISKTYPE = "riskType";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_PREV_DAY = "IN_PREV_DAY";

    /**
     * The Constant MENUID.
     */
    private static final String PREVDAY = "prevDay";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_NEXT_DAY = "IN_NEXT_DAY";

    /**
     * The Constant MENUID.
     */
    private static final String NEXTDAY = "nextDay";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_CLAIM_ID = "IN_CLAIM_ID";

    /**
     * The Constant MENUID.
     */
    private static final String CLAIMID = "claimId";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_DISTRICT = "IN_DISTRICT";

    /**
     * The Constant MENUID.
     */
    private static final String DISTRICT = "district";


    /**
     * The Constant IN_LEADER_NAME.
     */
        private static final String IN_SCHEME = "IN_SCHEME";

    /**
     * The Constant MENUID.
     */
    private static final String SCHEME = "scheme";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_MONTH = "IN_MONTH";

    /**
     * The Constant MENUID.
     */
    private static final String MONTH = "month";


    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_YEAR = "IN_YEAR";

    /**
     * The Constant MENUID.
     */
    private static final String YEAR = "year";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_FROM_DATE = "IN_FROM_DATE";

    /**
     * The Constant MENUID.
     */
    private static final String FROMDATE = "fromDate";

    /**
     * The Constant IN_LEADER_NAME.
     */
    private static final String IN_END_DATE = "IN_END_DATE";

    /**
     * The Constant MENUID.
     */
    private static final String ENDDATE = "endDate";

    /**
     * The Constant PAO_SCHEMA.
     */
    public static final String DOI_SCHEMA = "DOI";

    /**
     * The Constant SP_CHALLAN_ACCOUNTING_LISTING.
     */
    public static final String SP_TDOI_COINS_POLICY_HDR_LISTING = "SP_TDOI_COINS_POLICY_HDR_LISTING";

    /**
     * The Constant SP_CHALLAN_ACCOUNTING_LISTING.
     */
    public static final String SP_TDOI_COINS_PREMIUM_REFUND_LISTING = "SP_TDOI_COINS_PREMIUM_REFUND_LISTING";

    /**
     * The Constant SP_CHALLAN_ACCOUNTING_LISTING.
     */
    public static final String SP_TDOI_COINS_CLAIM_HDR_LISTING = "SP_TDOI_COINS_CLAIM_HDR_LISTING";


    private static Map<String, String> policyEntryListing = new LinkedHashMap<>(10);

    public static Map<String, String> getPolicyEntryListing() {
        return policyEntryListing;
    }

    private static Map<String, String> premiumRefundEntryListing = new LinkedHashMap<>(10);

    public static Map<String, String> getPremiumRefundEntryListing() {
        return premiumRefundEntryListing;
    }

    private static Map<String, String> claimListing = new LinkedHashMap<>(10);

    public static Map<String, String> getClaimListing() {
        return claimListing;
    }

    static {
        policyEntryListing.put(DoiDBConstants.IS_SEARCH, DoiDBConstants.IN_IS_SEARCH);
		policyEntryListing.put(DoiDBConstants.POU_ID,DoiDBConstants.IN_POU_ID);
		policyEntryListing.put(DoiDBConstants.MENUID,DoiDBConstants.IN_MENU_ID);
		policyEntryListing.put(DoiDBConstants.POLICYTYPE,DoiDBConstants.IN_POLICY_TYPE);
		policyEntryListing.put(DoiDBConstants.LEADERNAME,DoiDBConstants.IN_LEADER_NAME);
		policyEntryListing.put(DoiDBConstants.INSUREDNAME,DoiDBConstants.IN_INSURED_NAME);
		policyEntryListing.put(DoiDBConstants.POLICYNO,DoiDBConstants.IN_POLICY_NO);
		policyEntryListing.put(DoiDBConstants.RISKTYPE,DoiDBConstants.IN_RISK_TYPE);
		policyEntryListing.put(DoiDBConstants.PREVDAY,DoiDBConstants.IN_PREV_DAY);
        policyEntryListing.put(DoiDBConstants.NEXTDAY,DoiDBConstants.IN_NEXT_DAY);


        premiumRefundEntryListing.put(DoiDBConstants.IS_SEARCH, DoiDBConstants.IN_IS_SEARCH);
        premiumRefundEntryListing.put(DoiDBConstants.POU_ID,DoiDBConstants.IN_POU_ID);
        premiumRefundEntryListing.put(DoiDBConstants.MENUID,DoiDBConstants.IN_MENU_ID);
        premiumRefundEntryListing.put(DoiDBConstants.LEADERNAME,DoiDBConstants.IN_LEADER_NAME);
        premiumRefundEntryListing.put(DoiDBConstants.INSUREDNAME,DoiDBConstants.IN_INSURED_NAME);
        premiumRefundEntryListing.put(DoiDBConstants.POLICYNO,DoiDBConstants.IN_POLICY_NO);
        premiumRefundEntryListing.put(DoiDBConstants.PREVDAY,DoiDBConstants.IN_PREV_DAY);
        premiumRefundEntryListing.put(DoiDBConstants.NEXTDAY,DoiDBConstants.IN_NEXT_DAY);
        premiumRefundEntryListing.put(DoiDBConstants.CLAIMID,DoiDBConstants.IN_CLAIM_ID);


        claimListing.put(DoiDBConstants.IS_SEARCH, DoiDBConstants.IN_IS_SEARCH);
        claimListing.put(DoiDBConstants.POU_ID,DoiDBConstants.IN_POU_ID);
        claimListing.put(DoiDBConstants.MENUID,DoiDBConstants.IN_MENU_ID);
        claimListing.put(DoiDBConstants.DISTRICT, DoiDBConstants.IN_DISTRICT);
        claimListing.put(DoiDBConstants.SCHEME,DoiDBConstants.IN_SCHEME);
        claimListing.put(DoiDBConstants.MONTH,DoiDBConstants.IN_MONTH);
        claimListing.put(DoiDBConstants.YEAR, DoiDBConstants.IN_YEAR);
        claimListing.put(DoiDBConstants.FROMDATE,DoiDBConstants.IN_FROM_DATE);
        claimListing.put(DoiDBConstants.ENDDATE,DoiDBConstants.IN_END_DATE);
    }
}
