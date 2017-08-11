package com.bpl.tucao.vo;

/**
 * @author cuiyongdai
 * @desc
 * @since 2017/4/11 0011.
 */
public class ResponseVo {

    public static String SUCCESS = "S";
    public static String FAIL = "F";

    private Meta meta;
    private Object data;

    public ResponseVo() {
        result(SUCCESS);
    }

    public void result(String isSuccess) {
        this.meta = new Meta(isSuccess);
    }

    public void result(String isSuccess, String message) {
        this.meta = new Meta(isSuccess, message);
    }

    public void result(String isSuccess, String message, Object data) {
        this.meta = new Meta(isSuccess, message);
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public class Meta {
        private String isSuccess;
        private String message;

        public Meta(String isSuccess) {
            this.isSuccess = isSuccess;
        }

        public Meta(String isSuccess, String message) {
            this.isSuccess = isSuccess;
            this.message = message;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public String getIsSuccess() {
            return isSuccess;
        }

        public String getMessage() {
            return message;
        }
    }
}
