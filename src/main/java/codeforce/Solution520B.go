package main

import (
	"fmt"
)

func main() {

	var m int
	var n int
	fmt.Scanf("%d", &m)
	fmt.Scanf("%d", &n)

	fmt.Print(solve(m, n))
}

func solve(i int, j int) int {

	ans := 0
	for i != j {
		if j > i {
			if j%2 == 0 {
				j = j / 2
				ans++
			} else {
				j++
				ans++
			}

		} else if i > j {
			j++
			ans++
		}
	}
	return ans

}
