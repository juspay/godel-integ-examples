package in.juspay.godel.integ.examples.util;

/**
 * Created by stpl on 17/3/15.
 */
public class Constants {
    public static final String URL = "https://www.billdesk.com/pgidsk/wap/vodafonetup/vodafonechordiantconfirm.jsp";
    public static final String POST_DATA = "Pre_bonuscards1$hdnAccessfee=1.00&" +
            "Pre_bonuscards1$hdnBenefit=Talktime of Rs.7.9&" +
            "Pre_bonuscards1$hdnChannelId=RECHARGE&" +
            "Pre_bonuscards1$hdnCircleId=&" +
            "Pre_bonuscards1$hdnMRP=10.00&" +
            "Pre_bonuscards1$hdnMobileNumber=9620917775&" +
            "Pre_bonuscards1$hdnServiceTax=12.36&" +
            "Pre_bonuscards1$hdnTalktime=7.90&" +
            "Pre_bonuscards1$hdnaction=confirm_etopup&" +
            "Pre_bonuscards1$hdnairtime=0.00&" +
            "Pre_bonuscards1$hdnmsg=9620917775|10.00|0.00|1.00|12.36|Talktime of Rs.7.9|kar|RECHARGE|7.90|20140505170308|2144186221&" +
            "Pre_bonuscards1$txtDenom=10&" +
            "Pre_bonuscards1$txtmobileNo=9620917775&" +
            "__EVENTARGUMENT=&" +
            "__EVENTTARGET=&" +
            "__EVENTVALIDATION=/wEWCwLtyvX4DgLB39rQDgLIkufkCALl1YjvDALGn/GnAwKc6s+nCALI1fSCCQLI1bjxDgLI1czMBwLJgK/wCgKuwITEBoKlRHFTXgI5XV82o1qSAOneVyq1";

    public static final String MERCHANT_ID = "godel_integ_demo";
    public static final String CLIENT_ID = "godel_integ_demo_fl";
    public static final String DISPLAY_NOTE = "This text would be shown on top";
    public static final String REMARKS = "This text would be filled on bank page";
    public static final int AMOUNT = 10;
    public static final String CUSTOMER_PHONE_NUMBER = "9829880095";

    public static String getTransactionId() {
        Double random = Math.random()*100000;
        return String.valueOf(random);
    }
}
