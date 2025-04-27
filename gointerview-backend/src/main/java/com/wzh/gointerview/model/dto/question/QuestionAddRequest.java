package com.wzh.gointerview.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Add new question to question table
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionAddRequest implements Serializable {

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

}
