package com.wzh.gointerview.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * User login request
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 * 
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}
