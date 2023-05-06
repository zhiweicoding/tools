package xyz.zhiweicoding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author by diaozhiwei on 2023/05/01.
 * @email diaozhiwei2k@163.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "基本消息回复格式")
public class BaseResponse<T> implements Serializable {

    /**
     * 状态码，同http状态码 200 成功 500 异常 401 未授权 403 无权限 404 未找到资源 400 参数错误 405 方法不支持
     */
    @ApiModelProperty(value = "状态码", required = true, example = "200", position = 1, dataType = "int")
    private int code;
    @ApiModelProperty(value = "消息", required = true, example = "请求成功", position = 2, dataType = "String")
    private String message;
    @ApiModelProperty(value = "数据", required = false, position = 3)
    private T data;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
