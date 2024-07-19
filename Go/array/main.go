package main

import "fmt"

func main() {
	var array = [...]int{1, 2, 3, 4, 5, 6, 7, 8}
	s1 := array[3:6]
	s2 := array[:5]
	s3 := array[4:]
	s4 := array[:]
	fmt.Printf("s1: %v\n", s1) // s1: [4 5 6]
	fmt.Printf("s2: %v\n", s2) // s2: [1 2 3 4 5]
	fmt.Printf("s3: %v\n", s3) // s3: [5 6 7 8]
	fmt.Printf("s4: %v\n", s4) // s4: [1 2 3 4 5 6 7 8]

	// 使用 make 创建切片
	// len: 10, cap: 10
	a := make([]int, 10)
	// len: 10, cap: 15
	b := make([]int, 10, 15)

	fmt.Printf("a: %v, len: %d, cap: %d\n", a, len(a), cap(a))
	fmt.Printf("b: %v, len: %d, cap: %d\n", b, len(b), cap(b))

	var m = map[string]int{"a": 1, "b": 2}
	fmt.Println(m) // map[a:1 b:2]

	// 使用 make 创建
	m1 := make(map[string]int)
	m1["a"] = 1
	m1["b"] = 2
	fmt.Println(m1)

	// 判断键是否存在
	if v, ok := m1["a"]; ok {
		fmt.Println(v) // 1
	} else {
		fmt.Println("not exist")
	}
}

func test(x [2]int) {
	fmt.Printf("x: %p, %v\n", &x, x) // x: 0xc00012e020, [10 20]
}
