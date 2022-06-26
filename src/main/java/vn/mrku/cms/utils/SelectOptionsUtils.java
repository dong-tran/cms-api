package vn.mrku.cms.utils;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.data.domain.Pageable;

public class SelectOptionsUtils {

    public static SelectOptions get(Pageable pageable) {
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int limit = pageable.getPageSize();
        return SelectOptions.get().offset(offset).limit(limit).count();
    }
}