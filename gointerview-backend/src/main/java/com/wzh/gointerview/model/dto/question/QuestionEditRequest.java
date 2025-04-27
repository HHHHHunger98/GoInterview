package com.wzh.gointerview.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Question edit request class
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionEditRequest implements Serializable {

    /**
     * question id
     */
    private Long id;

    /**
     * question title
     */
    private String title;

    /**
     * question content
     */
    private String content;

    /**
     * tag list(JSON Array)
     */
    private List<String> tags;

    /**
     * answer to question
     */
    private String answer;

    private static final long serialVersionUID = 1L;
}
