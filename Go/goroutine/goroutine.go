package main

import (
	"fmt"
)

type HashMap struct {
	key      string
	value    string
	hashCode int
	next     *HashMap
}

var table [16]*HashMap

func initTable() {
	for i := range table {
		table[i] = nil
	}
}

func getInstance() [16]*HashMap {
	if table[0] == nil {
		initTable()
	}
	return table
}

func genHashCode(k string) int {
	var hashCode int
	for i := range k {
		hashCode = (hashCode * 31) + int(k[i])
	}
	return hashCode
}

func indexTable(hashCode int) int {
	return hashCode % len(table)
}

func put(k string, v string) string {
	hashCode := genHashCode(k)
	thisNode := &HashMap{k, v, hashCode, nil}

	tableIndex := indexTable(hashCode)
	headPtr := getInstance()
	headNode := headPtr[tableIndex]

	if headNode == nil {
		table[tableIndex] = thisNode
		return ""
	}

	var lastNode *HashMap
	for node := headNode; node != nil; node = node.next {
		if node.key == k {
			oldValue := node.value
			node.value = v
			return oldValue
		}
		lastNode = node
	}

	lastNode.next = thisNode
	return ""
}

func get(k string) string {
	hashCode := genHashCode(k)
	tableIndex := indexTable(hashCode)

	headPtr := getInstance()
	node := headPtr[tableIndex]

	for node != nil {
		if node.key == k {
			return node.value
		}
		node = node.next
	}
	return ""
}

// 示例
func main() {
	put("a", "a_put")
	put("b", "b_put")
	fmt.Println(get("a")) // 输出：a_put
	fmt.Println(get("b")) // 输出：b_put
	put("p", "p_put")
	fmt.Println(get("p")) // 输出：p_put
}
