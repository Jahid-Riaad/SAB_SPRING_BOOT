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

    public static final String TOKEN_NOT_FOUND_ERROR_CODE = "ERR40101";
    public static final String TOKEN_NOT_FOUND_ERROR_MESSAGE = "Invalid Token";
    public static final String TOKEN_NOT_FOUND_ERROR_TYPE = HttpStatus.UNAUTHORIZED.getReasonPhrase();
    public static final String UNIQUE_CONSTRAINT_ERROR_CODE = "ERR00001";
    public static final String UNIQUE_CONSTRAINT_ERROR_MESSAGE = "The specified Entity already exists.";
    public static final String UNIQUE_CONSTRAINT_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public static final String DATABASE_ERROR_CODE = "ERR12000";
    public static final String DATABASE_ERROR_MESSAGE = "Database error";
    public static final String DATABASE_ERROR_TYPE = HttpStatus.BAD_REQUEST.getReasonPhrase();

}
