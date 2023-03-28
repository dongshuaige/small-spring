package cn.hgd.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hgd
 * 属性集合
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 集合中添加属性
     * @param pv 属性对象
     */
    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    /**
     * 获取属性数组
     */
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性名称获取属性对象
     * @param propertyName 属性名
     * @return 属性对象
     */
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv: this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
