package org.humanoo.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    @NotEmpty
    @NotNull
    private String bookName;
    @NotEmpty
    @NotNull
    private String authorName;
    @NotNull
    @NotEmpty
    private String isbn;
    private String categories;
    private String id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;

}
