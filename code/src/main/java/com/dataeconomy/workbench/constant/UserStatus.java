package com.dataeconomy.workbench.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author GuvalaL1
 *
 */
public enum UserStatus {
	USER_FIRST_LOGIN(-1, "Inactive"),
    USER_ENABLED(0, "Active"),
    USER_DISABLED(1, "Disabled"),
    USER_INACTIVE(2, "Inactive"),
	USER_LOCKED(3, "Locked"),
	USER_EXPIRED(4,"Expired");

    public final int value;
    public final String stringValue;

    private static final Map<Integer, UserStatus> valueMap = new HashMap<Integer, UserStatus>();
    private static final Map<String, UserStatus> stringMap = new HashMap<String, UserStatus>();

    static {
        for (UserStatus constant : UserStatus.class.getEnumConstants()) {
            valueMap.put(constant.value, constant);
            stringMap.put(constant.stringValue, constant);
        }
    }

    private UserStatus(int value, String stringValue) {
        this.value = value;
        this.stringValue = stringValue;
    }

    
    public static UserStatus fromString(final String stringValue) {
        return stringMap.get(stringValue);
    }

    public static UserStatus fromInteger(final Integer intValue) {
        return valueMap.get(intValue);
    }
}
