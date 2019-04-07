package com.longbow.gateway.main;

import com.longbow.gateway.main.bo.GatedLaunchData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangbin on 2018/8/31.
 */
@Component
public class GatedLaunchHelper {
    private List<GatedLaunchData> list = new ArrayList<>();

    public List<GatedLaunchData> getList() {
        return list;
    }

    public void addData(GatedLaunchData data) {
        data.setUuid(getUUID32());
        list.add(data);
    }

    public void delData(String uuid) {
        for(int i=0; i<list.size();i++){
            if(list.get(i).getUuid().equals(uuid)){
                list.remove(i);
                break;
            }
        }
    }

    public void editData(String uuid, GatedLaunchData data) {
        for(int i=0; i<list.size();i++){
            if(list.get(i).getUuid().equals(uuid)){
                list.set(i, data);
                break;
            }
        }
    }

    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
