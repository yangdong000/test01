package rico.demo.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Rico.Chen on 2017/3/2.
 *  entity - JavaBean
 *  domain:
 *  1) entity 封装传递数据
 *  2) ORM 对象-关系数据库的映射
 *  3) Validation 字段数据的验证（服务器验证）
 */
@Data
public class Book {

    private  Long id;

    @NotBlank(message = "标题Title字段不能为空。")
    @Size(min = 2, max = 10, message = "标题Title字段的长度应该在2~10个字符。")
    private String title;

    //@Pattern(regexp = "", message = "")
    @NotBlank(message = "内容Content字段不能为空。")
    @Size(min = 5, max = 50, message = "内容Content字段的长度应该在2~10个字符。")
    private String content;

}
