package org.redeyefrog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode {

    SUCCESS("0000", "Success"),

    SYSTEM_ERROR("9999", "System error");

    private String code;

    private String desc;

}
