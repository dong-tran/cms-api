package vn.mrku.cms.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CmsExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handle(Exception ex) {
//        log.error(ex.toString());
//        if (ex instanceof CmsException) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex);
//        }
//        var e = new CmsException("500", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
//    }
}
