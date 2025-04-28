package com.wzh.gointerview.model.dto.question;

import com.wzh.gointerview.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Query questions request class
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * query by question id
     */
    private Long id;

    /**
     * query exclude by question id
     */
    private Long notId;

    /**
     * query by question title
     */
    private String title;

    /**
     * query by searching text
     */
    private String searchText;

    /**
     * query by question content
     */
    private String content;

    /**
     * query by tags
     */
    private List<String> tags;

    /**
     * query by the answer
     */
    private String answer;

    /**
     * query by the user id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
