package com.ecommerce.enums;

public enum AccountStatus {

	PENDING_VERIFICATION,  // Account is creted but not verified
	ACTIVE,                // Account is active 
	SUSPENDED,             // Account is temporarly suspended.
	DEACTIVATED,           // Account is deactived user can deactive our own account
	BANNED,                // Account is banned permanently due too violations.
	CLOSED                 // Account is closed.
}
