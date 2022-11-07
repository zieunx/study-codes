package com.study.aop.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@ToString(of = {"first", "middle", "last"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Name {
    @NotEmpty
    @Column(name = "first_name", length = 50)
    private String first;

    @Column(name = "middle_name", length = 50)
    private String middle;

    @NotEmpty
    @Column(name = "last_name", length = 50)
    private String last;

    @Builder
    public Name(final String first, final String middle, final String last) {
        this.first = first;
        this.middle = Strings.isBlank(middle) ? null : middle;
        this.last = last;
    }

    public String getFullName() {
        if (this.middle == null) {
            return String.format("%s %s", this.first, this.last);
        }
        return String.format("%s %s %s", this.first, this.middle, this.last);
    }
}
