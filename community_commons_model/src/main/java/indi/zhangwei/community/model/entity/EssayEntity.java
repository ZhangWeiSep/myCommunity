package indi.zhangwei.community.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @pathName: EssayEntity
 * @author: ZhangWei
 * 文章信息实体 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog_essay")
public class EssayEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户唯一Id
     */
    private Integer userId;

    /**
     * 文章标题
     */
    private String essayName;

    /**
     * 文章内容
     */
    private String essayContent;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 发布时间
     */
    private LocalDateTime pubTime;

    /**
     * 文章状态：0 未发布、1 已发布
     */
    private Integer pubState;


}

