package main

import "fmt"

func main() {

	var array = []int{2, 1, 7, 0, 10, 17, 89, 90, 11, 12}
	QuickSort(array, 0, len(array)-1)
	fmt.Println(array)
}

//快速排序
func QuickSort(a []int, left, right int) {

	if left >= right {
		return
	}
	i, j := left, right
	key := a[left]
	for i < j {
		for i < j && key < a[j] {
			j--
		}
		a[i] = a[j]
		for i < j && key >= a[i] {
			i++
		}
		a[j] = a[i]
	}
	a[i] = key
	QuickSort(a, 0, i-1)
	QuickSort(a, i+1, right)
}
