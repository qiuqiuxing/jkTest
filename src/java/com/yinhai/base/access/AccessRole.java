package com.yinhai.base.access;

/**
 * 用户角色
 */
public enum AccessRole {
    /**
     * 在职
     */
    CJ,//城居
    CZQY,//城职（企业）
    CZGT,//城职（个体）
    QT,//其他（如仅有城居医疗人员）
    /**
     * 退休
     */
    TXCJ,//退休城居
    TXCZ;//退休城职

    /**
     * 是否退休人员
     * @return
     */
    public boolean isTX(){
        if(this == TXCJ || this == TXCZ){
            return true;
        }
        return false;
    }

}
