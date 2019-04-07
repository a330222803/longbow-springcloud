package com.longbow.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Treegrid<T> {

    private TreegridNode<T> root;

    private Treegrid() {
    }

    private static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };

    public static <T> String toJson(List<T> list, String parentField, String
            nodeField, String rootValue) throws Exception {
        List<TreegridNode<T>> treegridNode = new ArrayList<>();
        for (T data : list) {
            if (String.valueOf(Reflections.getAccessibleField(data, parentField).get
                    (data)).equals(rootValue)) {
                TreegridNode<T> node = generateNode(list, data, parentField,
                        nodeField);
                treegridNode.add(node);
            }
        }

        List<Map<String, Object>> mapList = new ArrayList<>();
        for (TreegridNode<T> node : treegridNode) {
            Map<String, Object> map = new HashMap<>();
            toMap(node, map);
            mapList.add(map);
        }

        return JSON.toJSONString(mapList, filter, SerializerFeature.WriteMapNullValue);
    }

    private static <T> TreegridNode<T> generateNode(List<T> list, T currentNode,
                                                    String parentField, String nodeField) throws IllegalAccessException {
        List<TreegridNode<T>> childrenNodeList = new ArrayList<>();
        for (T newNode : list) {
            if (null != Reflections.getAccessibleField(newNode, parentField) &&
                    String.valueOf(Reflections.getAccessibleField(newNode,
                            parentField).get(newNode)).equals(String.valueOf(
                            Reflections.getAccessibleField(currentNode, nodeField)
                                    .get(currentNode)))) {
                TreegridNode<T> childrenNode = generateNode(list, newNode,
                        parentField, nodeField);
                childrenNodeList.add(childrenNode);
            }
        }
        TreegridNode<T> treegridNode = new TreegridNode(currentNode);
        treegridNode.setChildren(childrenNodeList);
        return treegridNode;
    }

    private static <T> void toMap(TreegridNode<T> node,
                                  Map<String, Object> map) {
        if (null != node) {
            Field[] fs = node.getData().getClass().getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                try {
                    map.put(f.getName(), f.get(node.getData()));
                } catch (IllegalAccessException e) {
                }
            }
            List<Map<String, Object>> childrenList = new ArrayList<>();
            for (int i = 0; i < node.getChildren().size(); i++) {
                Map<String, Object> child = new HashMap<>();
                toMap(node.getChildren().get(i), child);
                childrenList.add(child);
            }
            if (!childrenList.isEmpty()) {
                map.put("children", childrenList);
            }
        }
    }

}
