package com.trump.domain.validate;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2018/6/19.
 */
public class LoginParam {

    @NotBlank(message = "姓名不能为空")
    private String name;

//    @Min(18)
//    private Integer pass;
//
//    @Pattern(regexp = "^1(3|4|5|6|7|8|9)\\d{9}$",message = "手机号码格式错误")
//    @NotBlank(message = "手机号码不能为空")
//    private String phone;
//
//    @Email(message = "邮箱格式错误")
//    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "LoginParam{" +
                "name='" + name + '\'' +
                '}';
    }
}
