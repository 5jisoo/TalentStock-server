package com.second.talentstock.common;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    /**
     * 1000: 요청 성공
     */
    // user (1000 ~ 1199)
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    // offer (1200 ~ 1299)

    // interest (1300 ~ 1399)

    /**
     * 2000: Request Error
     */

    // user (2000 ~ 2199)
    INVALID_USER_ID(false, 2000, "유효하지 않은 유저 ID값 입니다."),

    // offer (2200 ~ 2299)

    // interest (2300 ~ 2399)


    /**
     * 3000: Response Error
     */

    // user (2000 ~ 2199)

    // offer (3200 ~ 3299)

    // interest (3300 ~ 3399)


    /**
     * 4000: DB Error
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}