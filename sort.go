package main

import "fmt"

func main() {

	var array = []int{2, 1, 7, 0, 10, 17, 89, 90, 11, 12, -6, 900, 11, 8, 72}

	array = []int{2, 1, 7, 0, 10, 17, 89, 90, 11, 12, -6, 900, 11, 8, 72}
	QuickSort(array, 0, len(array)-1)
	fmt.Println(array)

	array = []int{2, 1, 7, 0, 10, 17, 89, 90, 11, 12, -6, 900, 11, 8, 72}
	BubbleSort(array)
	fmt.Println(array)

	array = []int{2, 1, 7, 0, 10, 17, 89, 90, 11, 12, -6, 900, 11, 8, 72}
	SelectenSort(array)
	fmt.Println(array)

	array = []int{2, 1, 7, 0, 10, 17, 89, 90, 11, 12, -6, 900, 11, 8, 72}
	StoogeSort(array,0, len(array)-1)
	fmt.Println(array)

	for  x := range array {
		fmt.Println(x)
	}
}

//冒泡排序
func BubbleSort(arr []int) {
	ilength := len(arr)
	for i := 0; i < ilength; i++ {
		for j := ilength - 1; j > i; j-- {
			if arr[j] < arr[j-1] {
				arr[j], arr[j-1] = arr[j-1], arr[j]
			}
		}
	}
}

//选择排序
func SelectenSort(arr []int) {

	ilength := len(arr)
	if ilength <= 1 {
		return
	}
	for i := 0; i < ilength; i++ {

		minindex := i
		for j := ilength - 1; j > i; j-- {
			if arr[j] < arr[minindex] {
				minindex = j
			}
		}
		if minindex != i {
			arr[minindex], arr[i] = arr[i], arr[minindex]
		}
	}
}

//快速排序
func QuickSort(arr []int, left, right int) {

	if left >= right {
		return
	}
	i, j := left, right
	key := arr[left]
	for i < j {
		for i < j && key < arr[j] {
			j--
		}
		arr[i] = arr[j]
		for i < j && key >= arr[i] {
			i++
		}
		arr[j] = arr[i]
	}
	arr[i] = key
	QuickSort(arr, 0, i-1)
	QuickSort(arr, i+1, right)
}

//完美排序
//https://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=2651961719&idx=1&sn=b8f2ebe649912e473b94c5fe8f7ed944&chksm=bd2d0cab8a5a85bda04322422b6f00c13aa39012cef3f992cc73607d8cc3fbe3d1a9569f5330&scene=21#wechat_redirect
func  StoogeSort(arr []int, i, j int){

	if (arr[i]>arr[j])  { //交换
		arr[i], arr[j] = arr[j], arr[i]
	}

	if (i+1>=j) { // 是否结束
		return 
	}

	k := (j-i+1)/3 // 三等分

	StoogeSort(arr, i, j-k); // 前2/3半区
	StoogeSort(arr, i+k, j); // 后2/3半区
	StoogeSort(arr, i, j-k); // 前2/3半区

}

/*
func dicsortout(arr []int, now, length int) {
	
	if (now == length){
		fmt.Println(arr)
		return
	}
	
	if now - 1 >= 0{
		mysort := xsort(arr, now-1 ,length)
		for  x := range(mysqort) {
			arr[now-1] = theone
			arr[now: length] = other
			dicsortout( arr, now+1, length)
		}
	}

}
*/