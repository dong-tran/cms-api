package vn.mrku.cms.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.mrku.cms.controller.admin.service.CategoryService;
import vn.mrku.cms.domain.dto.CategoryDto;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@RequiredArgsConstructor
public class AdminCategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<CategoryDto> list() {
        return categoryService.findAll();
    }

    @PostMapping
    CategoryDto create(@RequestBody @Validated CategoryDto dto) {
        return categoryService.create(dto);
    }

    @PutMapping
    CategoryDto edit(@RequestBody @Validated CategoryDto dto) {
        return categoryService.edit(dto);
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @PostMapping("/public/{id}")
    CategoryDto enable(@PathVariable int id) {
        return categoryService.enable(id);
    }

    @PostMapping("/draft/{id}")
    CategoryDto disable(@PathVariable int id) {
        return categoryService.disable(id);
    }

}
