package xyz.zhiweicoding.factory;

import xyz.zhiweicoding.constant.BaseResponseConstant;
import xyz.zhiweicoding.vo.BaseResponse;

/**
 * @author by diaozhiwei on 2023/05/04.
 * @email diaozhiwei2k@163.com
 */
public class ResponseFactory {

    public static <T> BaseResponse<T> success(String msg, T data) {
        return new BaseResponse<>(BaseResponseConstant.SUCCESS, msg, data);
    }

    public static <T> BaseResponse<T> error(String msg, T data) {
        return new BaseResponse<>(BaseResponseConstant.ERROR, msg, data);
    }

}
