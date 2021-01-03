package com.training.api.entity.dto;

import com.training.api.entity.Level;
import lombok.Data;

import java.util.Date;

@Data
public class ExerciseDto {
    private int id;
    private String name;
    private Level level;
    private String description;
    private int categoryId;
    private String categoryName;
    private int typeId;
    private String typeName;
    private Date created;
    private Date modified;
}
