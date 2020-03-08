package common;

/**
 * 注册结果数据结构
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class RegResult extends Protocol {
    private ResultCode.Code resultCode; // 注册结果

    /**
     * 构造方法
     */
    public RegResult() {
        super(Type.Reg);
    }

    /**
     * 获取结果
     * Getter for the resultCode.
     *
     * @return the value of resultCode.
     */
    public ResultCode.Code getResultCode() {
        return resultCode;
    }

    /**
     * 设置结果
     * Setter for the resultCode.
     * The resultCode of RegResult is updated.
     *
     * <p>You can use getResultCode() to get the value of resultCode</p>
     *
     * @param resultCode resultCode
     */
    public void setResultCode(ResultCode.Code resultCode) {
        this.resultCode = resultCode;
    }
}
