package com.easyway.covid19.model;



public class Response {


	public interface StatusMessage {

		/** The no data found. */
		String NO_DATA_FOUND = "No data found for the requested service";

		/** The credit not available. */
		String CREDIT_NOT_AVAILABLE = "Credit not available";

		/** The credit already available. */
		String CREDIT_ALREADY_AVAILABLE = "User already has Credit";

		/** The success message. */
		String SUCCESS_MESSAGE = "Success.";

		/** The pending transaction success. */
		String PENDING_TRANSACTION_SUCCESS = "Processing pending transaction is success";

		/** The pending transaction failed. */
		String PENDING_TRANSACTION_FAILED = "Processing pending transaction failed";

		/** The reject transaction failed. */
		String REJECT_TRANSACTION_FAILED = "Rejecting pending transaction failed";

		/** The reject transaction success. */
		String REJECT_TRANSACTION_SUCCESS = "Rejecting pending transaction is success";

		/** The stripe charge success. */
		String STRIPE_CHARGE_SUCCESS = "Stripe charge created successfully.";

		/** The stripe refund success. */
		String STRIPE_REFUND_SUCCESS = "Stripe refund created successfully.";

		/** The transfer to topup success. */
		String TRANSFER_TO_TOPUP_SUCCESS = "TransferTo topup success.";

		/** The transfer to topup failure. */
		String TRANSFER_TO_TOPUP_FAILURE = "TransferTo topup failed.";

		/** The insufficient balance. */
		String INSUFFICIENT_BALANCE = "Topup Failed due to insufficient balance";

		/** The failure message. */
		String FAILURE_MESSAGE = "User Name or Password is not correct.";

		/** The error message. */
		String ERROR_MESSAGE = "Internal server error";

		/** The stripe charge failure. */
		String STRIPE_CHARGE_FAILURE = "Stripe charge failed.";

		/** The stripe refund failure. */
		String STRIPE_REFUND_FAILURE = "Stripe refund failed.";

		/** The stripe charge warning. */
		String STRIPE_CHARGE_WARNING = "Stripe charge success but inserting data into db failed.";

		/** The transfer to topup warning. */
		String TRANSFER_TO_TOPUP_WARNING = "TransferTo topup success but inserting data into db failed.";

		/** The stripe refund warning. */
		String STRIPE_REFUND_WARNING = "Stripe refund success but inserting data into db failed.";

		/** The form error message. */
		String FORM_ERROR_MESSAGE = "Please provide required form data.";

		/** The param error message. */
		String PARAM_ERROR_MESSAGE = "Please provide required parameters properly.";

		/** The no reserve id. */
		String NO_RESERVE_ID = "TransferTo Reserve ID generation failed.";

		/** The insertion failed. */
		String INSERTION_FAILED = "Insertion failed";

		/** The promo code exists. */
		String PROMO_CODE_EXISTS = "Promo Code already exists";

		/** The promo code does not exist. */
		String PROMO_CODE_DOES_NOT_EXIST = "Promo Code does not exist";

		/** The inactive promo code. */
		String INACTIVE_PROMO_CODE = "Inactive Promo Code";

		/** The registration failed. */
		String REGISTRATION_FAILED = "Registration failed";

		/** The registration full. */
		String REGISTRATION_FULL = "Registration full";

		/** The reset password failed. */
		String RESET_PASSWORD_FAILED = "Reset Password failed";

		/** The reset link send failed. */
		String RESET_LINK_SEND_FAILED = "Password reset link sending failed";

		/** The reset link expired. */
		String RESET_LINK_EXPIRED = "Password reset link expired.";

		/** The invalid token. */
		String INVALID_TOKEN = "Invalid token.";

		/** The user exists. */
		String USER_EXISTS = "Username already exists.";

		/** The email not found. */
		String EMAIL_NOT_FOUND = "Email not found.";

		/** The invalid user. */
		String INVALID_USER = "Invalid User";

		/** The active user. */
		String ACTIVE_USER = "Active User";

		/** The inactive user. */
		String INACTIVE_USER = "Inactive User";

		/** The limit exceed user. */
		String LIMIT_EXCEED_USER = "Limit Exceed User";

		/** The update failed. */
		String UPDATE_FAILED = "Update failed";

		/** The login failed. */
		String LOGIN_FAILED = "Login failed";

		/** The logout failed. */
		String LOGOUT_FAILED = "Logout failed";

		/** The invalid login. */
		String INVALID_LOGIN = "Invalid Login";

		/** The invalid session. */
		String INVALID_SESSION = "Invalid Session";

		/** The delete failed. */
		String DELETE_FAILED = "Delete failed";

		/** The insertion success. */
		String INSERTION_SUCCESS = "Insertion success";

		/** The feedback received insertion failed. */
		String FEEDBACK_RECEIVED_INSERTION_FAILED = "Recieved customer feedback but insertion of data into db failed.";

		/** The feedback received success. */
		String FEEDBACK_RECEIVED_SUCCESS = "Recieved customer feedback successfully.";

		/** The feedback received failed. */
		String FEEDBACK_RECEIVED_FAILED = "Recieving customer feedback failed.";

		/** The user add success. */
		String USER_ADD_SUCCESS = "User added successfully";

		/** The registration success. */
		String REGISTRATION_SUCCESS = "Registration success";

		/** The reset password success. */
		String RESET_PASSWORD_SUCCESS = "Reset Password success";

		/** The reset link send success. */
		String RESET_LINK_SEND_SUCCESS = "Password reset link sent success";

		/** The update success. */
		String UPDATE_SUCCESS = "Update success";

		/** The sending promo credit success. */
		String SENDING_PROMO_CREDIT_SUCCESS = "Sending promo credit to user success";

		/** The sending promo credit failed. */
		String SENDING_PROMO_CREDIT_FAILED = "Sending promo credit to user failed";

		/** The delete success. */
		String DELETE_SUCCESS = "Delete success";

		/** The login success. */
		String LOGIN_SUCCESS = "Login success";

		/** The logout success. */
		String LOGOUT_SUCCESS = "Logout success";

		/** The session verify success. */
		String SESSION_VERIFY_SUCCESS = "User Session verification success";

		/** The failed to store transferto database. */
		String FAILED_TO_STORE_TRANSFERTO_DATABASE = "Inserting data into TransferToTransaction table failed.";

		/** The update password success. */
		String UPDATE_PASSWORD_SUCCESS = "Password Updated successfully";

		/** The update password failed. */
		String UPDATE_PASSWORD_FAILED = "Password Updation failed";

		/** The invalid email. */
		String INVALID_EMAIL = "Email not resgistered, Please try again";

		/** The disabled email. */
		String DISABLED_EMAIL = "Your account has been disabled. Please contact customer support.";

		/** The link send to email success. */
		String LINK_SEND_TO_EMAIL_SUCCESS = "Resetlink successfully send to your mail";

		/** The failed to send link. */
		String FAILED_TO_SEND_LINK = "Unable to reset your password";

		/** The failed to store randomcode. */
		String FAILED_TO_STORE_RANDOMCODE = "Failed to store randomecode";

		/** The invalid reset code. */
		String INVALID_RESET_CODE = "ResetCode is invalid";

		/** The reset code time expired. */
		String RESET_CODE_TIME_EXPIRED = "ResetCode time period was expired";

		/** The password reset done already. */
		String PASSWORD_RESET_DONE_ALREADY = "Password reset done already";

		/** The valid reset code. */
		String VALID_RESET_CODE = "ResetCode is valid";

		/** The stripe charge insert failed. */
		String STRIPE_CHARGE_INSERT_FAILED = "Stripe transaction failed to store in Database, Please try again.";

		/** The stripe create customer failure. */
		String STRIPE_CREATE_CUSTOMER_FAILURE = "Failed to create stripe customer";

		/** The paypal payment failed. */
		String PAYPAL_PAYMENT_FAILED = "We are unable to process your request at this time. Please try again later";

		/** The email error message. */
		String EMAIL_ERROR_MESSAGE = "Please provide Email";

		/** The exp date error message. */
		String EXP_DATE_ERROR_MESSAGE = "Please provide Expiration date";

		/** The exp date error message 2. */
		String EXP_DATE_ERROR_MESSAGE_2 = "Expiration date should be greater than current time";

		/** The email error message 2. */
		String EMAIL_ERROR_MESSAGE_2 = "Please provide valid Email";

		/** The message error. */
		String MESSAGE_ERROR = "Please provide Message";

		/** The name error message. */
		String NAME_ERROR_MESSAGE = "Please provide Name";

		/** The name error message2. */
		String NAME_ERROR_MESSAGE2 = "Name should be alphabetic";

		/** The orderstatus error message. */
		String ORDERSTATUS_ERROR_MESSAGE = "Please provide Order Status";

		/** The orderstatus error message 2. */
		String ORDERSTATUS_ERROR_MESSAGE_2 = "Please provide valid Order Status";

		/** The orderid error message. */
		String ORDERID_ERROR_MESSAGE = "Please provide Order Id";

		/** The orderid error message 2. */
		String ORDERID_ERROR_MESSAGE_2 = "Please provide valid Order Id";

		/** The paypaltxid error message. */
		String PAYPALTXID_ERROR_MESSAGE = "Please provide PayPal Transaction Id";

		/** The paypaltxid error message 2. */
		String PAYPALTXID_ERROR_MESSAGE_2 = "Please provide valid PayPal Transaction Id";

		/** The unitid error message. */
		String UNITID_ERROR_MESSAGE = "Please provide Unit Id";

		/** The unitid error message 2. */
		String UNITID_ERROR_MESSAGE_2 = "Please provide valid Unit Id";

		/** The gatewaytxid error message. */
		String GATEWAYTXID_ERROR_MESSAGE = "Please provide Gateway Transaction Id";

		/** The promocodeid error message. */
		String PROMOCODEID_ERROR_MESSAGE = "Please provide Promo Code Id";

		/** The promocodeid error message1. */
		String PROMOCODEID_ERROR_MESSAGE1 = "Please provide Promo Code Id should be greater than 0";

		/** The promocreditid error message. */
		String PROMOCREDITID_ERROR_MESSAGE = "Please provide creditTxId";

		/** The sessiontoken error message. */
		String SESSIONTOKEN_ERROR_MESSAGE = "Please provide Session Token Id";

		/** The sessiontoken error message 2. */
		String SESSIONTOKEN_ERROR_MESSAGE_2 = "Please provide valid Session Token Id";

		/** The passwword error message. */
		String PASSWWORD_ERROR_MESSAGE = "Please provide password";

		/** The passwword len error message. */
		String PASSWWORD_LEN_ERROR_MESSAGE = "min length of password should be 8 characters";

		/** The fname error message. */
		String FNAME_ERROR_MESSAGE = "Please provide First Name";

		/** The promocode error message. */
		String PROMOCODE_ERROR_MESSAGE = "Please provide Promo Code";

		/** The promocode error message2. */
		String PROMOCODE_ERROR_MESSAGE2 = "Promo Code should be alphanumeric";

		/** The fname error message 2. */
		String FNAME_ERROR_MESSAGE_2 = "First Name should be alphabetic";

		/** The lname error message. */
		String LNAME_ERROR_MESSAGE = "Please provide Last Name";

		/** The lname error message 2. */
		String LNAME_ERROR_MESSAGE_2 = "Last Name should be alphabetic";

		/** The phone error message. */
		String PHONE_ERROR_MESSAGE = "Please provide Phone number";

		/** The phone error message 2. */
		String PHONE_ERROR_MESSAGE_2 = "Please provide valid Phone number";

		/** The product error message. */
		String PRODUCT_ERROR_MESSAGE = "Please provide Product";

		/** The promocode amount error message. */
		String PROMOCODE_AMOUNT_ERROR_MESSAGE = "Please provide Promo Code Amount";

		/** The promocode amount error message 2. */
		String PROMOCODE_AMOUNT_ERROR_MESSAGE_2 = "Please provide valid Promo Code Amount upto two decimal places";

		/** The promocode status error message. */
		String PROMOCODE_STATUS_ERROR_MESSAGE = "Please provide Promo Code Status";

		/** The facebookid error message. */
		String FACEBOOKID_ERROR_MESSAGE = "Please provide Facebook ID";

		/** The resetpassworduuid error message. */
		String RESETPASSWORDUUID_ERROR_MESSAGE = "Please provide Reset Password UUID";

		/** The resetcode error message. */
		String RESETCODE_ERROR_MESSAGE = "Please provide Reset Code";

		/** The promocode error message3. */
		String PROMOCODE_ERROR_MESSAGE3 = "max length of Promo Code should be 10 characters";

		/** The promocode error message4. */
		String PROMOCODE_ERROR_MESSAGE4 = "Please provide Promo Id";

		/** The product out of range. */
		String PRODUCT_OUT_OF_RANGE = "Requested Product out of range";

		/** The zero amount promo code. */
		String ZERO_AMOUNT_PROMO_CODE = "Zero amount promo code";

	}

}
