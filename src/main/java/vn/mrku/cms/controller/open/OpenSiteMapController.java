package vn.mrku.cms.controller.open;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.mrku.cms.controller.open.dto.OpenCategoryDetailDto;
import vn.mrku.cms.controller.open.dto.OpenSitemapDto;

import java.util.ArrayList;

@RestController
@RequestMapping("/open")
public class OpenSiteMapController {
    @GetMapping(value = "/sitemap.xml", produces = MediaType.APPLICATION_XML_VALUE)
    OpenSitemapDto siteMap() {
        var c = new OpenCategoryDetailDto();
        var s = new OpenSitemapDto();
        var l = new ArrayList<OpenCategoryDetailDto>();
        l.add(c);
        s.setCategories(l);
        return s;
    }
}
