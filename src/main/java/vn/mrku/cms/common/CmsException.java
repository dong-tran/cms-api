package vn.mrku.cms.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CmsException extends RuntimeException {
    String code;
    String message;
}
