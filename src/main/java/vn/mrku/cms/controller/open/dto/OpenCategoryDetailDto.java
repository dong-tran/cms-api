package vn.mrku.cms.controller.open.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Section")
public class OpenCategoryDetailDto {
    int categoryId;
    String languageCode;
    String name;
    String display;
}
