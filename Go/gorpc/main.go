package main

import (
	"context"
	"log"
	"time"

	"google.golang.org/grpc"

	pb "cn.iocoder.springboot.lab64.userservice.api"
)

func main() {
	conn, err := grpc.Dial("localhost:50051", grpc.WithInsecure(), grpc.WithBlock())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()
	client := pb.NewUserServiceClient(conn)

	// 调用 Get 方法
	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	getRequest := &pb.UserGetRequest{Id: 1}
	getResponse, err := client.Get(ctx, getRequest)
	if err != nil {
		log.Fatalf("could not get user: %v", err)
	}
	log.Printf("User: %v", getResponse)

	// 调用 Create 方法
	createRequest := &pb.UserCreateRequest{Name: "Test", Gender: 1}
	createResponse, err := client.Create(ctx, createRequest)
	if err != nil {
		log.Fatalf("could not create user: %v", err)
	}
	log.Printf("Created User ID: %v", createResponse.GetId())

}
