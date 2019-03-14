package com.kuzoncby.mix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ApiModel(value = "人员实体", description = "数据库人员实体")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "记录主键")
    private Long id;
    @ApiModelProperty(notes = "人员名称")
    private String name;
    @ApiModelProperty(notes = "人员显示名称")
    private String displayName;

}
