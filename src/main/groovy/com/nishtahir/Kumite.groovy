package com.nishtahir

def toCharFrequencyMap(String val) {
    return val.inject([:]) { map, c ->
        map.put(c, map[c] == null ? 1 : map[c] + 1); map //this is just unfortunate
    }
}