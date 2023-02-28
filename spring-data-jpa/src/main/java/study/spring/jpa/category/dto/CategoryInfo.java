package study.spring.jpa.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.jpa.category.model.Category;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryInfo {
    private Long id;
    private String name;
    private List<CategoryInfo> children;

    public static CategoryInfo create(Category category, List<CategoryInfo> children) {
        return CategoryInfo.builder()
                .id(category.getId())
                .name(category.getName())
                .children(children)
                .build();
    }
}
