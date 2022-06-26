package vn.mrku.cms.controller.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Section")
public class CategoryDetailDto {
    int categoryId;
    String languageCode;
    String name;
    int orderNumber;
    boolean isAvailable;
    String display;
}
