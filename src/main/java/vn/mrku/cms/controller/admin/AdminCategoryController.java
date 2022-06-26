package vn.mrku.cms.controller.admin;

import org.springframework.web.bind.annotation.*;
import vn.mrku.cms.controller.admin.dto.CategoryDetailDto;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {
    @GetMapping
    List<CategoryDetailDto> list() {
        return null;
    }

    @PostMapping
    CategoryDetailDto create() {
        return null;
    }

    @PutMapping
    CategoryDetailDto edit() {
        return null;
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable int id) {

    }

    @PostMapping("/public/{id}")
    CategoryDetailDto enable(@PathVariable int id) {
        return null;
    }

    @PostMapping("/draft/{id}")
    CategoryDetailDto disable(@PathVariable int id) {
        return null;
    }

}
