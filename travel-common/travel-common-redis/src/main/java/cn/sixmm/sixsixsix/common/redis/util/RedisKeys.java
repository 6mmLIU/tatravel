package cn.sixmm.sixsixsix.common.redis.util;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum RedisKeys {
    BRUSH("brush",1*60),
    STRATEGY_USER_THUMBSUP("strategy_user_thumbsup",-1l),
    STRATEGY_USER_FAVOR("strategy_user_favor", -1l),
    STRATEGY_STATUS_HASH("strategy_statis_hash", -1l),
    VERIFY_CODE("verify_code", 3 * 60);
    private String prefix;//key的前缀
    private long time;//过期时间

    private RedisKeys(String prefix, long time) {
        this.prefix = prefix;
        this.time = time;

    }

    /**
     * key的拼接方法
     * 参数:
     * 要拼接的内容,可以是多段.
     * eg. user_login_info:11
     * 返回值后得到的key
     */
    public String join(String... values) {
        StringBuffer sb = new StringBuffer();
        sb.append(this.prefix);
        for (String value : values) {
            sb.append(":").append(value);
        }
        return sb.toString();
    }
}
