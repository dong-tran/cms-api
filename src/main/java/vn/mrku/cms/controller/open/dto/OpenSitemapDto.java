package vn.mrku.cms.controller.open.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(namespace = "cms", localName = "SiteMap")
public class OpenSitemapDto {
    List<OpenCategoryDetailDto> categories;
}
