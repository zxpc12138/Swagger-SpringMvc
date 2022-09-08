package com.swagger.entiry;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author:钟湘
 * @data: 20:11
 */

//@ApiModel("用户实体类")
@Schema(name = "User",description = "用户实体类")
public class User {

    //    @ApiModelProperty("id")
    @Schema(name = "id",description = "用户id")
    private Integer id;
    //    @ApiModelProperty("用户名")
    @Schema(name = "name",description = "用户名")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
