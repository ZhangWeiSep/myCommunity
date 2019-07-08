package indi.zhangwei.community.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @pathName: EssayTagEntity
 * @author: ZhangWei
 * 文章标签关系实体 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "blog_essay_tag")
public class EssayTagEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    private Integer essayId;

    /**
     * 标签ID
     */
    private Integer tagId;


}

