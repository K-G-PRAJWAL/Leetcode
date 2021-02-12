package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CloneGraphNode {
    public int val;
    public List<CloneGraphNode> neighbors;

    public CloneGraphNode() {
        val = 0;
        neighbors = new ArrayList<CloneGraphNode>();
    }

    public CloneGraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<CloneGraphNode>();
    }

    public CloneGraphNode(int _val, ArrayList<CloneGraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    Map<Integer, CloneGraph> map = new HashMap<>();

    public CloneGraphNode cloneGraph(CloneGraphNode node) {
        return clone(node);
    }

    CloneGraphNode clone(CloneGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        CloneGraphNode clone = new CloneGraphNode(node.val);
        map.put(clone.val, clone);
        for (CloneGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}
