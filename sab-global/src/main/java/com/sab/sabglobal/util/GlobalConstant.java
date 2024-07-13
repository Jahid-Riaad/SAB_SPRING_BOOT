package com.sab.sabglobal.util;

import org.springframework.http.HttpStatus;

public final class GlobalConstant {
    private GlobalConstant() {
    }

    public static final String AUDIT_LOG_TYPE_DATABASE = "database";
    public static final String AUDIT_LOG_TYPE_JMS = "jms";
    public static final String AUDIT_LOG_TYPE_REST = "rest";
    public static final String INTERFACE_LOG_TYPE_DATABASE = "database";
    public static final String INTERFACE_LOG_TYPE_JMS = "jms";
    public static final String INTERFACE_LOG_TYPE_REST = "rest";
    public static final String SEPARATOR = "]";
    public static final String MESSAGE_SEPARATOR = "|";
    public static final String MESSAGE_DURATION_SEPARATOR = "=>";
    public static final String MANIFEST_BATCH = "MANIFEST HOUSEKEEP BATCH";

    public static final String[] whiteListedEndpoints = new String[]{"api-docs"};
    public static final String INTERNAL_ACCESS = "/internal";

    public static final String KEY_MAP_MESSAGE_TYPE = "messageType";
    public static final String KEY_MAP_PROCESSING_TIME = "processingTime";
    public static final String KEY_MAP_KEY = "keyIv";
    public static final String KEY_MAP_VALUE = "value";
    public static final String KEY_MAP_API_VERSION = "apiVersion";
    public static final String KEY_MAP_HEADER_ID = "headerId";
    public static final String KEY_MAP_TRACE_ID = "traceId";
    public static final String KEY_MAP_SPAN_ID = "spanId";
    public static final String KEY_MAP_MESSAGE = "message";
    public static final String KEY_MAP_COMMENTS = "comments";
    public static final String KEY_MAP_USER_AGENT = "userAgent";
    public static final String KEY_MAP_SERVLET_REQUEST = "servletRequest";
    public static final String KEY_MAP_AUTH_HEADER = "authHeader";
    public static final String KEY_MAP_REQUEST_ID = "requestId";
    public static final String KEY_MAP_REQUEST_BODY = "requestBody";
    public static final String KEY_MAP_REQUEST_TIME = "requestTime";
    public static final String KEY_MAP_AUTHORISATION = "Authorization";
    public static final String KEY_MAP_POD_NAME = "podName";
    public static final String KEY_MAP_CUSTOMER_INFO = "custInfo";
    public static final String KEY_MAP_SOURCE_ID = "sourceId";
    public static final String KEY_MAP_ENCRYPTED_KEY = "encryptedKey";
    public static final String KEY_MAP_DECRYPTED_KEY = "decryptedKey";
    public static final String KEY_MAP_ENCR_SIGNATURE_DATA = "encrSignatureData";
    public static final String KEY_MAP_USER_ID = "userID";
    public static final String KEY_MAP_TRANSACTION_BRANCH = "transactionBranch";
    public static final String KEY_MAP_USER_BANK = "userBank";
    public static final String KEY_MAP_CHANNEL_ID = "channelID";
    public static final String KEY_MAP_SVC_CODE = "svcCode";
    public static final String KEY_MAP_TRN_REF_NUM = "trnRefNum";
    public static final String KEY_MAP_SVC_RQ_ID = "svcRqId";
    public static final String KEY_MAP_MSG_TYP = "msgTyp";
    public static final String KEY_MAP_ORG_REF_TXN_NO = "orgRefTxnNo";
    public static final String KEY_MAP_TXN_DATE = "txnDate";
    public static final String KEY_MAP_CHANNEL_DIRECT = "channelDirect";
    public static final String KEY_MAP_CODE_ORG_BRN = "codOrgBrn";
    public static final String KEY_MAP_TRANSACTION_ID = "transactionID";
    public static final String KEY_MAP_CLIENT_CORRELATION_ID = "clientcorrelationid";
    public static final String KEY_MAP_LANGUAGE = "language";
    public static final String KEY_MAP_RANDOM_KEY = "randomKey";
    public static final String KEY_MAP_TRANSACTION_CODE = "transactionCode";
    public static final String KEY_MAP_MODULE_ID = "moduleId";

    public static final String KEY_MAP_TOKEN = "token";
    public static final String KEY_MAP_REF_NO = "refNo";
    public static final String KEY_MAP_DECRYPTED_REQUEST = "decryptedRequest";
    public static final String KEY_MAP_DECRYPTED_RESPONSE = "decryptedResponse";
    public static final String KEY_MAP_HTTP_STATUS = "httpStatus";
    public static final String KEY_MAP_TXN_KEY = "TxnKey";
    public static final String KEY_MAP_USER_AUTHORIZATION_INFO = "userAuthorizationInfo";
    public static final String KEY_MAP_REF_TXN_NO = "refTxnNo";
    public static final String KEY_MAP_ALLOWED_CHANNEL = "allowedChannel";
    public static final String KEY_MAP_ALLOWED_CHANNEL_IS_OMNI = "allowedChannelIsOmni";


    public static final String SUCCESS_CODE = "0000000";
    public static final String SUCCESS_MESSAGE = "Success";
    public static final String NO_RECORD_FOUND_CODE = "2792";
    public static final String NO_RECORD_FOUND_MESSAGE = "No Record Found.";
    // Warning
    public static final String MANDATORY_FIELD_WARNING_CODE = "ERR1001";
    public static final String MANDATORY_FIELD_WARNING_MESSAGE = "%s is Mandatory";
    public static final String MANDATORY_FIELD_WARNING_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String ERROR_TYPE_BAD_REQUEST = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String ERROR_CODE_BAD_REQUEST = "ERR4000";
    public static final String ERROR_TYPE_FORBIDDEN = HttpStatus.FORBIDDEN.getReasonPhrase();


    public static final String DUPLICATE_DATA_ERROR_CODE = "ERR1003";
    public static final String DUPLICATE_DATA_ERROR_MESSAGE = "Duplicate Data";
    public static final String DUPLICATE_DATA_ERROR_TYPE = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    public static final String CONFIG_NOT_FOUND_ERROR_CODE = "ERR1004";
    public static final String CONFIG_NOT_FOUND_ERROR_MESSAGE = "Not Found in Config Master";
    public static final String CONFIG_NOT_FOUND_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String CATEGORY_NOT_FOUND_ERROR_CODE = "ERR1005";
    public static final String CATEGORY_NOT_FOUND_ERROR_MESSAGE = "Category Not Found";
    public static final String CATEGORY_NOT_FOUND_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String NOT_FOUND_ERROR_CODE = "ERR1006";
    public static final String NOT_FOUND_ERROR_MESSAGE = "The requested resource was not found.";
    public static final String NOT_FOUND_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String ENCRYPT_ERROR_CODE = "ERR2112";
    public static final String ENCRYPT_ERROR_MESSAGE = "Encrypt is Failed";
    public static final String ENCRYPT_ERROR_TYPE = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    // Failed
    public static final String AES_ENCRYPTION_FAILED_MESSAGE = "AES encryption failed.";
    public static final String AES_ENCRYPTION_FAILED_CODE = "ERR5100";

    public static final String AES_DECRYPTION_FAILED_MESSAGE = "AES decryption failed.";
    public static final String AES_DECRYPTION_FAILED_CODE = "ERR5101";

    public static final String SOMETHING_WRONG_ERROR_CODE = "ERR50001";
    public static final String SOMETHING_WRONG_ERROR_MESSAGE = "Something went wrong, please try again later";
    public static final String SOMETHING_WRONG_ERROR_TYPE = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();


    public static final String FORMAT_ERROR_WARNING_CODE = "ERR40001";
    public static final String FORMAT_ERROR_WARNING_MESSAGE = "Invalid Field Format: %s";
    public static final String FORMAT_ERROR_WARNING_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String INVALID_FIELD_MANDATORY_ERROR_CODE = "ERR40002";
    public static final String INVALID_FIELD_MANDATORY_ERROR_MESSAGE = "Invalid Mandatory Field: {%s}, {%s}"; // fieldName, message
    public static final String INVALID_FIELD_MANDATORY_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String INPUT_ERROR_WARNING_CODE = "ERR40003";
    public static final String INPUT_ERROR_WARNING_MESSAGE = "Expected Number. ";
    public static final String INPUT_ERROR_WARNING_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String FAILED_TO_FETCH_CASATYPE_CODE = "ERR40004";
    public static final String FAILED_TO_FETCH_CASATYPE_MESSAGE = "Cannot fetch CASA type";
    public static final String FAILED_TO_FETCH_CASATYPE_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String TOKEN_NOT_FOUND_ERROR_CODE = "ERR40101";
    public static final String TOKEN_NOT_FOUND_ERROR_MESSAGE = "Invalid Token";
    public static final String TOKEN_NOT_FOUND_ERROR_TYPE = HttpStatus.UNAUTHORIZED.getReasonPhrase();

    public static final String ACCOUNT_TEMPLATE_NOT_FOUND_ERROR_CODE = "2778";
    public static final String ACCOUNT_TEMPLATE_NOT_FOUND_ERROR_MESSAGE = "Account template not matched ";
    public static final String ACCOUNT_TEMPLATE_NOT_FOUND_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String MID_ECCS_INVALID_MODULE_ERROR_CODE = "5749";
    public static final String MID_ECCS_INVALID_MODULE_ERROR_MESSAGE = "Invalid Account Type";
    public static final String MID_ECCS_INVALID_MODULE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String INVALID_PRODUCT_CODE_ERROR_CODE = "6051";
    public static final String INVALID_PRODUCT_CODE_ERROR_MESSAGE = "Invalid Product Code";
    public static final String INVALID_PRODUCT_CODE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String ACCOUNT_NOT_FOUND_ERROR_CODE = "2778";
    public static final String ACCOUNT_NOT_FOUND_ERROR_MESSAGE = "Account not found.";
    public static final String ACCOUNT_NOT_FOUND_ERROR_TYPE = HttpStatus.NOT_FOUND.getReasonPhrase();
    public static final String MID_ECH_ACCT_CLOSED_ERROR_CODE = "2937";
    public static final String MID_ECH_ACCT_CLOSED_ERROR_MESSAGE = "Account closed.";
    public static final String MID_ECH_ACCT_CLOSED_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String MID_ETD_ACCT_BLOCKED_ERROR_CODE = "5427";
    public static final String MID_ETD_ACCT_BLOCKED_ERROR_MESSAGE = "The account is blocked";
    public static final String MID_ETD_ACCT_BLOCKED_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String BANK_NOT_FOUND_ERROR_CODE = "5788";
    public static final String BANK_NOT_FOUND_ERROR_MESSAGE = "Bank Record not found.";
    public static final String BANK_NOT_FOUND_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String INVALID_CHANNEL_CODE_ERROR_CODE = "GEF_BDI_005";
    public static final String INVALID_CHANNEL_CODE_ERROR_MESSAGE = "Invalid Channel code.";
    public static final String INVALID_CHANNEL_CODE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();


    public static final String MID_ECTL_INVALID_COD_MODULE_ERROR_CODE = "6031";
    public static final String MID_ECTL_INVALID_COD_MODULE_ERROR_MESSAGE = "Invalid Module Code";

    public static final String MID_REC_NOT_FOUND = "5586";
    public static final String MID_REC_NOT_FOUND_ERROR_MESSAGE = "CASA Statement History";
    public static final String MID_ECTL_INVALID_COD_MODULE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String EMPTY_CIF_ID = "3403";

    public static final String CIF_ID_NOT_FOUND = "3431";

    public static final String CIF_ID_NUMERICAL_VALIDATION = "9999";

    public static final String CUST_INQUIRY_NOT_FOUND_ERROR_MESSAGE = "Customer Inquiry History";
    public static final String CUST_INQUIRY_INVALID_COD_MODULE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String MID_ETD_INV_DATE_ERROR_CODE = "5254";
    public static final String MID_ETD_INV_DATE_ERROR_MESSAGE = "{%s} Invalid date";
    public static final String MID_ETD_INV_DATE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String MID_ECH_DATE_ERROR_CODE = "2950";
    public static final String MID_ECH_DATE_ERROR_MESSAGE = "Start date is greater than End date.";
    public static final String MID_ECH_DATE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String MID_BLANK_FIELD = "2458";

    public static final String MID_ETD_ACCT_NOT_FOUND = "5196";

    public static final int ZERO = 0;

    public static final String ETD_NO_DEPOSITS_FOR_THIS_ACCOUNT = "7274";

    public static final String MID_EOL_TBS_TD_ACCT_CLOSED = "2320";

    public static final String MID_EBA_NO_REC_FOUND = "2792";

    public static final String ACCOUNT_ID_REQUIRED_ERROR_CODE = "0000040";
    public static final String ACCOUNT_ID_REQUIRED_ERROR_MESSAGE = "Account ID input is Required";
    public static final String ACCOUNT_ID_REQUIRED_ERROR_TYPE = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    public static final String MID_ECH_NO_TXN = "3140";
    public static final String MID_ECH_NO_TXN_MESSAGE = "No Transaction Found";

    public static final String MID_INV_INPUT = "3573";
    public static final String CODE_NOT_FOUND_ERROR_TYPE = HttpStatus.NOT_FOUND.getReasonPhrase();
    public static final String MID_INV_INPUT_MESSAGE = "Invalid input Account id ";
    public static final String MID_INV_FLGSALDRAWDOWN_MESSAGE = "Invalid input flgSalDrawdown ";

    public static final String MID_INV_PCTSALDRAWDOWN_MESSAGE = "Invalid input pctSalDrawdown ";
    public static final String MID_FIELD_PCTSALDRAWDOWN_MESSAGE = "SORRY! Drawdown percentage of Salary IS REQUIRED!";
    public static final String MID_INV_CODECTPARTYID_MESSAGE = "Invalid input codeCtPartid ";
    public static final String MID_INV_CODE_ARREAR_MESSAGE = "Invalid  codeArrear ";
    public static final String MID_INV_CODE_EXECUTION_TYPE_MESSAGE = "Invalid  executionType ";
    public static final String MID_INV_CODE_COMPOUNDINGFREQUENCYTYPE_MESSAGE = "Invalid  CompoundingFrequencyType";
    public static final String MID_INV_CODE_PAYOUNTFREQUENCY_MESSAGE = "invalid PayoutFrequency";
    public static final String MID_INV_CODE_SWEEPOUTLEVEL_MESSAGE = "Invalid  sweepOutLevel ";

    public static final String MID_INV_CODE_SWEEPOUTMODE_MESSAGE = "Invalid  sweepOutMode ";
    public static final String MID_INV_REPAYMENT_MODETYPE_MESSAGE = "Invalid  Repaymode Type";
    public static final String REPAYMENT_MODETYPE_NOT_FOUND_ERROR_TYPE = HttpStatus.NOT_FOUND.getReasonPhrase();
    public static final String CODE_ARREAR_FOUND_NOT_ERROR_TYPE = HttpStatus.NOT_FOUND.getReasonPhrase();

    public static final String FOUND_NOT_ERROR_TYPE = HttpStatus.NOT_FOUND.getReasonPhrase();
    public static final String MANDATORY_FIELD_BENEFICARYACCOUNTID_MESSAGE = "Beneficiary AccountId is Mandatory";
    public static final String MANDATORY_FIELD_NARRATIVE_MESSAGE = "Narrative is Mandatory";

    public static final String MANDATORY_FIELD_FCBRNCODE_MESSAGE = "FCBrnCode is Mandatory";

    public static final String MANDATORY_FIELD_BENEFICIARYNAME_MESSAGE = "Beneficiary Name is Mandatory";
    public static final String MANDATORY_FIELD_ROUTINGNUMBER_MESSAGE =  "Routing Number is Mandatory";
    public static final String MANDATORY_FIELD_PRODUCTCODE_MESSAGE = "Product Code is Mandatory";

    public static final String MANDATORY_FIELD_ACCOUNTVARIANCE_MESSAGE = "Account Variance is Mandatory";
    public static final String MANDATORY_FIELD_COMPOUNDINGFREQUENCY_MESSAGE = "Compounding Frequency is Mandatory";
    public static final String MANDATORY_FIELD_PAYOUTFREQUENCY_MESSAGE = "Payout Frequency is Mandatory";

    public static final String MANDATORY_FIELD_BASEAMOUNTFORRATE_MESSAGE = "BaseAmountForRate is Mandatory";
    public static final String MANDATORY_FIELD_TDTERMMONTH_MESSAGE = "TdTermMonth is Mandatory";
    public static final String MID_INV_SWEEPINPROVIDER_MESSAGE = "Invalid input sweepInProvider";
    public static final String MANDATORY_FIELD_TDTERMDAY_MESSAGE = "TdTermDay is Mandatory";
    public static final String MANDATORY_FIELD_SWEEPINPROVIDER_MESSAGE = "SweepInProvider is Mandatory";
    
    public static final String MID_ECI_INV_CUST_ID = "Invalid Customer Id";
    public static final String MID_ECI_FNCALL_FAIL = "Called Function Has Had A Fatal Error";
    public static final String MID_MSG_CUST_ID_NUMERIC = "CustomerId Has To Be Numeric";


}
