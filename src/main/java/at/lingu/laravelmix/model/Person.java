package at.lingu.laravelmix.model;

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
@ApiModel(value = "Person Entity", description = "H2 database entity")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "PK")
    private Long id;
    @ApiModelProperty(notes = "Name")
    private String name;
    @ApiModelProperty(notes = "Display Name")
    private String displayName;

}
