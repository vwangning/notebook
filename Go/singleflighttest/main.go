package main

import (
	"fmt"
	"golang.org/x/sync/singleflight"
	"sync"
	"sync/atomic"
	"time"
)

func main() {
	g := singleflight.Group{}
	key := "key"                // 对相同的 key, 同一时刻只会执行一次
	calls := int32(0)           // fn 函数执行的次数
	wg1 := sync.WaitGroup{}     // 控制代码执行位置
	wg2 := sync.WaitGroup{}     // 控制所有 goroutine 执行完毕
	c := make(chan struct{}, 1) // 控制 fn 继续执行

	fn := func() (interface{}, error) {
		if atomic.AddInt32(&calls, 1) == 1 { // 第一次执行
			wg1.Done()
		}
		<-c
		c <- struct{}{}
		time.Sleep(10 * time.Millisecond) // 让更多的 goroutine 进入 g.Do(key, fn) 函数

		return "fn", nil
	}
	num := 10
	wg1.Add(1)
	for i := 0; i < num; i++ {
		wg1.Add(1)
		wg2.Add(1)
		go func() { // 启动 10 个 goroutine 调用 singleflight.Do() 函数
			defer wg2.Done()
			wg1.Done()
			g.Do(key, fn) // fn 函数只会执行一次
		}()
	}

	wg1.Wait()                            // 全部的 goroutine 均已经启动且至少执行到了 g.Do(key, fn)这一行, 已经有 goroutine 进入 fn 函数
	c <- struct{}{}                       // fn 函数继续执行
	wg2.Wait()                            // 所有 goroutine 均已执行完
	fmt.Println(atomic.LoadInt32(&calls)) // fn 共执行一次
	g.Do(key, fn)
	fmt.Println(atomic.LoadInt32(&calls)) // fn 共执行两次

}
