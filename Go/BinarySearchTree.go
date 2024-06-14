package main

import "sync"

type Node struct {
	key   int
	value Item
	left  *Node //left
	right *Node //right
}

type ItemBinarySearchTree struct {
	root *Node
	lock sync.RWMutex
}

func (bst *ItemBinarySearchTree) Insert(key int, value Item) {
	bst.lock.Lock()
	defer bst.lock.Unlock()
	n := &Node{key, value, nil, nil}
	if bst.root == nil {
		bst.root = n
	} else {
		insertNode(bst.root, n)
	}
}

func insertNode(node, newNode *Node) {
	if newNode.key < node.key {
		if node.left == nil {
			node.left = newNode
		} else {
			insertNode(node.left, newNode)
		}
	} else {
		if node.right == nil {
			node.right = newNode
		} else {
			insertNode(node.right, newNode)
		}
	}
}
