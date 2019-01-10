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
}

//冒泡排序
func BubbleSort(a []int) {
	ilength := len(a)
	for i := 0; i < ilength; i++ {
		for j := ilength - 1; j > i; j-- {
			if a[j] < a[j-1] {
				a[j], a[j-1] = a[j-1], a[j]
			}
		}
	}
}

//选择排序
func SelectenSort(a []int) {

	ilength := len(a)
	if ilength <= 1 {
		return
	}
	for i := 0; i < ilength; i++ {

		minindex := i
		for j := ilength - 1; j > i; j-- {
			if a[j] < a[minindex] {
				minindex = j
			}
		}
		if minindex != i {
			a[minindex], a[i] = a[i], a[minindex]
		}
	}
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
