package vn.mrku.cms.controller.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.mrku.cms.domain.dto.CategoryDto;
import vn.mrku.cms.domain.entity.Category;
import vn.mrku.cms.domain.entity.CategoryMl;
import vn.mrku.cms.domain.repository.CategoryMlRepository;
import vn.mrku.cms.domain.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMlRepository categoryMlRepository;

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public CategoryDto create(CategoryDto dto) {
        var category = new Category();
        var categoryMl = new CategoryMl();
        BeanUtils.copyProperties(dto, category);
        categoryRepository.insert(category);
        BeanUtils.copyProperties(dto, categoryMl);
        categoryMl.setCategoryId(category.getCategoryId());
        categoryMlRepository.insert(categoryMl);
        return null;
    }

    @Transactional
    public CategoryDto edit(CategoryDto dto) {
        var category = new Category();
        var categoryMl = new CategoryMl();
        BeanUtils.copyProperties(dto, category);
        categoryRepository.update(category);
        BeanUtils.copyProperties(dto, categoryMl);
        categoryMlRepository.update(categoryMl);
        return null;
    }

    public void delete(int id) {

    }

    public CategoryDto enable(int id) {
        return null;
    }

    public CategoryDto disable(int id) {
        return null;
    }
}
