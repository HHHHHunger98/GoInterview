package com.wzh.gointerview.model.dto.user;

import com.wzh.gointerview.common.PageRequest;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User query request
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 * 
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     *  Third party id: subId
     */
    private String subId;

    /**
     * User name
     */
    private String userName;

    /**
     * Profile
     */
    private String userProfile;

    /**
     * User role：user/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}